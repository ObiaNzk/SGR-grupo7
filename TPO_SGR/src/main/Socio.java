package main;

import enums.TipoDeOperacionEnum;
import enums.TipoDeSocio;
import operaciones.Comisiones;
import operaciones.ContraGarantia;

import java.util.Date;
import java.util.List;

public class Socio {

    private TipoDeSocio tipoDeSocio;
    private List<ContraGarantia> contraGarantiaList;
    private Integer lineaDeCredito;
    private List<Comisiones> comisionesList;
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
}
