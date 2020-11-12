package main;

import constants.Constants;
import documentaciones.DocumentosOperacion;
import dtos.SolicitudGarantiaDTO;
import enums.TipoDeOperacionEnum;
import enums.TipoDeSocio;
import operaciones.Comision;
import operaciones.ContraGarantia;
import operaciones.LineaDeCredito;

import java.util.Date;
import java.util.List;

public class Socio {

    private TipoDeSocio tipoDeSocio;
    private List<ContraGarantia> contraGarantiaList;
    private LineaDeCredito lineaDeCredito;
    private List<Comision> comisionesList;
    private List<Operacion> operacionList;
    private List<String> facturasList;
    private List<String> accionesSgr;
    private TipoDeOperacionEnum tipoDeOperacionEnum;
    private String nombre;
    private Date vigenciaLineaCredito;
    private Empresa empresa;
    private Integer fdr;


    public List<Operacion> getOperacionList() {
        return operacionList;
    }

    public List<String> getAccionesSgr() {
        return accionesSgr;
    }

    public TipoDeOperacionEnum getTipoDeOperacionEnum() {
        return tipoDeOperacionEnum;
    }

    public String getNombre() {
        return nombre;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public LineaDeCredito getLineaDeCredito() {
        return lineaDeCredito;
    }

    public Integer getFdr() {
        return fdr;
    }

    public void setLineaDeCredito(LineaDeCredito lineaDeCredito) {
        this.lineaDeCredito = lineaDeCredito;
    }

    public boolean lineaDeCreditoIsVigente(){
        Date date = new Date();
            if(date.after(this.lineaDeCredito.getFechaVencimiento())) {
                return true;
            }
            return false;
    }

    public boolean excedeMaximoFDR(Integer FDR, Operacion operacion){

        double porcentajeFdr = this.getFdr() * 0.05;

        if( porcentajeFdr < operacion.getMonto() ){
            return true;
        }
        return false;
    }


    public SolicitudGarantiaDTO solicitarGarantia(DocumentosOperacion documentosOperacion, Operacion operacion){

        SolicitudGarantiaDTO responseDTO = new SolicitudGarantiaDTO();
        if(!excedeMaximoFDR(this.getFdr(), operacion)) {
            if (lineaDeCreditoIsVigente()) {
                return this.validateDocumentacion(documentosOperacion);

            } else {
                responseDTO.setError(Boolean.TRUE);
                responseDTO.setErrorMessage(Constants.ERROR_LINEA_CRED_VENCIDA);
                return responseDTO;
            }
        }

        responseDTO.setError(Boolean.TRUE);
        responseDTO.setErrorMessage(Constants.ERROR_OPERACION_EXCEDE_FDR);
        return responseDTO;

    }


    public SolicitudGarantiaDTO validateDocumentacion(DocumentosOperacion documentosOperacion) {

        SolicitudGarantiaDTO responseDTO = new SolicitudGarantiaDTO();

            if (TipoDeOperacionEnum.TIPO1.equals(documentosOperacion.getTipoDeOperacion())) {
                if (documentosOperacion.getCheque().validateDocumentacionCompleta()) {
                    responseDTO.setError(Boolean.FALSE);
                    responseDTO.setMesagge(Constants.SOLICITUD_EXITOSA);
                    return responseDTO;
                }

                responseDTO.setError(Boolean.TRUE);
                responseDTO.setErrorMessage(Constants.ERROR_FALTA_DOCUMENTACION);

            } else if (TipoDeOperacionEnum.TIPO2.equals(documentosOperacion.getTipoDeOperacion())) {
                if (documentosOperacion.getCuentaCorriente().validateDocumentacionCompleta()) {
                    responseDTO.setError(Boolean.FALSE);
                    responseDTO.setMesagge(Constants.SOLICITUD_EXITOSA);
                    return responseDTO;
                }

                responseDTO.setError(Boolean.TRUE);
                responseDTO.setErrorMessage(Constants.ERROR_FALTA_DOCUMENTACION);

            } else {
                if (documentosOperacion.getPrestamo().validateDocumentacionCompleta()) {
                    responseDTO.setError(Boolean.FALSE);
                    responseDTO.setMesagge(Constants.SOLICITUD_EXITOSA);
                    return responseDTO;
                }

                responseDTO.setError(Boolean.TRUE);
                responseDTO.setErrorMessage(Constants.ERROR_FALTA_DOCUMENTACION);
            }

        return responseDTO;
    }


}
