package Front.OperacionesSocios.OperacionesSociosProtectores;

import javax.swing.*;

public class RetirarFondos extends JDialog {
    private JButton retirarFondosButton;
    private JTextField textField1;
    private JTextField textField2;
    private JPanel pnlPrincipal;

    public RetirarFondos(String titulo) {
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
