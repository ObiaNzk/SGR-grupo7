package Front.ConsultasSGR;

import javax.swing.*;

public class CalculodeComisionPorParámetro extends JDialog {
    private JComboBox comboBox1;
    private JButton obtenerDeComisiónButton;
    private JPanel pnlPrincipal;

    public CalculodeComisionPorParámetro(String titulo) {
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
    }
}
