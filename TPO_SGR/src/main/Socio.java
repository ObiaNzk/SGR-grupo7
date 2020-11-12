package main;

import enums.TipoDeOperacionEnum;
import enums.TipoDeSocio;
import operaciones.Comision;
import operaciones.ContraGarantia;

import java.util.Date;
import java.util.List;

public class Socio {

    private TipoDeSocio tipoDeSocio;
    private List<ContraGarantia> contraGarantiaList;
    private Integer lineaDeCredito;
    private List<Comision> comisionesList;
    private List<Operacion> operacionList;
    private List<String> facturasList;
    private List<String> accionesSgr;
    private TipoDeOperacionEnum tipoDeOperacionEnum;
    private String nombre;
    private Date vigenciaLineaCredito;
    private Empresa empresa;


    public Integer getLineaDeCredito() {
        return lineaDeCredito;
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

    public void setLineaDeCredito(Integer lineaDeCredito) {
        this.lineaDeCredito = lineaDeCredito;
    }

    public List<Comision> getComisionesList() {
        return comisionesList;
    }

    public void AddComision(Comision comision) {
        this.comisionesList.add(comision);
    }

    public void setOperacionList(List<Operacion> operacionList) {
        this.operacionList = operacionList;
    }

    public List<String> getFacturasList() {
        return facturasList;
    }

    public void setFacturasList(List<String> facturasList) {
        this.facturasList = facturasList;
    }

    public void setAccionesSgr(List<String> accionesSgr) {
        this.accionesSgr = accionesSgr;
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
}
