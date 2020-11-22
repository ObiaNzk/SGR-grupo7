package Front.ConsultasSGR;

import enums.TipoDeSocio;
import main.Sistema;
import operaciones.Comision;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ComisionesChequesEnUnDia extends JDialog {
    private JTextField fecha;
    private JButton buscarComisionesButton;
    private JPanel pnlPrincipal;
    private JList ListaComisiones;
    private JTextField totalComisiones;
    private Sistema sistema;

    public ComisionesChequesEnUnDia(String titulo) {
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

        buscarComisionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    float totalComisionesValor = 0 ;
                    Date dateDesde = new SimpleDateFormat("dd/MM/yyyy").parse(fecha.getText());
                    List<Comision> comisiones = sistema.getSgr().comisionesEnunDia(dateDesde);
                    DefaultListModel listModel = new DefaultListModel();

                    for (int i = 0; i < comisiones.size(); i++)
                    {
                        listModel.addElement(comisiones.get(i));
                        totalComisionesValor += comisiones.get(i).getMonto();
                    }
                    ListaComisiones.setModel(listModel);
                    totalComisiones.setText(String.valueOf(totalComisionesValor));

                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }

            }
        });
    }
}
