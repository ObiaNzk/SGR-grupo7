package dtos;

public class OperacionesDTO {

    private boolean error;
    private String errorMessage;
    private String mesagge;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMesagge() {
        return mesagge;
    }

    public void setMesagge(String mesagge) {
        this.mesagge = mesagge;
    }
}
