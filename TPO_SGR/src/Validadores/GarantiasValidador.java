package Validadores;

import main.*;

import javax.swing.*;
import java.util.Date;

public class GarantiasValidador {
        public static void ValidarOperacion(Operacion operacion, Socio socio) throws Exception {
            Sgr sgr = Sistema.getInstance().getSgr();
            if (operacion.getFechaVencimiento().before(new Date())){
                throw new Exception("Fecha invalida");
            }
            float sumaAportes = 0;
            float fdr = 0;
            for(Aporte aporte: sgr.getAportes(true)) sumaAportes += aporte.getMonto();
            fdr = (5*sumaAportes)/100;
            float topeDeOperacion = (socio.getLineaDeCredito().getMonto()<= fdr) ? socio.getLineaDeCredito().getMonto() : fdr;

            if(operacion.getMonto() > topeDeOperacion) {
                throw new Exception("Monto superior al valido");
            }
        }
}
