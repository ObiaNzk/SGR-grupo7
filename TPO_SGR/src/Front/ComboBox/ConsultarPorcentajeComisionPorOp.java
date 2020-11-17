package Front.ComboBox;

import enums.TamañoEmpresaEnum;
import enums.TipoDeOperacionEnum;
import main.Sistema;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class ConsultarPorcentajeComisionPorOp extends JDialog{
    private JPanel jPanel;
    private JComboBox comboBox1;
    private JButton calcularButton;
    private JLabel labelResponse;
    private List<TipoDeOperacionEnum> tipoDeOperacionEnumList = new ArrayList<>();
    private Sistema sistema;
    private TipoDeOperacionEnum tipoDeOperacionEnumSelected;

    public ConsultarPorcentajeComisionPorOp(Window owner){

        this.setContentPane(jPanel);
        this.setSize(400, 400);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        DefaultComboBoxModel model = new DefaultComboBoxModel();

        tipoDeOperacionEnumList.add(TipoDeOperacionEnum.TIPO1);
        tipoDeOperacionEnumList.add(TipoDeOperacionEnum.TIPO2);
        tipoDeOperacionEnumList.add(TipoDeOperacionEnum.TIPO3);

        model.addAll(tipoDeOperacionEnumList);

        comboBox1.setModel(model);

        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                tipoDeOperacionEnumSelected = (TipoDeOperacionEnum) comboBox1.getSelectedItem();
            }
        });

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               Integer response=  sistema.getInstance().getPorcentajeDeComisiones(tipoDeOperacionEnumSelected);
               labelResponse.setText("Porecentaje para la operacion: " +response.toString() + "%");
            }
        });
    }




}
