package Request;

import Interfaces.IOperacionGastos;

public class OperacionCuentaCorriente implements IOperacionGastos {
    private Integer MontoUtilizado;

    public OperacionCuentaCorriente(Integer gasto){
        this.MontoUtilizado = gasto;
    }
    public Integer getMontoUtilizado() {
        return MontoUtilizado;
    }

    public void setMontoUtilizado(Integer montoUtilizado) {
        MontoUtilizado = montoUtilizado;
    }
}
