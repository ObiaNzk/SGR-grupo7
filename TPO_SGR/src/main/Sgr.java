package main;

import documentaciones.DocumentosOperacion;
import enums.TamañoEmpresaEnum;
import enums.TipoDeOperacionEnum;
import operaciones.Comisiones;
import operaciones.ContraGarantia;

import java.util.Date;
import java.util.List;

public class Sgr {

    private String nombre;
    private List<Socio> sociosProtectores;
    private List<Socio> sociosParticipes;

    public void agregarSocio(Socio socio){

    }

    public void asignarLineaCredito(Socio socio){

    }

    public void setContragarantia(Socio socio, ContraGarantia contraGarantia){

    }

    public Operacion solicitarOperacion(Socio socio, DocumentosOperacion documentosOperacion){
        return null;
    }

    public void monetizarOperacion(Operacion operacion){

    }

    public Comisiones calcularComision(Operacion operacion, Socio socio){
        return null;
    }

    public void emitirFactura(Socio socio){

    }

    public void getLineaCredito(Socio socio){

    }

    public void crearDesembolso(Socio socio, int monto){

    }

    //REVISAR EN DIAGRAMA
    public void venderAcciones(){

    }

    public List<Comisiones> comisionesEnunDia(Date fecha){
        return null;
    }

    public List<Operacion> operacionesDeSocio(String nombre, Date fechaDesde, Date fechaHasta){
        return null;
    }

    public Integer getPorcentajeDeComision(TipoDeOperacionEnum tipoDeOperacionEnum){
        return null;
    }

    public void consultaConsolidada(){

    }

    public double promedioTasaDescuentoYTotalOperado(TamañoEmpresaEnum tamañoEmpresaEnum, Date fechaDesde, Date fechaHasta){
        return 123;
    }

}
