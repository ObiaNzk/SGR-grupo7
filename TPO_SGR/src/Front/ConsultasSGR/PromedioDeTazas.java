package Front.ConsultasSGR;

import dtos.PromedioTasaDescuentoYTotalDTO;
import enums.TamañoEmpresaEnum;
import enums.TipoDeSocio;
import main.Sistema;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PromedioDeTazas extends JDialog {
    private JButton obtenerPromedioButton;
    private JFormattedTextField FechaDesde;
    private JFormattedTextField FechaHasta;
    private JPanel pnlPrincipal;
    private JComboBox tipoEmpresaCombo;
    private JLabel ResultadoPromedio;
    private List<TamañoEmpresaEnum> tipoEmpresaList = new ArrayList<>();
    private PromedioTasaDescuentoYTotalDTO resultado = new PromedioTasaDescuentoYTotalDTO();
    private Sistema sistema;
    private TamañoEmpresaEnum tamañoEmpresaEnumSeleccionado;
    private PromedioTasaDescuentoYTotalDTO responseDTO;

    public PromedioDeTazas(String titulo) {
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
        tipoEmpresaList.add(TamañoEmpresaEnum.GRANDE);
        tipoEmpresaList.add(TamañoEmpresaEnum.MEDIANA);
        tipoEmpresaList.add(TamañoEmpresaEnum.PEQUEÑA);

        DefaultComboBoxModel model = new DefaultComboBoxModel(tipoEmpresaList.toArray());
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
                try {
                    Date dateDesde=new SimpleDateFormat("dd/MM/yyyy").parse(FechaDesde.getText());
                    Date dateHasta=new SimpleDateFormat("dd/MM/yyyy").parse(FechaHasta.getText());

                    resultado = sistema.promedioTasaDescuentoYTotalOperado((TamañoEmpresaEnum) tipoEmpresaCombo.getSelectedItem(), dateDesde, dateHasta);
                    ResultadoPromedio.setText(resultado.toString());
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }

            }
        });
    }

}
