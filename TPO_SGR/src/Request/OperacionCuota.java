package Request;

import Interfaces.IOperacionGastos;
import operaciones.Cuota;

public class OperacionCuota implements IOperacionGastos {
    private Cuota cuota;

    public Cuota getCuota() {
        return cuota;
    }

    public void setCuota(Cuota cuota) {
        this.cuota = cuota;
    }
}
