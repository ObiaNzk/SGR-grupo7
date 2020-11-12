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



    public ABMSocios(Window owner, String titulo) {
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


        altaPostulanteASocioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AltaPostulanteSocioProtector frame = new AltaPostulanteSocioProtector(owner, "Ingrese los datos del socio");
                frame.setVisible(true);
            }
        });
        altaPostulanteASocioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AltaPostulanteSocioParticipe frame = new AltaPostulanteSocioParticipe(owner , "Ingrese los datos del socio");
                frame.setVisible(true);

            }
        });
        convertirSocioEnPlenoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConvertirSocioPleno frame = new ConvertirSocioPleno(owner, "Actualizar estado del socio");
                frame.setVisible(true);
            }
        });
    }
}

