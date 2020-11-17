package Front.ComboBox;

import enums.TipoDeSocio;
import main.Operacion;
import main.Sistema;
import main.Socio;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class OperacionesMonetizadasView extends JDialog{

    private JPanel jPanel;
    private JComboBox comboBox1;
    private JButton button1;
    private JTextField textField1;
    private JLabel labelResponse;
    private JComboBox comboSocios;
    private Sistema sistema;
    private Socio socioSeleccionado;
    private List<Operacion> operacionList = new ArrayList<>();
    private List<Socio> socioList = new ArrayList<>();

    public OperacionesMonetizadasView(Window owner){

        super(owner, "Operaciones a nombre de un socio");

        this.setContentPane(jPanel);
        this.setSize(300, 300);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);


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
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                operacionList = sistema.getInstance().operacionesDeSocio(socioSeleccionado, new Date(), new Date());

//                SETEAR RESPONSE
//                labelResponse.setText();
            }
        });
    }


    public JXDatePicker getDatePicker(){
        JXDatePicker picker = new JXDatePicker();
        picker.setDate(Calendar.getInstance().getTime());
        picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));

        return picker;
    }
}
