package documentaciones;

import enums.EstadoDocumentacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DocumentosRegistracion {

    private String estatuto;
    private String balanceCertificado1;
    private String balanceCertificado2;
    private String balanceCertificado3;
    private List<String> bienesSocios;
    private Date fechaDeRecepcion;
    private EstadoDocumentacion estadoDocumentacion;
    private String usuarioCredor;

    public void setDocumentosRegistracion(EstadoDocumentacion estadoDocumentacion, String balanceCertificado1, String balanceCertificado2,
                                          String balanceCertificado3, String bienesSocios){
        this.estadoDocumentacion = estadoDocumentacion;
        this.balanceCertificado1 = balanceCertificado1;
        this.balanceCertificado2 = balanceCertificado2;
        this.balanceCertificado3 = balanceCertificado3;
        this.bienesSocios.add(bienesSocios);

    }

    public void setFechaDeRecepcion(Date fechaDeRecepcion) {
        this.fechaDeRecepcion = fechaDeRecepcion;
    }

    public void setEstadoDocumentacion(EstadoDocumentacion estadoDocumentacion) {
        this.estadoDocumentacion = estadoDocumentacion;
    }

    public String getEstatuto() {
        return estatuto;
    }

    public void setEstatuto(String estatuto) {
        this.estatuto = estatuto;
    }

    public List<String> getBienesSocios() {
        return bienesSocios;
    }

    public void setBienesSocios(List<String> bienesSocios) {
        this.bienesSocios = bienesSocios;
    }

    public void setUsuarioCredor(String usuarioCredor) {
        this.usuarioCredor = usuarioCredor;
    }

    public String getBalanceCertificado1() {
        return balanceCertificado1;
    }

    public void setBalanceCertificado1(String balanceCertificado1) {
        this.balanceCertificado1 = balanceCertificado1;
    }

    public String getBalanceCertificado2() {
        return balanceCertificado2;
    }

    public void setBalanceCertificado2(String balanceCertificado2) {
        this.balanceCertificado2 = balanceCertificado2;
    }

    public String getBalanceCertificado3() {
        return balanceCertificado3;
    }

    public void setBalanceCertificado3(String balanceCertificado3) {
        this.balanceCertificado3 = balanceCertificado3;
    }

    public Date getFechaDeRecepcion() {
        return fechaDeRecepcion;
    }

    public EstadoDocumentacion getEstadoDocumentacion() {
        return estadoDocumentacion;
    }

    public String getUsuarioCredor() {
        return usuarioCredor;
    }

    public List<String> getBalances(){
        List<String> balancesList = new ArrayList<>();
        balancesList.add(balanceCertificado1);
        balancesList.add(balanceCertificado2);
        balancesList.add(balanceCertificado3);

        return balancesList;
    }

    //TODO
    //FALTA DESARROLLAR
    public boolean documentosCompletos(){

        return true;
    }
}
