package Front.OperacionesSocios;

import javax.swing.*;
import java.awt.*;
//Extiende de Jdialog para utilizar los métodos que le dan vida la interfaz.
public class PanelSolapadoOperaciones extends JDialog {

    private JPanel pnlPrincipal;
    private JTabbedPane tabbedPane1;
    private JPanel pnlSocios;
    private JDesktopPane DesktopPaneSolapaUno;
<<<<<<< HEAD:TPO_SGR/src/Front/OperacionesDisponibles.java
=======
    private JDesktopPane DesktopPaneSolapa2;
    private JTabbedPane tabbedPane1;
>>>>>>> c3be6ededd929e2d05c14f3f06921191c8e107d7:TPO_SGR/src/Front/OperacionesSocios/PanelSolapadoOperaciones.java

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

<<<<<<< HEAD:TPO_SGR/src/Front/OperacionesDisponibles.java
//        SelectorOperacionesSocios2 solapaframe2 = new SelectorOperacionesSocios2 ("SOCIOS PROTECTORES");
//        solapaframe2.setVisible(true);
//        DesktopPaneSolapa2.add(solapaframe2);
=======
        SelectoOperacionesSociosProtectores solapaframe2 = new SelectoOperacionesSociosProtectores("SOCIOS PROTECTORES");
        solapaframe2.setVisible(true);
        DesktopPaneSolapa2.add(solapaframe2);
>>>>>>> c3be6ededd929e2d05c14f3f06921191c8e107d7:TPO_SGR/src/Front/OperacionesSocios/PanelSolapadoOperaciones.java


    }
}
