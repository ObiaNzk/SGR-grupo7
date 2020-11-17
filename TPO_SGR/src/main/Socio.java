package main;

import constants.Constants;
import documentaciones.DocumentosOperacion;
import dtos.OperacionesDTO;
import enums.TipoDeOperacionEnum;
import enums.TipoDeSocio;
import operaciones.Comision;
import operaciones.ContraGarantia;
import operaciones.LineaDeCredito;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Socio {

    private TipoDeSocio tipoDeSocio;
    private List<ContraGarantia> contraGarantiaList;
    private LineaDeCredito lineaDeCredito;
    private List<Comision> comisionesList;
    private List<Operacion> operacionList;
    private List<Double> facturasList;
    private List<String> accionesSgrA;
    private List<String> accionesSgrB;
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
    public void ComprarAcciones (List<String> acciones){
        if(this.tipoDeSocio == TipoDeSocio.PARTICIPE) {
            this.accionesSgrA.addAll(acciones);
        }else{
            this.accionesSgrB.addAll(acciones);
        }


    }

    public List<String> VenderAcciones(Integer cantidadDeAcciones) {
        List<String> acciones = new ArrayList<String>();
        for (int i = 0; i < cantidadDeAcciones; ++i) {
            if(this.tipoDeSocio == TipoDeSocio.PARTICIPE) {
                acciones.add(this.accionesSgrA.remove(i));
            }else{
                acciones.add(this.accionesSgrB.remove(i));
            }
        }
        return acciones;
    }

    public TipoDeSocio getTipoDeSocio() {
        return tipoDeSocio;
    }

    public void setTipoDeSocio(TipoDeSocio tipoDeSocio) {
        this.tipoDeSocio = tipoDeSocio;
    }

    public List<ContraGarantia> getContraGarantiaList() {
        return contraGarantiaList;
    }

    public void setContraGarantiaList(List<ContraGarantia> contraGarantiaList) {
        this.contraGarantiaList = contraGarantiaList;
    }

    public List<Comision> getComisionesList() {
        return comisionesList;
    }

    public void setComisionesList(List<Comision> comisionesList) {
        this.comisionesList = comisionesList;
    }

    public void setOperacionList(List<Operacion> operacionList) {
        this.operacionList = operacionList;
    }

    public void setFacturasList(List<Double> facturasList) {
        this.facturasList = facturasList;
    }

    public void setTipoDeOperacionEnum(TipoDeOperacionEnum tipoDeOperacionEnum) {
        this.tipoDeOperacionEnum = tipoDeOperacionEnum;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getVigenciaLineaCredito() {
        return vigenciaLineaCredito;
    }

    public void setVigenciaLineaCredito(Date vigenciaLineaCredito) {
        this.vigenciaLineaCredito = vigenciaLineaCredito;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void setFdr(Integer fdr) {
        this.fdr = fdr;
    }

    public List<String> getAccionesSgrA() {
        return accionesSgrA;
    }

    public void setAccionesSgrA(List<String> accionesSgrA) {
        this.accionesSgrA = accionesSgrA;
    }

    public List<String> getAccionesSgrB() {
        return accionesSgrB;
    }

    public void setAccionesSgrB(List<String> accionesSgrB) {
        this.accionesSgrB = accionesSgrB;
    }
}
