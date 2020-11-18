package Front.ConsultasSGR;

import enums.TipoDeOperacionEnum;
import main.Sistema;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class CalculodeComisionPorParámetro extends JDialog {
    private JComboBox comboBox1;
    private JButton obtenerDeComisiónButton;
    private JPanel pnlPrincipal;
    private JLabel labelResponse;
    private List<TipoDeOperacionEnum> tipoDeOperacionEnumList = new ArrayList<>();
    private Sistema sistema;
    private TipoDeOperacionEnum tipoDeOperacionEnumSelected;

    public CalculodeComisionPorParámetro(String titulo) {
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

        tipoDeOperacionEnumList.add(TipoDeOperacionEnum.TIPO1);
        tipoDeOperacionEnumList.add(TipoDeOperacionEnum.TIPO2);
        tipoDeOperacionEnumList.add(TipoDeOperacionEnum.TIPO3);

        DefaultComboBoxModel model = new DefaultComboBoxModel(tipoDeOperacionEnumList.toArray());

        comboBox1.setModel(model);

        obtenerDeComisiónButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
            }
        });
        obtenerDeComisiónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer response =  sistema.getInstance().getPorcentajeDeComisiones((TipoDeOperacionEnum) comboBox1.getSelectedItem());
                labelResponse.setText("Porecentaje para la operacion: " +response.toString() + "%");
            }
        });
    }
}
