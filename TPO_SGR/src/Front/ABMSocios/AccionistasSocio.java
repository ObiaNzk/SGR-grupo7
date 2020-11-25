package Front.ABMSocios;

import main.Accionista;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.util.List;

public class AccionistasSocio extends JDialog{
    private JButton agregarAccionistaButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JPanel pnlPrincipal;
    private JLabel labelError;
    private Accionista accionista;

    public AccionistasSocio(String titulo, List<Accionista> accionistaList) {
        //Define un owner que gestiona su lanzamiento, (panel principal, clase Operatoria Cheque.


        //tamaño del panel.
        this.setSize(600, 800);

        this.setContentPane(pnlPrincipal);
        //No permite volver hasta la pantalla anterior hasta cerrar esta.

        //Inicio Centrado
        this.setLocationRelativeTo(null);

        this.setModal(true);

        //Comportamiento de Cierre
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        accionista = new Accionista();

        textField1.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {
                accionista.setCuit((String) textField1.getText());
            }

            @Override
            public void caretPositionChanged(InputMethodEvent event) {

            }
        });
        textField2.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {
                accionista.setRazonSocial((String)textField2.getText());
            }

            @Override
            public void caretPositionChanged(InputMethodEvent event) {

            }
        });
        textField3.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {
                accionista.setPorcentajeParticipacion((String)textField3.getText());
            }

            @Override
            public void caretPositionChanged(InputMethodEvent event) {

            }
        });
        agregarAccionistaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setAttributesAcc();

                if(validateAccionista(accionista)){
                    accionistaList.add(accionista);
                    accionista = new Accionista();
                    JOptionPane.showMessageDialog(pnlPrincipal,"Accionista agregado exitosamente", "Ok", JOptionPane.INFORMATION_MESSAGE);

                    resetFields();
                } else {
                    JOptionPane.showMessageDialog(pnlPrincipal,"Ingrese los datos faltantes", "Ok", JOptionPane.INFORMATION_MESSAGE);                }

            }
        });
    }

    public boolean validateAccionista(Accionista accionista){
        if((accionista.getCuit()!=null && !accionista.getCuit().isBlank())
            && (accionista.getRazonSocial()!=null && !accionista.getRazonSocial().isEmpty())
            && (accionista.getPorcentajeParticipacion()!=null && !accionista.getPorcentajeParticipacion().isEmpty())){

            return true;
        }
        return false;
    }

    private void setAttributesAcc(){
        accionista.setCuit((String) textField1.getText());
        accionista.setRazonSocial((String)textField2.getText());
        accionista.setPorcentajeParticipacion((String)textField3.getText());
    }

    private void resetFields(){
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
    }
}

