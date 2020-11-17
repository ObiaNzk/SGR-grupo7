package Front.ComboBox;

import Responses.PromedioTasaDescuentoYTotal;
import enums.TamañoEmpresaEnum;
import main.Sistema;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ValorPromedioTasaYCheques extends JDialog{
    private JPanel jPanel;
    private JComboBox tipoEmpresaCombo;
    private JButton calcularButton;
    private List<TamañoEmpresaEnum> tipoEmpresaList = new ArrayList<>();
    private Sistema sistema;
    private TamañoEmpresaEnum tamañoEmpresaEnumSeleccionado;
    private PromedioTasaDescuentoYTotal response;

    public ValorPromedioTasaYCheques(Window owner){

        this.setContentPane(jPanel);
        this.setSize(500, 500);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        DefaultComboBoxModel model = new DefaultComboBoxModel();

        tipoEmpresaList.add(TamañoEmpresaEnum.GRANDE);
        tipoEmpresaList.add(TamañoEmpresaEnum.MEDIANA);
        tipoEmpresaList.add(TamañoEmpresaEnum.PEQUEÑA);

        model.addAll(tipoEmpresaList);
        tipoEmpresaCombo.setModel(model);

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                response = sistema.getInstance().promedioTasaDescuentoYTotalOperado(tamañoEmpresaEnumSeleccionado, new Date(), new Date());
            }
        });

        tipoEmpresaCombo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                tamañoEmpresaEnumSeleccionado = (TamañoEmpresaEnum) tipoEmpresaCombo.getSelectedItem();
            }
        });
    }
}
