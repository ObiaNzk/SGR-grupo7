package Front.OperacionesSocios.OperacionesSociosParticipes;

import Interfaces.IDocumentosOperacion;
import Request.OperacionCheque;
import Validadores.GarantiasValidador;
import enums.TipoDeOperacionEnum;
import enums.TipoDeSocio;
import main.Operacion;
import main.Sistema;
import main.Socio;
import operaciones.Cheque;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OperacionCheques extends JDialog {
    private JComboBox comboBox1;
    private JTextField VencimientoText;
    private JTextField MontoText;
    private JButton cargarOperacionButton;
    private JButton consultaDisponibilidadParaOperarButton;
    private JPanel pnlPrincipal;
    private JTextField CuitText;
    private JTextField chequeText;
    private JTextField BancoText;
    private Sistema sistema;

    public OperacionCheques(String titulo) {
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

        sistema = Sistema.getInstance();

        DefaultComboBoxModel model = new DefaultComboBoxModel(sistema.getSgr().GetSociosPorTipo(TipoDeSocio.PARTICIPE).toArray());
        comboBox1.setModel(model);

        consultaDisponibilidadParaOperarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //custom title, error icon
                Socio socioSeleccionado = (Socio) comboBox1.getSelectedItem();

                JOptionPane.showMessageDialog(pnlPrincipal,socioSeleccionado.getLineaDeCredito().getMonto(),"Monto Maximo Valido",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        cargarOperacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Socio socioSeleccionado = (Socio) comboBox1.getSelectedItem();
                    Date vencimiento = new SimpleDateFormat("dd/MM/yyyy").parse(VencimientoText.getText());
                    String banco = BancoText.getText();
                    Integer monto = Integer.parseInt(MontoText.getText());
                    String cuit = CuitText.getText();
                    String chequeNumero = chequeText.getText();

                    Cheque cheque = new Cheque(banco, chequeNumero, vencimiento, cuit, monto);
                    Operacion operacion = new Operacion(TipoDeOperacionEnum.TIPO1, new Date(), vencimiento, monto, cheque);
                    GarantiasValidador.ValidarOperacion(operacion, socioSeleccionado);
                    socioSeleccionado.AgregarOperacion(operacion);
                    JOptionPane.showMessageDialog(pnlPrincipal,"Operacion Creada", "Ok", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(pnlPrincipal,exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }

}
