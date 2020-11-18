package Front.ConsultasSGR;

import enums.TipoDeSocio;
import main.Sistema;

import javax.swing.*;

public class ComisionesChequesEnUnDia extends JDialog {
    private JTextField textField1;
    private JButton buscarComisionesButton;
    private JPanel pnlPrincipal;
    private Sistema sistema;

    public ComisionesChequesEnUnDia(String titulo) {
        //Define un owner que gestiona su lanzamiento, (panel principal, clase Operatoria Cheque.
        sistema = Sistema.getInstance();

        //tamaño del panel.
        this.setSize(300, 300);

        this.setContentPane(pnlPrincipal);
        //No permite volver hasta la pantalla anterior hasta cerrar esta.

        //Inicio Centrado
        this.setLocationRelativeTo(null);

        this.setModal(true);

        //Comportamiento de Cierre
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
