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
}
