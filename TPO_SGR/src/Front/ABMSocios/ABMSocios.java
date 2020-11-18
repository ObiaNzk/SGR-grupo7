package Front.ABMSocios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ABMSocios extends JDialog {
    private JButton convertirSocioEnPlenoButton;
    private JButton altaPostulanteASocioButton;
    private JButton altaPostulanteASocioButton1;
    private JPanel pnlPrincipal;
    private JDesktopPane DesktopPaneABM;



    public ABMSocios(String titulo) {
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


        altaPostulanteASocioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AltaPostulanteSocio frame = new AltaPostulanteSocio("Nuevo Postulante");
                frame.setVisible(true);
            }
        });
    }
}

