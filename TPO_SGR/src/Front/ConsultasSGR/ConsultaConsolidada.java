package Front.ConsultasSGR;

import dtos.ConsultaConsolidadaResponseDTO;
import enums.TipoDeSocio;
import main.Operacion;
import main.Sistema;
import main.Socio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ConsultaConsolidada extends JDialog {
    private JButton obtenerConsultaConsolidadaButton;
    private JPanel pnlPrincipal;
    private JComboBox comboBox2;
    private JLabel labelResponse;
    private JList DetallesLabelResponse;
    private List<Socio> socioList = new ArrayList<>();
    private Sistema sistema;
    private Socio socioSelected;
    private ConsultaConsolidadaResponseDTO responseDTO;


    public ConsultaConsolidada(String titulo) {
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

        DefaultComboBoxModel model = new DefaultComboBoxModel(sistema.getSgr().GetSociosPorTipo(TipoDeSocio.PARTICIPE).toArray());
        comboBox2.setModel(model);



        obtenerConsultaConsolidadaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Operacion> todasLasOperaciones = new ArrayList<Operacion>();
                responseDTO = sistema.consultaConsolidada((Socio) comboBox2.getSelectedItem());
                todasLasOperaciones.addAll(responseDTO.getOperacionesRiesgoVivo());
                todasLasOperaciones.addAll(responseDTO.getOperacionesTotalUtilizado());
                DefaultListModel listModel = new DefaultListModel();
                for (int i = 0; i < todasLasOperaciones.size(); i++)
                {
                    listModel.addElement(todasLasOperaciones.get(i));
                }
                DetallesLabelResponse.setModel(listModel);

                labelResponse.setText("Riesgo vivo :" + responseDTO.getTotalRiesgoVivo() + " " +
                        "Total utilizado :" + responseDTO.getTotalUtilizado() + "Total de la linea: " + ((Socio) comboBox2.getSelectedItem()).getLineaDeCredito().getMonto());
            }
        });
    }

}
