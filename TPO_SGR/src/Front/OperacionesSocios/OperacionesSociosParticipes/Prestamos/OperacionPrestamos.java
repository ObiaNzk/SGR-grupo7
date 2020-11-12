package Front.OperacionesSocios.OperacionesSociosParticipes.Prestamos;

import javax.swing.*;

public class OperacionPrestamos extends JDialog{
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox comboBox2;
    private JButton pagarCuotaDePrestamoButton;
    private JComboBox comboBox3;
    private JPanel pnlPrincipal;

    public OperacionPrestamos(String titulo) {
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
