package Validadores;

import Helper.MontoHelper;
import main.*;

import javax.swing.*;
import java.util.Date;

public class GarantiasValidador {
        public static void ValidarOperacion(Operacion operacion, Socio socio) throws Exception {
            Sgr sgr = Sistema.getInstance().getSgr();
            if (operacion.getFechaVencimiento().before(new Date())){
                throw new Exception("Fecha invalida");
            }
            float topeDeOperacion = MontoHelper.GetMonto(socio);

            if(operacion.getMonto() > topeDeOperacion) {
                throw new Exception("Monto superior al valido");
            }
        }
}
