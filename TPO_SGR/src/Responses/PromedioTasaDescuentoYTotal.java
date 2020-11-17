package Responses;

public class PromedioTasaDescuentoYTotal {
    private double promedioTasa;
    private double promedioMonto;


    public PromedioTasaDescuentoYTotal(double promedioTasa, double promedioMonto){
        promedioTasa = promedioTasa;
        promedioMonto = promedioMonto;
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
}
