package operaciones;

import Interfaces.IDocumentosOperacion;

import java.util.Date;

public class Aporte implements IDocumentosOperacion {
    Integer Monto;
    Date FechaVencimiento;

    public Aporte(Integer monto, Date fechaVencimiento){
        this.Monto = monto;
        this.FechaVencimiento = fechaVencimiento;
    }

    public Integer getMonto() {
        return Monto;
    }

    public void setMonto(Integer monto) {
        Monto = monto;
    }

    public Date getFechaVencimiento() {
        return FechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        FechaVencimiento = fechaVencimiento;
    }
}
