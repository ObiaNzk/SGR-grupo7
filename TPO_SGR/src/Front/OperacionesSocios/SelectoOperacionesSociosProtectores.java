package Front.OperacionesSocios;

import Validadores.GarantiasValidador;
import enums.TipoDeOperacionEnum;
import enums.TipoDeSocio;
import main.Operacion;
import main.Sistema;
import main.Socio;
import operaciones.Aporte;
import operaciones.Cheque;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class SelectoOperacionesSociosProtectores extends JInternalFrame {
    private JPanel pnlPrincipal;
    private JButton AporteButtom;
    private JComboBox SocioCombo;
    private JTextField MontoText;
    private Sistema sistema;


    public SelectoOperacionesSociosProtectores(String titulo) {
        super(titulo);
        this.setContentPane(pnlPrincipal);
        this.setSize(600,300);
        this.setBorder(null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        sistema = Sistema.getInstance();

        DefaultComboBoxModel model = new DefaultComboBoxModel(sistema.getSgr().GetSociosPorTipo(TipoDeSocio.PROTECTORES).toArray());
        SocioCombo.setModel(model);
        AporteButtom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Calendar cal = Calendar.getInstance();
                    cal.add(Calendar.YEAR,2);
                    Socio socioSeleccionado = (Socio) SocioCombo.getSelectedItem();
                    Integer monto = Integer.parseInt(MontoText.getText());
                    Aporte aporte = new Aporte(monto, cal.getTime());
                    Operacion operacion = new Operacion(TipoDeOperacionEnum.APORTE, new Date(), cal.getTime(), monto, aporte);
                    socioSeleccionado.AgregarOperacion(operacion);
                    sistema.getSgr().AgregarAporte(aporte);
                    JOptionPane.showMessageDialog(pnlPrincipal,"Operacion Creada", "Ok", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(pnlPrincipal,exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
