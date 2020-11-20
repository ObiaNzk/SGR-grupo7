package Front.OperacionesSocios;

import Front.OperacionesSocios.OperacionesSociosParticipes.CuentasCorrientes.OperacionCuentasCorrientes;
import Front.OperacionesSocios.OperacionesSociosParticipes.OperacionCheques;
import Front.OperacionesSocios.OperacionesSociosParticipes.Prestamos.OperacionPrestamos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectorOperacionesSociosParticipes extends JInternalFrame{
    private JButton chequesButton;
    private JPanel pnlPrincipal;
    private JButton préstamosButton;
    private JButton cuentasCorrientesButton;
    private JButton button1;

    public SelectorOperacionesSociosParticipes(String titulo) {
            super(titulo);


        this.setContentPane(pnlPrincipal);
        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);


        chequesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OperacionCheques frame = new OperacionCheques("Cheques");
                frame.setVisible(true);

            }
        });
        cuentasCorrientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OperacionCuentasCorrientes frame = new OperacionCuentasCorrientes("Cuentas");

                frame.setVisible(true);
            }
        });

        préstamosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OperacionPrestamos frame = new OperacionPrestamos("Operar con Prestamos");
                frame.setVisible(true);

            }
        });
    }
}


