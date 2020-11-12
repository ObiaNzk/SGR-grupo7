package Front.OperacionesSocios;

import javax.swing.*;
import java.awt.*;
//Extiende de Jdialog para utilizar los métodos que le dan vida la interfaz.
public class PanelSolapadoOperaciones extends JDialog {

    private JPanel pnlPrincipal;
    private JDesktopPane DesktopPaneSolapaUno;
    private JDesktopPane DesktopPaneSolapa2;
    private JTabbedPane tabbedPane1;

    public PanelSolapadoOperaciones(Window owner, String titulo) {
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

        SelectorOperacionesSociosParticipes solapaframe = new SelectorOperacionesSociosParticipes("SOCIOS PARTÍCIPES");
        solapaframe.setVisible(true);
        DesktopPaneSolapaUno.add(solapaframe);

        SelectoOperacionesSociosProtectores solapaframe2 = new SelectoOperacionesSociosProtectores("SOCIOS PROTECTORES");
        solapaframe2.setVisible(true);
        DesktopPaneSolapa2.add(solapaframe2);


    }
}
