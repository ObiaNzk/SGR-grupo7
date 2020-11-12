package operaciones;

import java.util.Date;

public class CuentaCorriente {

    private String cuit;
    private Integer importeTotal;
    private Date fecha;

    public CuentaCorriente(String cuit, Integer importeTotal, Date fecha) {
        this.cuit = cuit;
        this.importeTotal = importeTotal;
        this.fecha = fecha;
    }

    public CuentaCorriente(){

    }

    public boolean validateDocumentacionCompleta(){
        if((this.getCuit() != null & !this.getCuit().isEmpty()) && (this.getImporteTotal() != null)
            && (this.getFecha() != null)) {
            return true;
        }
        return false;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public Integer getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(Integer importeTotal) {
        this.importeTotal = importeTotal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
