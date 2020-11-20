package main;

import constants.Constants;
import documentaciones.DocumentosOperacion;
import dtos.OperacionesDTO;
import enums.TipoDeOperacionEnum;
import enums.TipoDeSocio;
import operaciones.Aporte;
import operaciones.Comision;
import operaciones.LineaDeCredito;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Socio {

    private TipoDeSocio TipoDeSocio;
    private LineaDeCredito LineaDeCredito;
    private float lineaUtilizada;
    private List<Comision> ComisionesList;
    private List<Operacion> OperacionList;
    private List<Double> FacturasList;
    private List<String> AccionesSgrA;
    private List<String> AccionesSgrB;
    private List<Aporte> Aportes;
    private TipoDeOperacionEnum TipoDeOperacionEnum;
    private String Nombre;
    private Empresa Empresa;

    public Socio(){
        this.ComisionesList = new ArrayList<Comision>();
        this.OperacionList = new ArrayList<Operacion>();
        this.Aportes = new ArrayList<Aporte>();
    }
    public void AgregarOperacion (Operacion operacion) {this.OperacionList.add(operacion);}
    public void AgregarComision (Comision comision){
        this.ComisionesList.add(comision);
    }
    public List<Operacion> getOperacionList() {
        return OperacionList;
    }

    public TipoDeOperacionEnum getTipoDeOperacionEnum() {
        return TipoDeOperacionEnum;
    }

    public String getNombre() {
        return Nombre;
    }

    public Empresa getEmpresa() {
        return Empresa;
    }

    public LineaDeCredito getLineaDeCredito() {
        return LineaDeCredito;
    }


    public List<Double> getFacturasList() {
        return FacturasList;
    }

    public void setLineaDeCredito(LineaDeCredito lineaDeCredito) {
        this.LineaDeCredito = lineaDeCredito;
    }

    public boolean lineaDeCreditoIsVigente(){
        Date date = new Date();
            if(date.after(this.LineaDeCredito.getFechaVencimiento())) {
                return true;
            }
            return false;
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
        double porcentajeLineaCredito = this.LineaDeCredito.getMonto() * 0.10;

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
        if(this.TipoDeSocio == TipoDeSocio.PARTICIPE) {
            this.AccionesSgrA.addAll(acciones);
        }else{
            this.AccionesSgrB.addAll(acciones);
        }


    }

    public List<String> VenderAcciones(Integer cantidadDeAcciones) {
        List<String> acciones = new ArrayList<String>();
        for (int i = 0; i < cantidadDeAcciones; ++i) {
            if(this.TipoDeSocio == TipoDeSocio.PARTICIPE) {
                acciones.add(this.AccionesSgrA.remove(i));
            }else{
                acciones.add(this.AccionesSgrB.remove(i));
            }
        }
        return acciones;
    }

    public TipoDeSocio getTipoDeSocio() {
        return TipoDeSocio;
    }

    public void setTipoDeSocio(TipoDeSocio tipoDeSocio) {
        this.TipoDeSocio = tipoDeSocio;
    }

    public List<Comision> getComisionesList() {
        return ComisionesList;
    }

    public void setComisionesList(List<Comision> comisionesList) {
        this.ComisionesList = comisionesList;
    }

    public void setOperacionList(List<Operacion> operacionList) {
        this.OperacionList = operacionList;
    }

    public void setFacturasList(List<Double> facturasList) {
        this.FacturasList = facturasList;
    }

    public void setTipoDeOperacionEnum(TipoDeOperacionEnum tipoDeOperacionEnum) {
        this.TipoDeOperacionEnum = tipoDeOperacionEnum;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public void setEmpresa(Empresa empresa) {
        this.Empresa = empresa;
    }

    public List<String> getAccionesSgrA() {
        return AccionesSgrA;
    }

    public void setAccionesSgrA(List<String> accionesSgrA) {
        this.AccionesSgrA = accionesSgrA;
    }

    public List<String> getAccionesSgrB() {
        return AccionesSgrB;
    }

    public void setAccionesSgrB(List<String> accionesSgrB) {
        this.AccionesSgrB = accionesSgrB;
    }

    @Override
    public String toString() {
        return "Nombre: " + Nombre +
                "   Tipo: " + TipoDeSocio;

    }
}
