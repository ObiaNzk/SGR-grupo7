package operaciones;

import Interfaces.IDocumentosOperacion;

import java.util.Date;

public class CuentaCorriente implements IDocumentosOperacion {

    private Integer importeTotal;
    private Date fecha;

    public CuentaCorriente(Integer importeTotal, Date fecha) {
        this.importeTotal = importeTotal;
        this.fecha = fecha;
    }

    public CuentaCorriente(){

    }

    public boolean validateDocumentacionCompleta(){
        if((this.getImporteTotal() != null)
            && (this.getFecha() != null)) {
            return true;
        }
        return false;
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
