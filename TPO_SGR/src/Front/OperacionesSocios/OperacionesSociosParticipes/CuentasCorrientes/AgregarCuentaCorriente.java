package Front.OperacionesSocios.OperacionesSociosParticipes.CuentasCorrientes;

import javax.swing.*;

public class AgregarCuentaCorriente extends JDialog {
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField1;
    private JButton asociarCuentaCorrienteButton;
    private JTextField textField2;
    private JPanel pnlPrincipal;
    private AgregarCuentaCorriente self;

    public AgregarCuentaCorriente(String titulo) {
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
        this.self=this;
    }
}
