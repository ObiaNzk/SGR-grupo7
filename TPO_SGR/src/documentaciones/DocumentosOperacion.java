package documentaciones;

import enums.TipoDeOperacionEnum;
import operaciones.Cheque;
import operaciones.CuentaCorriente;
import operaciones.Pagare;
import operaciones.Prestamo;

public class DocumentosOperacion {
    private String TarjetaDeCredito;
    private Integer Aporte;
    private TipoDeOperacionEnum TipoDeOperacion;
    private Cheque Cheque;
    private Pagare Pagare;
    private CuentaCorriente CuentaCorriente;
    private Prestamo Prestamo;

    public String getTarjetaDeCredito() {
        return TarjetaDeCredito;
    }

    public Integer getAporte() {
        return Aporte;
    }

    public TipoDeOperacionEnum getTipoDeOperacion() {
        return TipoDeOperacion;
    }

    public operaciones.Cheque getCheque() {
        return Cheque;
    }

    public operaciones.Pagare getPagare() {
        return Pagare;
    }

    public operaciones.CuentaCorriente getCuentaCorriente() {
        return CuentaCorriente;
    }

    public operaciones.Prestamo getPrestamo() {
        return Prestamo;
    }
}
