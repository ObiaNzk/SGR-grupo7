package Front.ABMSocios;

import javax.swing.*;
import java.awt.*;

public class AltaPostulanteSocioParticipe extends JDialog {
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


    public AltaPostulanteSocioParticipe(Window owner, String titulo) {
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
    }
}
