package operaciones;

import enums.ComisionEstadoEnum;
import enums.EstadoOperacionEnum;
import enums.TipoDeOperacionEnum;
import main.Operacion;

import java.util.Date;

public class Comision {
    private TipoDeOperacionEnum TipoDeOperacion;
    private Date FechaCreacion;
    private Date FechaFacturacion;
    private Integer Comision;
    private float Monto;
    private ComisionEstadoEnum Estado;

    public Comision(){

    }
    public Comision(Operacion operacion){
        Integer comision = getComisionPorTipo(operacion.getTipoDeOperacion());
        this.Comision = comision;
        this.TipoDeOperacion = operacion.getTipoDeOperacion();
        this.FechaCreacion = new Date();
        this.Monto = (float)comision/operacion.getMonto();
        this.Estado = ComisionEstadoEnum.CALCULADO;
    }
    public TipoDeOperacionEnum getTipoDeOperacion() {
        return TipoDeOperacion;
    }

    public Date getFechaCreacion() {
        return FechaCreacion;
    }

    public Date getFechaFacturacion() {
        return FechaFacturacion;
    }

    public Integer getComision() {
        return Comision;
    }

    public float getMonto() {
        return Monto;
    }

    public ComisionEstadoEnum getEstado() {
        return Estado;
    }

    public void setEstado(ComisionEstadoEnum estado) {
        Estado = estado;
    }
    public void setFechaFacturacion(Date fechaFacturacion) {
        FechaFacturacion = fechaFacturacion;
    }
    public Integer getComisionPorTipo(TipoDeOperacionEnum tipoDeOperacion){
        return (tipoDeOperacion == TipoDeOperacionEnum.TIPO1 || tipoDeOperacion == TipoDeOperacionEnum.TIPO2 ) ? 3 : 4;
    }

    @Override
    public String toString() {
        return "Comision{" +
                "FechaFacturacion=" + FechaFacturacion +
                ", Comision=" + Comision +
                ", Monto=" + Monto +
                '}';
    }
}
