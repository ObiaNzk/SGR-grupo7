package Front.OperacionesSocios.OperacionesSociosProtectores;

import javax.swing.*;

public class ComprarAcciones extends JDialog{
    private JButton comprarButton;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JPanel pnlPrincipal;


    public ComprarAcciones(String titulo) {

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
