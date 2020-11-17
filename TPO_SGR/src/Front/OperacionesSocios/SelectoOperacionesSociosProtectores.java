package Front.OperacionesSocios;

import Front.OperacionesSocios.OperacionesSociosProtectores.ComprarAcciones;
import Front.OperacionesSocios.OperacionesSociosProtectores.RetirarFondos;
import Front.OperacionesSocios.OperacionesSociosProtectores.VenderAcciones;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SelectoOperacionesSociosProtectores extends JInternalFrame {
    private JPanel pnlPrincipal;
    private JButton button1;
    private JButton button2;
    private JButton button3;


    public SelectoOperacionesSociosProtectores(String titulo) {
        super(titulo);


        this.setContentPane(pnlPrincipal);
        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ComprarAcciones frame = new ComprarAcciones("Acciones a Comprar");
                frame.setVisible(true);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VenderAcciones frame = new VenderAcciones("Venta de Acciones");
                frame.setVisible(true);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RetirarFondos frame = new RetirarFondos("Extracción de fondos FDR");
                frame.setVisible(true);
            }
        });
    }
}
