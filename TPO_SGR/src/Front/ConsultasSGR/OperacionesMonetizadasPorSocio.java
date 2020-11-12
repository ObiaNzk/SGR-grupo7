package Front.ConsultasSGR;

import javax.swing.*;

public class OperacionesMonetizadasPorSocio extends JDialog{
    private JButton consultaOperacionesMonetizadasButton;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JPanel pnlPrincipal;
    public OperacionesMonetizadasPorSocio(String titulo) {
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
