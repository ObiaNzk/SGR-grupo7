package main;

import constants.Constants;
import documentaciones.DocumentosOperacion;
import dtos.OperacionesDTO;
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
    private List<Double> facturasList;
    private List<String> accionesSgr;
    private TipoDeOperacionEnum tipoDeOperacionEnum;
    private String nombre;
    private Date vigenciaLineaCredito;
    private Empresa empresa;
    private Integer fdr;

    public void AgregarComision (Comision comision){
        this.comisionesList.add(comision);
    }
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

    public List<Double> getFacturasList() {
        return facturasList;
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


    public OperacionesDTO solicitarGarantia(DocumentosOperacion documentosOperacion, Operacion operacion){

        OperacionesDTO responseDTO = new OperacionesDTO();

        if(!validateFacturasVencidasParaOperar()){
            if(!excedeMaximoFDR(this.getFdr(), operacion)) {
                if (lineaDeCreditoIsVigente()) {
                    return this.validateDocumentacion(documentosOperacion);

                } else {
                    responseDTO.setError(Boolean.TRUE);
                    responseDTO.setErrorMessage(Constants.ERROR_LINEA_CRED_VENCIDA);

                }
            }

            responseDTO.setError(Boolean.TRUE);
            responseDTO.setErrorMessage(Constants.ERROR_OPERACION_EXCEDE_FDR);

        } else {
            responseDTO.setError(Boolean.TRUE);
            responseDTO.setErrorMessage(Constants.ERROR_DEBE_FACTURAS);

        }

        return responseDTO;
    }


    public OperacionesDTO validateDocumentacion(DocumentosOperacion documentosOperacion) {

        OperacionesDTO responseDTO = new OperacionesDTO();

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

    public boolean validateFacturasVencidasParaOperar(){

        double montoFacturasVencidas = 0;
        double porcentajeLineaCredito = this.lineaDeCredito.getMonto() * 0.10;

        if(!this.getFacturasList().isEmpty()){
            for(Double facturas : this.getFacturasList()){
                montoFacturasVencidas += facturas;
            }

            if(porcentajeLineaCredito < montoFacturasVencidas){
                return true;
            }
        }
        return false;

    }


}
