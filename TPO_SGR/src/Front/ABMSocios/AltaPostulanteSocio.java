package Front.ABMSocios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AltaPostulanteSocio extends JDialog {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox comboBox1;
    private JButton agregarAccionistasButton;
    private JButton ALTASOCIOButton;
    private JCheckBox balancesCertificadosCheckBox;
    private JCheckBox manifestaciónDeBienesCheckBox;
    private JCheckBox estatutoContratoSocialCheckBox;
    private JComboBox comboBox2;
    private JTextField textField4;
    private JPanel pnlPrincipal;
    private JComboBox comboBox3;


    public AltaPostulanteSocio(String titulo) {
        //Define un owner que gestiona su lanzamiento, (panel principal, clase Operatoria Cheque.


        //tamaño del panel.
        this.setSize(300, 800);

        this.setContentPane(pnlPrincipal);
        //No permite volver hasta la pantalla anterior hasta cerrar esta.

        //Inicio Centrado
        this.setLocationRelativeTo(null);

        this.setModal(true);

        //Comportamiento de Cierre
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        agregarAccionistasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccionistasSocio frame = new AccionistasSocio("Nuevo accionista");
                frame.setVisible(true);
            }
        });
    }
}
