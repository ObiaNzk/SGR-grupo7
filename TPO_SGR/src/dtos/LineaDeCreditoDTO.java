package dtos;

public class LineaDeCreditoDTO {

    private boolean error;
    private String errorMesagge;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getErrorMesagge() {
        return errorMesagge;
    }

    public void setErrorMesagge(String errorMesagge) {
        this.errorMesagge = errorMesagge;
    }
}
