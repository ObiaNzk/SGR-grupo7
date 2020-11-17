package operaciones;

import java.util.Date;

public class Cheque {

    private String nombreBanco;
    private String numero;
    private Date fecha;
    private String cuit;
    private Integer monto;

    public Cheque(String nombreBanco, String numero, Date fecha, String cuit, Integer monto) {
        this.nombreBanco = nombreBanco;
        this.numero = numero;
        this.fecha = fecha;
        this.cuit = cuit;
        this.monto = monto;
    }

    public Cheque(){

    }

    public boolean validateDocumentacionCompleta(){
       if((this.getCuit() != null && !this.getCuit().isEmpty()) && (this.getFecha() != null)
           && (this.getMonto() != null) && (this.getNombreBanco() != null && !this.getNombreBanco().isEmpty())
           && (this.getNumero() != null & !this.getNumero().isEmpty())){
           return true;
       }
    return false;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }
}
