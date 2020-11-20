package main;

import Interfaces.IDocumentosOperacion;
import documentaciones.DocumentosOperacion;
import enums.EstadoOperacionEnum;
import enums.TipoDeOperacionEnum;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Operacion {

    private EstadoOperacionEnum EstadoOperacion;
    private TipoDeOperacionEnum TipoDeOperacion;
    private Date FechaIngresado;
    private Date FechaMonetizado;
    private Date FechaVencimiento;
    private Integer Monto;
    private Integer MontoUtilizado = 0;
    private String NumeroCertificadoGarantia;
    private Integer TasaDeDescuento;
    private IDocumentosOperacion DocumentosOperacion;

    public Operacion(){}
    public Operacion(TipoDeOperacionEnum tipoDeOperacion, Date fechaIngresado, Date fechaVencimiento, Integer monto, IDocumentosOperacion documentoOperacion){
        this.TipoDeOperacion = tipoDeOperacion;
        this.FechaIngresado = fechaIngresado;
        this.FechaVencimiento = fechaVencimiento;
        this.Monto = monto;
        this.DocumentosOperacion = documentoOperacion;
        this.EstadoOperacion = EstadoOperacionEnum.CON_CERTIFICADO_EMITIDO;
        this.NumeroCertificadoGarantia = String.valueOf(ThreadLocalRandom.current().nextInt(1,999999));
    }
    public TipoDeOperacionEnum getTipoDeOperacion() {
        return TipoDeOperacion;
    }
    public Date getFechaIngresado() {
        return FechaIngresado;
    }

    public Date getFechaMonetizado() {
        return FechaMonetizado;
    }
    public EstadoOperacionEnum getEstadoOperacion() {
        return EstadoOperacion;
    }
    public Date getFechaVencimiento() {
        return FechaVencimiento;
    }

    public Integer getMonto() {
        return Monto;
    }

    public String getNumeroCertificadoGarantia() {
        return NumeroCertificadoGarantia;
    }

    public Integer getTasaDeDescuento() {
        return TasaDeDescuento;
    }

    public Integer getMontoUtilizado() {
        return MontoUtilizado;
    }

    public void setMontoUtilizado(Integer montoUtilizado) {
        MontoUtilizado = montoUtilizado;
    }

    public void setEstadoOperacion(EstadoOperacionEnum estadoOperacion) {
        EstadoOperacion = estadoOperacion;
    }

    public void setFechaMonetizado(Date fechaMonetizado) {
        FechaMonetizado = fechaMonetizado;
    }

    public void setNumeroCertificadoGarantia(String numeroCertificadoGarantia) {
        NumeroCertificadoGarantia = numeroCertificadoGarantia;
    }

    public void setTasaDeDescuento(Integer tasaDeDescuento) {
        TasaDeDescuento = tasaDeDescuento;
    }

    public void setTipoDeOperacion(TipoDeOperacionEnum tipoDeOperacion) {
        TipoDeOperacion = tipoDeOperacion;
    }

    public void setFechaIngresado(Date fechaIngresado) {
        FechaIngresado = fechaIngresado;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        FechaVencimiento = fechaVencimiento;
    }

    public void setMonto(Integer monto) {
        Monto = monto;
    }

    @Override
    public String toString() {
        return " Tipo de operacion: " + "["+TipoDeOperacion+"]" +"   Monto Utilizado: " + "["+MontoUtilizado+"]"+" Monto Total: "+"["+Monto+"]" + " Estado de la Operacion: " + "["+EstadoOperacion+"]";
    }

    public IDocumentosOperacion getDocumentosOperacion() {
        return DocumentosOperacion;
    }

    public void setDocumentosOperacion(IDocumentosOperacion documentosOperacion) {
        DocumentosOperacion = documentosOperacion;
    }
}
