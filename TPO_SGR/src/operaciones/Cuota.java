package operaciones;

import java.util.Date;

public class Cuota {
    private float Monto;
    private Date FechaVencimiento;
    private boolean Pagado;

    public Cuota(float monto, Date fechaVencimiento, boolean pagado){
        this.Monto = monto;
        this.FechaVencimiento = fechaVencimiento;
        this.Pagado = pagado;
    }
    public float getMonto() {
        return Monto;
    }

    public Date getFechaVencimiento() {
        return FechaVencimiento;
    }

    public boolean isPagado() {
        return Pagado;
    }

    public void setMonto(Integer monto) {
        Monto = monto;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        FechaVencimiento = fechaVencimiento;
    }

    public void setPagado(boolean pagado) {
        Pagado = pagado;
    }

    @Override
    public String toString() {
        String pagadoText = this.Pagado ? "Si" : "No";
        return " Monto: " + "["+this.Monto+"]" +"   Vence el: " + "["+this.FechaVencimiento+"]"+" Esta Pagado: "+"["+pagadoText+"]";
    }
}
