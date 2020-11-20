package Front.OperacionesSocios.OperacionesSociosParticipes.Prestamos;

import Helper.MontoHelper;
import Validadores.GarantiasValidador;
import enums.SistemaPrestamoEnum;
import enums.TipoDeOperacionEnum;
import enums.TipoDeSocio;
import main.Operacion;
import main.Sistema;
import main.Socio;
import operaciones.Cheque;
import operaciones.Cuota;
import operaciones.Prestamo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class OperacionPrestamos extends JDialog{
    private JTextField ImporteText;
    private JTextField FechaText;
    private JTextField CuotasText;
    private JComboBox SistemaCombo;
    private JComboBox SociosCombo;
    private JPanel pnlPrincipal;
    private JButton consultaDisponibilidadParaOperarButton;
    private JButton cargarOperacionButton;
    private JTextField BancoText;
    private JLabel tasaText;
    private JTextField TasaText;
    private Sistema sistema;

    public OperacionPrestamos(String titulo) {
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
        SociosCombo.setModel(model);

        consultaDisponibilidadParaOperarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //custom title, error icon
                Socio socioSeleccionado = (Socio) SociosCombo.getSelectedItem();

                JOptionPane.showMessageDialog(pnlPrincipal, MontoHelper.GetMonto(socioSeleccionado), "Monto Maximo Valido", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        cargarOperacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Socio socioSeleccionado = (Socio) SociosCombo.getSelectedItem();
                    Date acreditacion = new SimpleDateFormat("dd/MM/yyyy").parse(FechaText.getText());
                    String banco = BancoText.getText();
                    Integer monto = Integer.parseInt(ImporteText.getText());
                    Integer numeroCuotas = Integer.parseInt(CuotasText.getText());
                    SistemaPrestamoEnum sistemaOperacion = SistemaPrestamoEnum.valueOf(SistemaCombo.getSelectedItem().toString());
                    Integer tasa = Integer.parseInt(TasaText.getText());
                    Calendar cal = Calendar.getInstance();

                    if(acreditacion.before(cal.getTime())){
                        throw new Exception("fecha de acreditacion invalida");
                    }

                    List<Cuota> cuotas = Collections.nCopies(numeroCuotas,new Cuota((float)(monto*tasa)/numeroCuotas, cal.getTime(), false) );
                    for (int i = 0; i < cuotas.size(); i++){
                        cal.add(Calendar.MONTH, i+2);
                        cuotas.get(i).setFechaVencimiento(cal.getTime());
                    }
                    Prestamo prestamo = new Prestamo(banco, monto, tasa, acreditacion, cuotas, sistemaOperacion);
                    Operacion operacion = new Operacion(TipoDeOperacionEnum.TIPO3, new Date(), cal.getTime(), monto, prestamo);
                    GarantiasValidador.ValidarOperacion(operacion, socioSeleccionado);
                    socioSeleccionado.AgregarOperacion(operacion);
                    JOptionPane.showMessageDialog(pnlPrincipal,"Operacion Creada", "Ok", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception parseException) {
                    JOptionPane.showMessageDialog(pnlPrincipal,parseException.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
