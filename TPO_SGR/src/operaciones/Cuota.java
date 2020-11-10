package operaciones;

import java.util.Date;

public class Cuota {
    private Integer Monto;
    private Date FechaVencimiento;
    private boolean Pagado;

    public Integer getMonto() {
        return Monto;
    }

    public Date getFechaVencimiento() {
        return FechaVencimiento;
    }

    public boolean isPagado() {
        return Pagado;
    }
}
