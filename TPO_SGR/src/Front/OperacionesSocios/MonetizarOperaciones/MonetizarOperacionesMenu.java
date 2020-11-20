package Front.OperacionesSocios.MonetizarOperaciones;

import Front.OperacionesSocios.MonetizarOperaciones.MonetizarCheque.MonetizarCheque;
import Front.OperacionesSocios.PanelSolapadoOperaciones;
import enums.TipoDeSocio;
import main.Sistema;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MonetizarOperacionesMenu extends JDialog {
    private JButton ChequeButtom;
    private JButton CuentaCorrienteButtom;
    private JButton aprobarPrestamoButton;
    private JButton PagarCuotaButton;
    private JPanel pnlPrincipal;


    public MonetizarOperacionesMenu(String titulo) {
        //Define un owner que gestiona su lanzamiento, (panel principal, clase Operatoria Cheque.


        //tamaño del panel.
        this.setSize(300, 300);

        this.setContentPane(pnlPrincipal);
        //No permite volver hasta la pantalla anterior hasta cerrar esta.

        //Inicio Centrado
        this.setLocationRelativeTo(null);

        this.setModal(true);

        //Comportamiento de Cierre
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        ChequeButtom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MonetizarCheque frame = new MonetizarCheque("Monetizar Cheque");
                frame.setVisible(true);
            }
        });
    }
}
