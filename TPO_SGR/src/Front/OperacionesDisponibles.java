package Front;

import javax.swing.*;
import java.awt.*;
//Extiende de Jdialog para utilizar los métodos que le dan vida la interfaz.
public class OperacionesDisponibles extends JDialog {

    private JPanel pnlPrincipal;
    private JTabbedPane tabbedPane1;
    private JPanel pnlSocios;
    private JDesktopPane DesktopPaneSolapaUno;

    public OperacionesDisponibles(Window owner, String titulo) {
        //Define un owner que gestiona su lanzamiento, (panel principal, clase Operatoria Cheque.
        super(owner, titulo);

        //tamaño del panel.
        this.setSize(300, 300);

        this.setContentPane(pnlPrincipal);
        //No permite volver hasta la pantalla anterior hasta cerrar esta.

        //Inicio Centrado
        this.setLocationRelativeTo(null);

        this.setModal(true);

        //Comportamiento de Cierre
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        SelectorOperacionesSocios1 solapaframe = new SelectorOperacionesSocios1("SOCIOS PARTÍCIPES");
        solapaframe.setVisible(true);
        DesktopPaneSolapaUno.add(solapaframe);

//        SelectorOperacionesSocios2 solapaframe2 = new SelectorOperacionesSocios2 ("SOCIOS PROTECTORES");
//        solapaframe2.setVisible(true);
//        DesktopPaneSolapa2.add(solapaframe2);


    }
}
