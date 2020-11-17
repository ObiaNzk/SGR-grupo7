package Front.OperacionesSocios.OperacionesSociosParticipes.CuentasCorrientes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperacionCuentasCorrientes extends JDialog{
    private JButton operarConCuentaCorrienteButton;
    private JButton consultaDisponibilidadButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField1;
    private JFormattedTextField formattedTextField1;
    private JButton agregarCuentaCorrienteButton;
    private JPanel pnlPrincipal;

    public OperacionCuentasCorrientes(String titulo) {
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


        agregarCuentaCorrienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarCuentaCorriente frame = new AgregarCuentaCorriente("Agregar cuenta");
                frame.setVisible(true);

            }
        });
    }

}
