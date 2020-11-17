package Front.ComboBox;

import Responses.ConsultaConsolidadaResponse;
import enums.TipoDeOperacionEnum;
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
import java.util.List;

public class ConsultaConsolidadaView extends JDialog{
    private JPanel jPanel;
    private JComboBox comboBox1;
    private JButton consultarButton;
    private JLabel labelResponse;
    private List<Socio> socioList = new ArrayList<>();
    private Sistema sistema;
    private Socio socioSelected;
    private ConsultaConsolidadaResponse response;

    public ConsultaConsolidadaView() {

        this.setContentPane(jPanel);
        this.setSize(400, 400);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        DefaultComboBoxModel model = new DefaultComboBoxModel();

//        socioList = this.sistema.getInstance().getSgr().getInstance().getSociosProtectores();

        Socio socioMock1 = new Socio();
        socioMock1.setNombre("Prueba1");
        socioMock1.setTipoDeSocio(TipoDeSocio.PARTICIPE);
        Socio socioMock2 = new Socio();
        socioMock2.setNombre("Prueba1");
        socioMock2.setTipoDeSocio(TipoDeSocio.PROTECTORES);
        socioList.add(socioMock1);
        socioList.add(socioMock2);

        model.addAll(socioList);
        comboBox1.setModel(model);


        comboBox1.setModel(model);
        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                socioSelected = (Socio) comboBox1.getSelectedItem();
            }
        });
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                response = sistema.getInstance().consultaConsolidada(socioSelected);

                labelResponse.setText("Riesgo vivo :" + response.getTotalRiesgoVivo().toString() + " " +
                        "Total utilizado :" + response.getTotalUtilizado().toString());
            }
        });
    }
}
