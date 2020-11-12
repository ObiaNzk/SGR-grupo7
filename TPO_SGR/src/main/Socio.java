package main;

import documentaciones.DocumentosOperacion;
import dtos.LineaDeCreditoDTO;
import enums.TipoDeOperacionEnum;
import enums.TipoDeSocio;
import operaciones.Cheque;
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

        double porcentajeOperacion = operacion.getMonto() * 0.05;

        if( FDR > porcentajeOperacion ){
            return true;
        }
        return false;
    }


    public LineaDeCreditoDTO solicitarGarantia(DocumentosOperacion documentosOperacion){

        LineaDeCreditoDTO responseDTO = new LineaDeCreditoDTO();

        if(lineaDeCreditoIsVigente()) {
            return this.validateDocumentacion(documentosOperacion);

        } else {
            responseDTO.setError(Boolean.TRUE);
            responseDTO.setErrorMesagge("Linea de credito vencida");
            return responseDTO;
        }

    }


    public LineaDeCreditoDTO validateDocumentacion(DocumentosOperacion documentosOperacion) {

        LineaDeCreditoDTO responseDTO = new LineaDeCreditoDTO();

            if (TipoDeOperacionEnum.TIPO1.equals(documentosOperacion.getTipoDeOperacion())) {
                if (documentosOperacion.getCheque().validateDocumentacionCompleta()) {
                    responseDTO.setError(Boolean.FALSE);
                    responseDTO.setErrorMesagge("Solicitud de contragarantia exitosa");
                    return responseDTO;
                }

                responseDTO.setError(Boolean.TRUE);
                responseDTO.setErrorMesagge("Por favor verifique la documentación faltante");

            } else if (TipoDeOperacionEnum.TIPO2.equals(documentosOperacion.getTipoDeOperacion())) {
                if (documentosOperacion.getCuentaCorriente().validateDocumentacionCompleta()) {
                    responseDTO.setError(Boolean.FALSE);
                    responseDTO.setErrorMesagge("Solicitud de contragarantia exitosa");
                    return responseDTO;
                }

                responseDTO.setError(Boolean.TRUE);
                responseDTO.setErrorMesagge("Por favor verifique la documentación faltante");

            } else {
                if (documentosOperacion.getPrestamo().validateDocumentacionCompleta()) {
                    responseDTO.setError(Boolean.FALSE);
                    responseDTO.setErrorMesagge("Solicitud de contragarantia exitosa");
                    return responseDTO;
                }

                responseDTO.setError(Boolean.TRUE);
                responseDTO.setErrorMesagge("Por favor verifique la documentación faltante");
            }

        return responseDTO;
    }


}
