package Front.OperacionesSocios.OperacionesSociosParticipes;

import javax.swing.*;

public class OperacionCheques extends JDialog {
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField MontoText;
    private JButton cargarOperacionButton;
    private JButton consultaDisponibilidadParaOperarButton;
    private JPanel pnlPrincipal;
    private JTextField CuitText;
    private JTextField chequeText;
    private JTextField BancoText;

    public OperacionCheques(String titulo) {
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
