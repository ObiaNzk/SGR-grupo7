package Front.OperacionesSocios.MonetizarOperaciones.AprobarPrestamo;

import enums.EstadoOperacionEnum;
import enums.TipoDeOperacionEnum;
import enums.TipoDeSocio;
import main.Operacion;
import main.Sistema;
import main.Socio;
import operaciones.Cheque;
import operaciones.Comision;
import operaciones.Prestamo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AprobarPrestamo extends JDialog {
    private JComboBox SocioCombo;
    private JComboBox PrestamoCombo;
    private JLabel BancoLabel;
    private JLabel MontoPrestamoLabel;
    private JLabel TasaLabel;
    private JLabel FechaAcreditacionLabel;
    private JLabel CuotasLabel;
    private JLabel SistemaLabel;
    private JPanel pnlPrincipal;
    private JButton aprobarPrestamoButton;
    private Sistema sistema;

    public AprobarPrestamo(String titulo) {
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

        sistema = Sistema.getInstance();

        DefaultComboBoxModel model = new DefaultComboBoxModel(sistema.getSgr().GetSociosPorTipo(TipoDeSocio.PARTICIPE).toArray());
        SocioCombo.setModel(model);
        List<Operacion> prestamosList = ((Socio) SocioCombo.getSelectedItem()).GetOperaciones(false, TipoDeOperacionEnum.TIPO3);
        DefaultComboBoxModel modelPrestamos = new DefaultComboBoxModel(prestamosList.toArray());
        PrestamoCombo.setModel(modelPrestamos);
        if (prestamosList.size() > 0) {
            Operacion operacionSeleccionada = (Operacion) PrestamoCombo.getSelectedItem();
            Prestamo prestamo = (Prestamo) operacionSeleccionada.getDocumentosOperacion();
            this.BancoLabel.setText(prestamo.getBanco());
            this.MontoPrestamoLabel.setText(prestamo.getMonto().toString());
            this.TasaLabel.setText(prestamo.getTasa().toString());
            this.FechaAcreditacionLabel.setText(prestamo.getFechaAcreditacion().toString());
            this.CuotasLabel.setText(String.valueOf(prestamo.getCuotas().size()));
            this.SistemaLabel.setText(prestamo.getSistema().toString());
        }
        SocioCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Operacion> prestamosList = ((Socio) SocioCombo.getSelectedItem()).GetOperaciones(false, TipoDeOperacionEnum.TIPO3);
                DefaultComboBoxModel modelPrestamos = new DefaultComboBoxModel(prestamosList.toArray());
                PrestamoCombo.setModel(modelPrestamos);
            }
        });
        PrestamoCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Operacion operacionSeleccionada = (Operacion) PrestamoCombo.getSelectedItem();
                Prestamo prestamo = (Prestamo) operacionSeleccionada.getDocumentosOperacion();
                BancoLabel.setText(prestamo.getBanco());
                MontoPrestamoLabel.setText(prestamo.getMonto().toString());
                TasaLabel.setText((prestamo.getTasa().toString())+"%");
                FechaAcreditacionLabel.setText(prestamo.getFechaAcreditacion().toString());
                CuotasLabel.setText(String.valueOf(prestamo.getCuotas().size()));
                SistemaLabel.setText(prestamo.getSistema().toString());
            }
        });
        aprobarPrestamoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Socio socio = (Socio) SocioCombo.getSelectedItem();
                Operacion operacionSeleccionada = (Operacion) PrestamoCombo.getSelectedItem();
                operacionSeleccionada.setMontoUtilizado(operacionSeleccionada.getMonto());
                operacionSeleccionada.setEstadoOperacion(EstadoOperacionEnum.MONETIZADO);
                Comision comision = new Comision(operacionSeleccionada);
                socio.AgregarComision(comision);
                JOptionPane.showMessageDialog(pnlPrincipal,"Operacion procesada correctamente", "Ok", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
