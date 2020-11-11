package Front;

import javax.swing.*;
import java.awt.*;
//Extiende de Jdialog para utilizar los métodos que le dan vida la interfaz.
public class CargarDatosCheque extends JDialog {

    private JPanel pnlPrincipal;

    public CargarDatosCheque(Window owner, String titulo) {
        //Define un owner que gestiona su lanzamiento, (panel principal, clase Operatoria Cheque.
        super(owner, titulo);

        //tamaño del panel.
        this.setSize(300,300);

        this.setContentPane(pnlPrincipal);
        //No permite volver hasta la pantalla anterior hasta cerrar esta.
        this.setModal(true);

        //Comportamiento de Cierre
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Inicio Centrado
        this.setLocationRelativeTo(null);


    }
}
