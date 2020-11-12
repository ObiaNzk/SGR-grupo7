package operaciones;

import java.util.Date;

public class LineaDeCredito {

    private Integer monto;
    private Date fechaVencimiento;
    private boolean aprobada;

    public LineaDeCredito(Integer monto, Date fechaVencimiento) {
        this.monto = monto;
        this.fechaVencimiento = fechaVencimiento;
    }

    public LineaDeCredito() {

    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public boolean isAprobada() {
        return aprobada;
    }

    public void setAprobada(boolean aprobada) {
        this.aprobada = aprobada;
    }
}
