package Front.OperacionesSocios.MonetizarOperaciones.MonetizarCuentaCorriente;

import Request.OperacionCuentaCorriente;
import enums.TipoDeOperacionEnum;
import enums.TipoDeSocio;
import main.Operacion;
import main.Sistema;
import main.Socio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MonetizarCuentaCorriente extends JDialog {
    private JComboBox SocioCombo;
    private JComboBox CuentaCorrienteCombo;
    private JTextField MontoText;
    private JLabel CuentaCorriente;
    private JLabel MontoDisponibleLabel;
    private JButton OperarButtom;
    private JPanel pnlPrincipal;
    private Sistema sistema;

    public MonetizarCuentaCorriente(String titulo) {
        //Define un owner que gestiona su lanzamiento, (panel principal, clase Operatoria Cheque.
        sistema = Sistema.getInstance();

        //tamaño del panel.
        this.setSize(300, 300);

        this.setContentPane(pnlPrincipal);
        //No permite volver hasta la pantalla anterior hasta cerrar esta.

        //Inicio Centrado
        this.setLocationRelativeTo(null);

        this.setModal(true);

        //Comportamiento de Cierre
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        DefaultComboBoxModel model = new DefaultComboBoxModel(sistema.getSgr().GetSociosPorTipo(TipoDeSocio.PARTICIPE).toArray());
        SocioCombo.setModel(model);
        List<Operacion> cuentaCorrienteList = ((Socio) SocioCombo.getSelectedItem()).GetOperaciones(true, TipoDeOperacionEnum.TIPO2);
        DefaultComboBoxModel modelCuentaCorriente = new DefaultComboBoxModel(cuentaCorrienteList.toArray());
        CuentaCorrienteCombo.setModel(modelCuentaCorriente);
        if (cuentaCorrienteList.size() > 0){
            Operacion operacion = (Operacion)CuentaCorrienteCombo.getSelectedItem();
            MontoDisponibleLabel.setText(String.valueOf(operacion.getMonto() - operacion.getMontoUtilizado()));
        }
        OperarButtom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Socio socioSeleccionado = (Socio) SocioCombo.getSelectedItem();
                    Integer montoAGastar = Integer.parseInt(MontoText.getText());
                    Operacion operacion = (Operacion) CuentaCorrienteCombo.getSelectedItem();
                    if(montoAGastar > (operacion.getMonto() - operacion.getMontoUtilizado()))
                        throw new Exception("Monto a gastar superior al permitido");
                    OperacionCuentaCorriente gasto = new OperacionCuentaCorriente(montoAGastar);
                    sistema.getSgr().RealizarOperacion(socioSeleccionado, operacion, gasto);
                    JOptionPane.showMessageDialog(pnlPrincipal,"Operacion procesada correctamente", "Ok", JOptionPane.INFORMATION_MESSAGE);
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(pnlPrincipal,exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        SocioCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Operacion> cuentaCorrienteList = ((Socio) SocioCombo.getSelectedItem()).GetOperaciones(true, TipoDeOperacionEnum.TIPO2);
                DefaultComboBoxModel modelCuentaCorriente = new DefaultComboBoxModel(cuentaCorrienteList.toArray());
                CuentaCorrienteCombo.setModel(modelCuentaCorriente);
                if (cuentaCorrienteList.size() > 0){
                    Operacion operacion = (Operacion)CuentaCorrienteCombo.getSelectedItem();
                    MontoDisponibleLabel.setText(String.valueOf(operacion.getMonto() - operacion.getMontoUtilizado()));
                }
            }
        });
    }
}
