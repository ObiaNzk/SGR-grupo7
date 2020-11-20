package Helper;

import main.*;
import operaciones.Aporte;

public class MontoHelper {
    public static float GetMonto(Socio socio){
        Sgr sgr = Sistema.getInstance().getSgr();

        float sumaAportes = 0;
        float fdr = 0;
        for(Aporte aporte: sgr.getAportes(true)) sumaAportes += aporte.getMonto();
        fdr = (5*sumaAportes)/100;
        float topeDeOperacion = (socio.getLineaDeCredito().getMonto()<= fdr) ? socio.getLineaDeCredito().getMonto() : fdr;
        return topeDeOperacion;
    }
}
