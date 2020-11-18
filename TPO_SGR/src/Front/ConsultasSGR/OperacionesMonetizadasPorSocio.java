package Front.ConsultasSGR;

import enums.TipoDeSocio;
import main.Operacion;
import main.Sistema;
import main.Socio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperacionesMonetizadasPorSocio extends JDialog{
    private JButton consultaOperacionesMonetizadasButton;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JPanel pnlPrincipal;
    private Sistema sistema;
    private Socio socioSeleccionado;
    private List<Operacion> operacionList = new ArrayList<>();
    private List<Socio> socioList = new ArrayList<>();

    public OperacionesMonetizadasPorSocio(String titulo) {
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

        Socio socioMock1 = new Socio();
        socioMock1.setNombre("Prueba1");
        socioMock1.setTipoDeSocio(TipoDeSocio.PARTICIPE);
        Socio socioMock2 = new Socio();
        socioMock2.setNombre("Prueba1");
        socioMock2.setTipoDeSocio(TipoDeSocio.PROTECTORES);
        socioList.add(socioMock1);
        socioList.add(socioMock2);

//        socioList = sistema.getInstance().getSgr().getSociosProtectores();

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addAll(socioList);
        comboBox1.setModel(model);

        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                socioSeleccionado = (Socio) comboBox1.getSelectedItem();
            }
        });

        consultaOperacionesMonetizadasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                operacionList = sistema.getInstance().operacionesDeSocio(socioSeleccionado, new Date(), new Date());
            }
        });
    }

}
