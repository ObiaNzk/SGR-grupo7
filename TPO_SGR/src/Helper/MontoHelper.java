package Helper;

import main.*;
import operaciones.Aporte;

public class MontoHelper {
    public static float GetMonto(Socio socio){
        Sgr sgr = Sistema.getInstance().getSgr();
        float totalUtilizado = (sgr.consultaConsolidada(socio)).getTotalUtilizado();
        float totalLinea = socio.getLineaDeCredito().getMonto();
        float sumaAportes = 0;
        float fdr = 0;
        for(Aporte aporte: sgr.getAportes(true)){
            sumaAportes += aporte.getMonto();
        }
        fdr = (5*sumaAportes)/100;
        float topeDeOperacion = ((totalLinea-totalUtilizado)<= fdr) ? (totalLinea-totalUtilizado) : fdr;
        return topeDeOperacion;
    }
}
