package Front.OperacionesSocios.MonetizarOperaciones.PagoCuotaPrestamo;

import Request.OperacionCuentaCorriente;
import Request.OperacionCuota;
import enums.TipoDeOperacionEnum;
import enums.TipoDeSocio;
import main.Operacion;
import main.Sistema;
import main.Socio;
import operaciones.Cuota;
import operaciones.Prestamo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PagoCuotaPrestamo extends JDialog {
    private JComboBox SocioCombo;
    private JComboBox PrestamoCombo;
    private JComboBox CuotaCombo;
    private JButton pagarCuotaButton;
    private JPanel pnlPrincipal;
    private Sistema sistema;

    public PagoCuotaPrestamo(String titulo) {
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

        sistema = Sistema.getInstance();

        DefaultComboBoxModel model = new DefaultComboBoxModel(sistema.getSgr().GetSociosPorTipo(TipoDeSocio.PARTICIPE).toArray());
        SocioCombo.setModel(model);
        List<Operacion> prestamosList = ((Socio) SocioCombo.getSelectedItem()).GetOperaciones(true, TipoDeOperacionEnum.TIPO3);
        DefaultComboBoxModel modelPrestamos = new DefaultComboBoxModel(prestamosList.toArray());
        PrestamoCombo.setModel(modelPrestamos);
        if(prestamosList.size() > 0){
            Operacion operacionSeleccionada = (Operacion) PrestamoCombo.getSelectedItem();
            Prestamo prestamo = (Prestamo) operacionSeleccionada.getDocumentosOperacion();
            List<Cuota> cuotas = prestamo.getCuotas(false);
            DefaultComboBoxModel modelCuotas = new DefaultComboBoxModel(cuotas.toArray());
            CuotaCombo.setModel(modelCuotas);
        }
        SocioCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Socio socioSeleccionado = (Socio) SocioCombo.getSelectedItem();
                List<Operacion> prestamosList = (socioSeleccionado).GetOperaciones(true, TipoDeOperacionEnum.TIPO3);
                DefaultComboBoxModel modelPrestamos = new DefaultComboBoxModel(prestamosList.toArray());
                PrestamoCombo.setModel(modelPrestamos);
                if(prestamosList.size() > 0){
                    Operacion operacionSeleccionada = (Operacion) PrestamoCombo.getSelectedItem();
                    Prestamo prestamo = (Prestamo) operacionSeleccionada.getDocumentosOperacion();
                    List<Cuota> cuotas = prestamo.getCuotas(false);
                    DefaultComboBoxModel modelCuotas = new DefaultComboBoxModel(cuotas.toArray());
                    CuotaCombo.setModel(modelCuotas);
                }
            }
        });
        PrestamoCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Operacion operacionSeleccionada = (Operacion) PrestamoCombo.getSelectedItem();
                Prestamo prestamo = (Prestamo) operacionSeleccionada.getDocumentosOperacion();
                List<Cuota> cuotas = prestamo.getCuotas(false);
                DefaultComboBoxModel modelCuotas = new DefaultComboBoxModel(cuotas.toArray());
                CuotaCombo.setModel(modelCuotas);
            }
        });
        pagarCuotaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Socio socioSeleccionado = (Socio) SocioCombo.getSelectedItem();
                Operacion operacionSeleccionada = (Operacion) PrestamoCombo.getSelectedItem();
                Cuota cuota = (Cuota)CuotaCombo.getSelectedItem();
                OperacionCuota pagoCuota = new OperacionCuota(cuota);
                sistema.getSgr().RealizarOperacion(socioSeleccionado, operacionSeleccionada, pagoCuota);
                JOptionPane.showMessageDialog(pnlPrincipal,"Operacion procesada correctamente", "Ok", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
