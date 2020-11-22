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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperacionesMonetizadasPorSocio extends JDialog{
    private JButton consultaOperacionesMonetizadasButton;
    private JComboBox comboBox1;
    private JPanel pnlPrincipal;
    private JTextField FechaDesde;
    private JTextField FechaHasta;
    private JList ListaOperaciones;
    private Sistema sistema;
    private Socio socioSeleccionado;
    private List<Operacion> operacionList = new ArrayList<>();
    private List<Socio> socioList = new ArrayList<>();

    public OperacionesMonetizadasPorSocio(String titulo) {
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

        socioList.addAll(sistema.getSgr().GetSociosPorTipo(TipoDeSocio.PARTICIPE));

//        socioList = sistema.getInstance().getSgr().getSociosProtectores();

        DefaultComboBoxModel model = new DefaultComboBoxModel(socioList.toArray());
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
                try {
                    DefaultListModel listModel = new DefaultListModel();
                    Date dateDesde=new SimpleDateFormat("dd/MM/yyyy").parse(FechaDesde.getText());
                    Date dateHasta=new SimpleDateFormat("dd/MM/yyyy").parse(FechaHasta.getText());
                    operacionList = sistema.operacionesDeSocio((Socio) comboBox1.getSelectedItem(), dateDesde, dateHasta);

                    for (int i = 0; i < operacionList.size(); i++)
                    {
                        listModel.addElement(operacionList.get(i));
                    }
                    ListaOperaciones.setModel(listModel);

                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
            }
        });
    }

}
