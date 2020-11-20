package operaciones;

import Interfaces.IDocumentosOperacion;

import java.util.Date;

public class Cheque implements IDocumentosOperacion {

    private String NombreBanco;
    private String NumeroCheque;
    private Date FechaVencimiento;
    private String Cuit;
    private Integer Monto;

    public Cheque(String nombreBanco, String numero, Date fecha, String cuit, Integer monto) {
        this.NombreBanco = nombreBanco;
        this.NumeroCheque = numero;
        this.FechaVencimiento = fecha;
        this.Cuit = cuit;
        this.Monto = monto;
    }

    public Cheque(){

    }

    public boolean validateDocumentacionCompleta(){
       if((this.getCuit() != null && !this.getCuit().isEmpty()) && (this.getFechaVencimiento() != null)
           && (this.getMonto() != null) && (this.getNombreBanco() != null && !this.getNombreBanco().isEmpty())
           && (this.getNumeroCheque() != null & !this.getNumeroCheque().isEmpty())){
           return true;
       }
    return false;
    }

    public String getNombreBanco() {
        return NombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.NombreBanco = nombreBanco;
    }

    public String getNumeroCheque() {
        return NumeroCheque;
    }

    public void setNumeroCheque(String numeroCheque) {
        this.NumeroCheque = numeroCheque;
    }

    public Date getFechaVencimiento() {
        return FechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.FechaVencimiento = fechaVencimiento;
    }

    public String getCuit() {
        return Cuit;
    }

    public void setCuit(String cuit) {
        this.Cuit = cuit;
    }

    public Integer getMonto() {
        return Monto;
    }

    public void setMonto(Integer monto) {
        this.Monto = monto;
    }
}
