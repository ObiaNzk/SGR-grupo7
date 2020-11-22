package Front.OperacionesSocios.OperacionesSociosParticipes.CuentasCorrientes;

import Helper.MontoHelper;
import Validadores.GarantiasValidador;
import enums.TipoDeOperacionEnum;
import enums.TipoDeSocio;
import main.Operacion;
import main.Sistema;
import main.Socio;
import operaciones.Cheque;
import operaciones.CuentaCorriente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OperacionCuentasCorrientes extends JDialog{
    private JTextField VencimientoText;
    private JFormattedTextField MontoText;
    private JButton agregarCuentaCorrienteButton;
    private JPanel pnlPrincipal;
    private JButton consultaDisponibilidadParaOperarButton;
    private JButton cargarOperacionButton;
    private JComboBox SocioBox;
    private Sistema sistema;

    public OperacionCuentasCorrientes(String titulo) {
        //Define un owner que gestiona su lanzamiento, (panel principal, clase Operatoria Cheque.
        sistema = Sistema.getInstance();
        //tamaño del panel.
        this.setSize(600, 300);

        this.setContentPane(pnlPrincipal);
        //No permite volver hasta la pantalla anterior hasta cerrar esta.

        //Inicio Centrado
        this.setLocationRelativeTo(null);

        this.setModal(true);

        //Comportamiento de Cierre
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        DefaultComboBoxModel model = new DefaultComboBoxModel(sistema.getSgr().GetSociosPorTipo(TipoDeSocio.PARTICIPE).toArray());
        SocioBox.setModel(model);

        consultaDisponibilidadParaOperarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //custom title, error icon
                Socio socioSeleccionado = (Socio) SocioBox.getSelectedItem();

                JOptionPane.showMessageDialog(pnlPrincipal, MontoHelper.GetMonto(socioSeleccionado),"Monto Maximo Valido",JOptionPane.INFORMATION_MESSAGE);
            }
        });

        cargarOperacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Socio socioSeleccionado = (Socio) SocioBox.getSelectedItem();
                    Date vencimiento = new SimpleDateFormat("dd/MM/yyyy").parse(VencimientoText.getText());
                    Integer monto = Integer.parseInt(MontoText.getText());

                    CuentaCorriente cuentaCorriente = new CuentaCorriente(monto, vencimiento);
                    Operacion operacion = new Operacion(TipoDeOperacionEnum.TIPO2, new Date(), vencimiento, monto, cuentaCorriente);
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
