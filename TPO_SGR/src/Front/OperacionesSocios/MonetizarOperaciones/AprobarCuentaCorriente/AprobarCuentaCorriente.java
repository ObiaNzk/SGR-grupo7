package Front.OperacionesSocios.MonetizarOperaciones.AprobarCuentaCorriente;

import enums.EstadoOperacionEnum;
import enums.TipoDeOperacionEnum;
import enums.TipoDeSocio;
import main.Operacion;
import main.Sistema;
import main.Socio;
import operaciones.Comision;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AprobarCuentaCorriente extends JDialog {
    private JPanel pnlPrincipal;
    private JComboBox SocioCombo;
    private JComboBox CuentaCorrienteCombo;
    private JButton aprobarCuentaCorrienteButton;
    private Sistema sistema;

    public AprobarCuentaCorriente(String titulo) {
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
        SocioCombo.setModel(model);
        List<Operacion> cuentaCorrienteList = ((Socio) SocioCombo.getSelectedItem()).GetOperaciones(false, TipoDeOperacionEnum.TIPO2);
        DefaultComboBoxModel modelCuentaCorriente = new DefaultComboBoxModel(cuentaCorrienteList.toArray());
        CuentaCorrienteCombo.setModel(modelCuentaCorriente);

        aprobarCuentaCorrienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Socio socio = (Socio) SocioCombo.getSelectedItem();
                Operacion operacion = (Operacion)CuentaCorrienteCombo.getSelectedItem();
                operacion.setEstadoOperacion(EstadoOperacionEnum.MONETIZADO);
                Comision comision = new Comision(operacion);
                socio.AgregarComision(comision);
                JOptionPane.showMessageDialog(pnlPrincipal,"Operacion procesada correctamente", "Ok", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        SocioCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Operacion> cuentaCorrienteList = ((Socio) SocioCombo.getSelectedItem()).GetOperaciones(false, TipoDeOperacionEnum.TIPO2);
                DefaultComboBoxModel modelCuentaCorriente = new DefaultComboBoxModel(cuentaCorrienteList.toArray());
                CuentaCorrienteCombo.setModel(modelCuentaCorriente);
            }
        });
    }
}
