package Front.ConsultasSGR;

import enums.TipoDeOperacionEnum;
import enums.TipoDeSocio;
import main.Operacion;
import main.Sistema;
import main.Socio;
import operaciones.Aporte;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AportesSocio extends JDialog {
    private JComboBox SocioCombo;
    private JList AportesList;
    private JPanel pnlPrincipal;
    private Sistema sistema;

    public AportesSocio(String titulo) {
        //Define un owner que gestiona su lanzamiento, (panel principal, clase Operatoria Cheque.
        sistema = Sistema.getInstance();

        //tamaño del panel.
        this.setSize(800, 300);

        this.setContentPane(pnlPrincipal);
        //No permite volver hasta la pantalla anterior hasta cerrar esta.

        //Inicio Centrado
        this.setLocationRelativeTo(null);

        this.setModal(true);

        //Comportamiento de Cierre
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        DefaultComboBoxModel model = new DefaultComboBoxModel(sistema.getSgr().GetSociosPorTipo(TipoDeSocio.PROTECTORES).toArray());
        SocioCombo.setModel(model);

        Socio socioSeleccionado = (Socio)SocioCombo.getSelectedItem();
        List<Operacion> operaciones = socioSeleccionado.GetOperaciones(false, TipoDeOperacionEnum.APORTE);
        List<Aporte> aportes = new ArrayList<Aporte>();
        for (Operacion operacion: operaciones){
            Aporte aporte = (Aporte) operacion.getDocumentosOperacion();
            aportes.add(aporte);
        }
        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < aportes.size(); i++)
        {
            listModel.addElement(aportes.get(i));
        }
        AportesList.setModel(listModel);

        SocioCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Socio socioSeleccionado = (Socio)SocioCombo.getSelectedItem();
                List<Operacion> operaciones = socioSeleccionado.GetOperaciones(false, TipoDeOperacionEnum.APORTE);
                List<Aporte> aportes = new ArrayList<Aporte>();
                for (Operacion operacion: operaciones){
                    Aporte aporte = (Aporte) operacion.getDocumentosOperacion();
                    aportes.add(aporte);
                }
                DefaultListModel listModel = new DefaultListModel();
                for (int i = 0; i < aportes.size(); i++)
                {
                    listModel.addElement(aportes.get(i));
                }
                AportesList.setModel(listModel);
            }
        });
    }
}
