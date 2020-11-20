package Request;

import Interfaces.IOperacionGastos;

public class OperacionCheque implements IOperacionGastos {
    private Integer TasaDescuento;

    public OperacionCheque(Integer tasaDescuento){
        this.TasaDescuento =  tasaDescuento;
    }
    public Integer getTasaDescuento() {
        return TasaDescuento;
    }

    public void setTasaDescuento(Integer tasaDescuento) {
        TasaDescuento = tasaDescuento;
    }
}
