package main;

public class Accionista {

    private String cuit;
    private String razonSocial;
    private String porcentajeParticipacion;


    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getPorcentajeParticipacion() {
        return porcentajeParticipacion;
    }

    public void setPorcentajeParticipacion(String porcentajeParticipacion) {
        this.porcentajeParticipacion = porcentajeParticipacion;
    }
}
