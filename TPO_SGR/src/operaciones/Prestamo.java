package operaciones;

import enums.SistemaPrestamoEnum;

import java.util.Date;
import java.util.List;

public class Prestamo {
    private String Banco;
    private Integer Monto;
    private Integer tasa;
    private Date FechaAcreditacion;
    private List<Cuota> cuotas;
    private SistemaPrestamoEnum sistema;

    public String getBanco() {
        return Banco;
    }

    public Integer getMonto() {
        return Monto;
    }

    public Integer getTasa() {
        return tasa;
    }

    public Date getFechaAcreditacion() {
        return FechaAcreditacion;
    }

    public List<Cuota> getCuotas() {
        return cuotas;
    }

    public SistemaPrestamoEnum getSistema() {
        return sistema;
    }
}
