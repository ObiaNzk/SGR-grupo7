package dtos;

public class AltaSocioDTO {

    private Boolean errorSocioExiste = Boolean.FALSE;
    private Boolean errorFaltaDoc = Boolean.FALSE;


    public Boolean getErrorSocioExiste() {
        return errorSocioExiste;
    }

    public void setErrorSocioExiste(Boolean errorSocioExiste) {
        this.errorSocioExiste = errorSocioExiste;
    }

    public Boolean getErrorFaltaDoc() {
        return errorFaltaDoc;
    }

    public void setErrorFaltaDoc(Boolean errorFaltaDoc) {
        this.errorFaltaDoc = errorFaltaDoc;
    }
}
