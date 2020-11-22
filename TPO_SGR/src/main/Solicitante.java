package main;

import documentaciones.DocumentosRegistracion;
import enums.EstadoDocumentacion;
import enums.TipoDeSocio;

public class Solicitante {

    private Empresa empresa;
    private DocumentosRegistracion documentacionRegistracion;
    private EstadoDocumentacion estadoDocumentacion;
    private TipoDeSocio tipoDeSocio;

    public DocumentosRegistracion getDocumentacionRegistracion() {
        return documentacionRegistracion;
    }

    public void setDocumentacionRegistracion(DocumentosRegistracion documentacionRegistracion) {
        this.documentacionRegistracion = documentacionRegistracion;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public EstadoDocumentacion getEstadoDocumentacion() {
        return estadoDocumentacion;
    }

    public void setEstadoDocumentacion(EstadoDocumentacion estadoDocumentacion) {
        this.estadoDocumentacion = estadoDocumentacion;
    }

    public TipoDeSocio getTipoDeSocio() {
        return tipoDeSocio;
    }

    public void setTipoDeSocio(TipoDeSocio tipoDeSocio) {
        this.tipoDeSocio = tipoDeSocio;
    }
}
