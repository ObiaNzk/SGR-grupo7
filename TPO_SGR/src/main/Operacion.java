package main;

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
}
