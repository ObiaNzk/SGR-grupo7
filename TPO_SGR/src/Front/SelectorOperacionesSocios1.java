package Front;

import javax.swing.*;
import java.awt.*;

public class SelectorOperacionesSocios1 extends JInternalFrame{
    private JButton cuentasCorrientesTarjetasDeButton;
    private JButton chequesPagarésBursátilesButton;
    private JPanel pnlPrincipal;
    private JButton préstamosButton;

    public SelectorOperacionesSocios1(String titulo) {
            super(titulo);


        this.setContentPane(pnlPrincipal);
        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);


    }
}


