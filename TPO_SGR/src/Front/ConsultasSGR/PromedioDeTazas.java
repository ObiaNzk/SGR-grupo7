package Front.ConsultasSGR;

import dtos.PromedioTasaDescuentoYTotalDTO;
import enums.TamañoEmpresaEnum;
import main.Sistema;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class PromedioDeTazas extends JDialog {
    private JButton obtenerPromedioButton;
    private JFormattedTextField formattedTextField1;
    private JFormattedTextField formattedTextField2;
    private JPanel pnlPrincipal;
    private JComboBox tipoEmpresaCombo;
    private List<TamañoEmpresaEnum> tipoEmpresaList = new ArrayList<>();
    private Sistema sistema;
    private TamañoEmpresaEnum tamañoEmpresaEnumSeleccionado;
    private PromedioTasaDescuentoYTotalDTO responseDTO;

    public PromedioDeTazas(String titulo) {
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

        DefaultComboBoxModel model = new DefaultComboBoxModel();

        tipoEmpresaList.add(TamañoEmpresaEnum.GRANDE);
        tipoEmpresaList.add(TamañoEmpresaEnum.MEDIANA);
        tipoEmpresaList.add(TamañoEmpresaEnum.PEQUEÑA);

        model.addAll(tipoEmpresaList);
        tipoEmpresaCombo.setModel(model);

        tipoEmpresaCombo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                tamañoEmpresaEnumSeleccionado = (TamañoEmpresaEnum) tipoEmpresaCombo.getSelectedItem();
            }
        });
        obtenerPromedioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //   response = sistema.getInstance().promedioTasaDescuentoYTotalOperado(tamañoEmpresaEnumSeleccionado, new Date(), new Date());

            }
        });
    }

}
