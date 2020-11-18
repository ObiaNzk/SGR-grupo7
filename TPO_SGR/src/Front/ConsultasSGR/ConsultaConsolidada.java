package Front.ConsultasSGR;

import dtos.ConsultaConsolidadaResponseDTO;
import enums.TipoDeSocio;
import main.Sistema;
import main.Socio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ConsultaConsolidada extends JDialog {
    private JButton obtenerConsultaConsolidadaButton;
    private JComboBox comboBox1;
    private JPanel pnlPrincipal;
    private JComboBox comboBox2;
    private JLabel labelResponse;
    private List<Socio> socioList = new ArrayList<>();
    private Sistema sistema;
    private Socio socioSelected;
    private ConsultaConsolidadaResponseDTO responseDTO;


    public ConsultaConsolidada(String titulo) {
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


//        socioList = this.sistema.getInstance().getSgr().getInstance().getSociosProtectores();

        Socio socioMock1 = new Socio();
        socioMock1.setNombre("Prueba1");
        socioMock1.setTipoDeSocio(TipoDeSocio.PARTICIPE);
        Socio socioMock2 = new Socio();
        socioMock2.setNombre("Prueba1");
        socioMock2.setTipoDeSocio(TipoDeSocio.PROTECTORES);
        socioList.add(socioMock1);
        socioList.add(socioMock2);

        DefaultComboBoxModel model = new DefaultComboBoxModel(socioList.toArray());

        comboBox1.setModel(model);


        obtenerConsultaConsolidadaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                responseDTO = sistema.getInstance().consultaConsolidada(socioSelected);
                labelResponse.setText("Riesgo vivo :" + responseDTO.getTotalRiesgoVivo().toString() + " " +
                        "Total utilizado :" + responseDTO.getTotalUtilizado().toString());
            }
        });
    }

}
