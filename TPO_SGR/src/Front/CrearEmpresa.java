package Front;

import enums.TamañoEmpresaEnum;
import main.Accionista;
import main.Empresa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class CrearEmpresa extends JDialog{
    private JPanel jPanel;
    private JTextField cuitField;
    private JTextField razonSocialField;
    private JComboBox tipoEmpresaCombo;
    private JTextField actividadEmpresaField;
    private JTextField direccionField;
    private JTextField telefonoField;
    private JTextField emailField;
    private JTextField cuitAccionistaField;
    private JTextField razonSocialAccionista;
    private JTextField porcentajePartAccionistaField;
    private JButton agregarAccionistaButton;
    private JLabel accionistaErrorLabel;
    private JButton agregarEmpresaButton;
    private List<TamañoEmpresaEnum> tamañoEmpresaEnumList = new ArrayList<>();
    private Empresa empresa;
    private Accionista accionista;

    public CrearEmpresa(Window owner){

        this.setContentPane(jPanel);
        this.setSize(400, 400);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        DefaultComboBoxModel model = new DefaultComboBoxModel();
        tamañoEmpresaEnumList.add(TamañoEmpresaEnum.GRANDE);
        tamañoEmpresaEnumList.add(TamañoEmpresaEnum.MEDIANA);
        tamañoEmpresaEnumList.add(TamañoEmpresaEnum.PEQUEÑA);

        model.addAll(tamañoEmpresaEnumList);
        tipoEmpresaCombo.setModel(model);

        empresa = new Empresa();
        accionista = new Accionista();

        cuitField.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {
                empresa.setCuit((String) cuitField.getText());
            }

            @Override
            public void caretPositionChanged(InputMethodEvent event) {

            }
        });
        razonSocialField.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {
                empresa.setRazonSocial((String) razonSocialField.getText());
            }

            @Override
            public void caretPositionChanged(InputMethodEvent event) {

            }
        });
        tipoEmpresaCombo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                empresa.setTamañoEmpresaEnum((TamañoEmpresaEnum) tipoEmpresaCombo.getSelectedItem());
            }
        });
        actividadEmpresaField.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {
                empresa.setActividadPrincipal((String) actividadEmpresaField.getText());
            }

            @Override
            public void caretPositionChanged(InputMethodEvent event) {

            }
        });
        direccionField.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {
                empresa.setActividadPrincipal((String) direccionField.getText());
            }

            @Override
            public void caretPositionChanged(InputMethodEvent event) {

            }
        });
        telefonoField.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {
                empresa.setTelefono((String) telefonoField.getText());
            }

            @Override
            public void caretPositionChanged(InputMethodEvent event) {

            }
        });
        emailField.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {
                empresa.setCorreoElectronico((String) emailField.getText());
            }

            @Override
            public void caretPositionChanged(InputMethodEvent event) {

            }
        });
        cuitAccionistaField.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {
                accionista.setCuit((String) cuitAccionistaField.getText());
            }

            @Override
            public void caretPositionChanged(InputMethodEvent event) {

            }
        });
        razonSocialAccionista.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {
                accionista.setRazonSocial((String) razonSocialAccionista.getText());
            }

            @Override
            public void caretPositionChanged(InputMethodEvent event) {

            }
        });
        porcentajePartAccionistaField.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {
                accionista.setPorcentajeParticipacion((String) porcentajePartAccionistaField.getText());
            }

            @Override
            public void caretPositionChanged(InputMethodEvent event) {

            }
        });
        agregarAccionistaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if((accionista.getCuit() != null && !accionista.getCuit().isEmpty()) && (accionista.getRazonSocial() != null
                && !accionista.getRazonSocial().isEmpty()) && (accionista.getPorcentajeParticipacion() != null &&
                        !accionista.getPorcentajeParticipacion().isEmpty())){

                    empresa.getAccionistaList().add(accionista);
                    accionista = new Accionista();
                    razonSocialAccionista.setText("");
                    razonSocialAccionista.setText("");
                    porcentajePartAccionistaField.setText("");
                    accionistaErrorLabel.setText("");
                } else {

                    accionistaErrorLabel.setText("Ingrese los datos faltantes");
                }

            }
        });
        agregarEmpresaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


}
