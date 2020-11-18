package dtos;

public class PromedioTasaDescuentoYTotalDTO {
    private double promedioTasa;
    private double promedioMonto;

    public PromedioTasaDescuentoYTotalDTO(){

    }
    public PromedioTasaDescuentoYTotalDTO(double promedioTasa, double promedioMonto){
        this.promedioTasa = promedioTasa;
        this.promedioMonto = promedioMonto;
    }
    public double getPromedioTasa() {
        return promedioTasa;
    }

    public void setPromedioTasa(double promedioTasa) {
        this.promedioTasa = promedioTasa;
    }

    public double getPromedioMonto() {
        return promedioMonto;
    }

    public void setPromedioMonto(double promedioMonto) {
        this.promedioMonto = promedioMonto;
    }

    @Override
    public String toString() {
        return "Promedio de tasa de descuento: " + promedioTasa+"%" +"    Monto Promedio: " + promedioMonto ;
    }
}
