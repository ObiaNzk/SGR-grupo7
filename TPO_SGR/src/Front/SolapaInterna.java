package Front;

import javax.swing.*;
import java.awt.*;

public class SolapaInterna extends JInternalFrame{
    private JButton pagoCuotaPrestamoButton;
    private JButton ventaDeChequesButton;
    private JPanel pnlPrincipal;
    private JButton operacion2Button;
    private JButton operacion3Button;

    public SolapaInterna(String titulo) {
        super(titulo);


        this.setContentPane(pnlPrincipal);
        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);


    }
}


