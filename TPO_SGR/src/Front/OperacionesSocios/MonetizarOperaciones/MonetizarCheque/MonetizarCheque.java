package Front.OperacionesSocios.MonetizarOperaciones.MonetizarCheque;

import Request.OperacionCheque;
import enums.TipoDeSocio;
import main.Operacion;
import main.Sistema;
import main.Socio;
import operaciones.Cheque;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MonetizarCheque extends JDialog {
    private JComboBox SocioCombo;
    private JComboBox ChequeCombo;
    private JTextField TasaDescuentoText;
    private JButton monetizarChequeButton;
    private JPanel pnlPrincipal;
    private JLabel bancoLabel;
    private JLabel ChequeLabel;
    private JLabel VencimientoLabel;
    private JLabel CuitLabel;
    private JLabel MontoLabel;
    private Sistema sistema;

    public MonetizarCheque(String titulo) {
        //Define un owner que gestiona su lanzamiento, (panel principal, clase Operatoria Cheque.
        sistema = Sistema.getInstance();

        //tamaño del panel.
        this.setSize(300, 300);

        this.setContentPane(pnlPrincipal);
        //No permite volver hasta la pantalla anterior hasta cerrar esta.

        //Inicio Centrado
        this.setLocationRelativeTo(null);

        this.setModal(true);

        //Comportamiento de Cierre
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        sistema = Sistema.getInstance();

        DefaultComboBoxModel model = new DefaultComboBoxModel(sistema.getSgr().GetSociosPorTipo(TipoDeSocio.PARTICIPE).toArray());
        SocioCombo.setModel(model);
        List<Operacion> chequeList = ((Socio)SocioCombo.getSelectedItem()).GetOperacionesCheques(false);
        DefaultComboBoxModel modelcheques = new DefaultComboBoxModel(chequeList.toArray());
        ChequeCombo.setModel(modelcheques);
        if(chequeList.size() > 0) {
            Operacion operacionSeleccionada = (Operacion)ChequeCombo.getSelectedItem();
            Cheque cheque = (Cheque)operacionSeleccionada.getDocumentosOperacion();
            this.bancoLabel.setText(cheque.getNombreBanco());
            this.ChequeLabel.setText(cheque.getNumeroCheque());
            this.VencimientoLabel.setText(cheque.getFechaVencimiento().toString());
            this.CuitLabel.setText(cheque.getCuit());
            this.MontoLabel.setText(cheque.getMonto().toString());
        }

        SocioCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Socio socioSeleccionado = (Socio) SocioCombo.getSelectedItem();
                List<Operacion> chequeList = ((Socio)SocioCombo.getSelectedItem()).GetOperacionesCheques(false);
                DefaultComboBoxModel modelcheques = new DefaultComboBoxModel(chequeList.toArray());
                ChequeCombo.setModel(modelcheques);
            }
        });
        ChequeCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Operacion operacionSeleccionada = (Operacion)ChequeCombo.getSelectedItem();
                Cheque cheque = (Cheque)operacionSeleccionada.getDocumentosOperacion();
                bancoLabel.setText(cheque.getNombreBanco());
                ChequeLabel.setText(cheque.getNumeroCheque());
                VencimientoLabel.setText(cheque.getFechaVencimiento().toString());
                CuitLabel.setText(cheque.getCuit());
                MontoLabel.setText(cheque.getMonto().toString());
            }
        });
        monetizarChequeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Socio socioSeleccionado = (Socio) SocioCombo.getSelectedItem();
                    Operacion operacionSeleccionada = (Operacion) ChequeCombo.getSelectedItem();
                    Integer tasaDescuento = Integer.parseInt(TasaDescuentoText.getText());
                    OperacionCheque gastoCheque = new OperacionCheque(tasaDescuento);
                    sistema.getSgr().RealizarOperacion(socioSeleccionado, operacionSeleccionada, gastoCheque);
                    JOptionPane.showMessageDialog(pnlPrincipal,"Operacion Procesada", "Ok", JOptionPane.INFORMATION_MESSAGE);
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(pnlPrincipal,exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
