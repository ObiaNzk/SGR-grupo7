package main;

import documentaciones.DocumentosOperacion;
import enums.EstadoOperacionEnum;
import enums.TipoDeOperacionEnum;

import java.util.Date;

public class Operacion {

    private EstadoOperacionEnum EstadoOperacion;
    private TipoDeOperacionEnum TipoDeOperacion;
    private Date FechaIngresado;
    private Date FechaMonetizado;
    private Date FechaVencimiento;
    private Integer Monto;
    private Integer MontoUtilizado;
    private String NumeroCertificadoGarantia;
    private Integer TasaDeDescuento;
    private DocumentosOperacion documentosOperacion;

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

    public DocumentosOperacion getDocumentosOperacion() {
        return documentosOperacion;
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
}
