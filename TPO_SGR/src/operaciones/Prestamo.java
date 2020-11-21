package operaciones;

import Interfaces.IDocumentosOperacion;
import enums.SistemaPrestamoEnum;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Prestamo implements IDocumentosOperacion {
    private String Banco;
    private Integer Monto;
    private Integer tasa;
    private Date FechaAcreditacion;
    private List<Cuota> cuotas;
    private SistemaPrestamoEnum sistema;

    public Prestamo(String banco, Integer monto, Integer tasa, Date fechaAcreditacion, List<Cuota> cuotas, SistemaPrestamoEnum sistema) {
        Banco = banco;
        Monto = monto;
        this.tasa = tasa;
        FechaAcreditacion = fechaAcreditacion;
        this.cuotas = cuotas;
        this.sistema = sistema;
    }

    public boolean validateDocumentacionCompleta(){
        if((this.getBanco() != null && !this.getBanco().isEmpty()) && (this.getMonto() != null) &&
                (this.getTasa() != null) && (this.getFechaAcreditacion() != null) && (!this.getCuotas().isEmpty())
                && (this.getSistema() != null)){
            return true;
        }
        return false;
    }

    public String getBanco() {
        return Banco;
    }

    public void setBanco(String banco) {
        Banco = banco;
    }

    public Integer getMonto() {
        return Monto;
    }

    public void setMonto(Integer monto) {
        Monto = monto;
    }

    public Integer getTasa() {
        return tasa;
    }

    public void setTasa(Integer tasa) {
        this.tasa = tasa;
    }

    public Date getFechaAcreditacion() {
        return FechaAcreditacion;
    }

    public void setFechaAcreditacion(Date fechaAcreditacion) {
        FechaAcreditacion = fechaAcreditacion;
    }

    public List<Cuota> getCuotas() {
        return cuotas;
    }

    public List<Cuota> getCuotas(boolean pagadas) {
        List<Cuota> resultado = new ArrayList<Cuota>();
        for (Cuota cuota: this.cuotas){
            if (pagadas && cuota.isPagado()){
                resultado.add(cuota);
            }else if (!pagadas && !cuota.isPagado()){
                resultado.add(cuota);
            }
        }
        return resultado;
    }


    public void setCuotas(List<Cuota> cuotas) {
        this.cuotas = cuotas;
    }

    public SistemaPrestamoEnum getSistema() {
        return sistema;
    }

    public void setSistema(SistemaPrestamoEnum sistema) {
        this.sistema = sistema;
    }
}
