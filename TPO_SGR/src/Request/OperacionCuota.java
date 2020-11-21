package Request;

import Interfaces.IOperacionGastos;
import operaciones.Cuota;

public class OperacionCuota implements IOperacionGastos {
    private Cuota Cuota;

    public OperacionCuota(Cuota cuota){
        this.Cuota = cuota;
    }
    public Cuota getCuota() {
        return Cuota;
    }

    public void setCuota(Cuota cuota) {
        this.Cuota = cuota;
    }
}
