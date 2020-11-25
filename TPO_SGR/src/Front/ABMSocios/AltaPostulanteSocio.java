package Front.ABMSocios;

import constants.Constants;
import documentaciones.DocumentosRegistracion;
import dtos.AltaSocioDTO;
import enums.EstadoDocumentacion;
import enums.TamañoEmpresaEnum;
import enums.TipoDeSocio;
import main.*;
import operaciones.LineaDeCredito;

import javax.swing.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AltaPostulanteSocio extends JDialog {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox comboBox1;
    private JButton agregarAccionistasButton;
    private JButton ALTASOCIOButton;
    private JTextField bienesFIeld;
    private JPanel pnlPrincipal;
    private JComboBox comboBox3;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JLabel labelError;
    private JTextField textField8;
    private JTextField textField9;
    private JLabel balancesField;
    private JLabel estatutoField;
    private Date dateDesde = null;
    private List<TipoDeSocio> tipoDeSocioList = new ArrayList<>();
    private List<TamañoEmpresaEnum> tamañoEmpresaEnumList = new ArrayList<>();
    private Empresa empresa;
    private Socio socio;
    private Accionista accionista;
    private Sistema sistema;
    private Solicitante solicitante;
    private DocumentosRegistracion documentosRegistracion;
    private AltaSocioDTO altaSocioDTO;



    public AltaPostulanteSocio(String titulo) {
        //Define un owner que gestiona su lanzamiento, (panel principal, clase Operatoria Cheque.


        //tamaño del panel.
        this.setSize(600, 1000);

        this.setContentPane(pnlPrincipal);
        //No permite volver hasta la pantalla anterior hasta cerrar esta.

        //Inicio Centrado
        this.setLocationRelativeTo(null);

        this.setModal(true);

        DefaultComboBoxModel modelTipoSocio = new DefaultComboBoxModel();
        tipoDeSocioList.add(TipoDeSocio.PROTECTORES);
        tipoDeSocioList.add(TipoDeSocio.PARTICIPE);
        modelTipoSocio.addAll(tipoDeSocioList);
        comboBox3.setModel(modelTipoSocio);


        DefaultComboBoxModel modelTipoEmpresa = new DefaultComboBoxModel();
        tamañoEmpresaEnumList.add(TamañoEmpresaEnum.GRANDE);
        tamañoEmpresaEnumList.add(TamañoEmpresaEnum.MEDIANA);
        tamañoEmpresaEnumList.add(TamañoEmpresaEnum.PEQUEÑA);
        modelTipoEmpresa.addAll(tamañoEmpresaEnumList);
        comboBox1.setModel(modelTipoEmpresa);

        empresa = new Empresa();
        socio = new Socio();
        solicitante = new Solicitante();
        documentosRegistracion = new DocumentosRegistracion();
        altaSocioDTO = new AltaSocioDTO();

        //Comportamiento de Cierre
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        agregarAccionistasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Accionista> accionistaList;

                if(empresa.getAccionistaList() != null){
                     accionistaList = empresa.getAccionistaList();
                } else {
                    empresa.setAccionistaList(new ArrayList<>());
                    accionistaList = empresa.getAccionistaList();
                }



                AccionistasSocio frame = new AccionistasSocio("Nuevo accionista", accionistaList);
                frame.setVisible(true);

            }
        });
        textField1.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {
                empresa.setRazonSocial((String) textField1.getText());
            }

            @Override
            public void caretPositionChanged(InputMethodEvent event) {

            }
        });
        textField2.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {
                empresa.setCuit((String)textField2.getText());
            }

            @Override
            public void caretPositionChanged(InputMethodEvent event) {

            }
        });
        comboBox1.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {
                empresa.setTamañoEmpresaEnum((TamañoEmpresaEnum) comboBox1.getSelectedItem());
            }

            @Override
            public void caretPositionChanged(InputMethodEvent event) {

            }
        });
        textField3.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {

                try {
                    dateDesde = new SimpleDateFormat("dd/MM/yyyy").parse(textField3.getText());
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                empresa.setFechaDeInicio(dateDesde);
            }

            @Override
            public void caretPositionChanged(InputMethodEvent event) {

            }
        });

        bienesFIeld.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {

            }

            @Override
            public void caretPositionChanged(InputMethodEvent event) {

            }
        });

        ALTASOCIOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                List<Socio> sociosSgrList = sistema.getInstance().getSgr().getSocios();

                setAttributes();

                if(validateDatosSocio(socio) && !validateSocioExiste(sociosSgrList) && validateDocRegistracion(documentosRegistracion)){

                    solicitante.setEmpresa(empresa);
                    solicitante.setEstadoDocumentacion(EstadoDocumentacion.INGRESADO);
                    solicitante.setDocumentacionRegistracion(documentosRegistracion);

                    if(sistema.getInstance().getSolicitanteList() != null){
                        sistema.getInstance().getSolicitanteList().add(solicitante);
                    } else {
                        sistema.getInstance().setSolicitanteList(new ArrayList<>());
                        sistema.getInstance().getSolicitanteList().add(solicitante);
                    }

                    sociosSgrList.add(socio);
                    JOptionPane.showMessageDialog(pnlPrincipal,"Socio agregado exitosamente", "Ok", JOptionPane.INFORMATION_MESSAGE);

                resetFields();

                } else {

                    getErrors();
                }

            }
        });
        comboBox3.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {
                socio.setTipoDeSocio((TipoDeSocio) comboBox3.getSelectedItem());
            }

            @Override
            public void caretPositionChanged(InputMethodEvent event) {

            }
        });
        bienesFIeld.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {
                documentosRegistracion.setBienesSocios(new ArrayList<>());
                documentosRegistracion.getBienesSocios().add((String) bienesFIeld.getText());

            }

            @Override
            public void caretPositionChanged(InputMethodEvent event) {

            }
        });
        textField8.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {
                documentosRegistracion.setBalanceCertificado1((String) textField8.getText());
            }

            @Override
            public void caretPositionChanged(InputMethodEvent event) {

            }
        });
        textField9.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {
                documentosRegistracion.setEstatuto((String) textField9.getText());
            }

            @Override
            public void caretPositionChanged(InputMethodEvent event) {

            }
        });
    }

    public Boolean validateDatosSocio(Socio socio){

        Empresa empresa = socio.getEmpresa();

        if((empresa.getCuit() != null && !empresa.getCuit().isEmpty()) && (empresa.getDireccion() != null && !empresa.getDireccion().isEmpty())
            && (empresa.getRazonSocial() != null && !empresa.getRazonSocial().isEmpty()) && (empresa.getCorreoElectronico() != null &&
                !empresa.getCorreoElectronico().isEmpty()) && (empresa.getFechaDeInicio() != null) && (empresa.getTamañoEmpresaEnum() != null)
                && (empresa.getTelefono() != null && !empresa.getTelefono().isEmpty()) && empresa.getTamañoEmpresaEnum() != null
                    && socio.getTipoDeSocio() != null){

            altaSocioDTO.setErrorFaltaDoc(Boolean.FALSE);
            return Boolean.TRUE;
        }

        altaSocioDTO.setErrorFaltaDoc(Boolean.TRUE);
        return Boolean.FALSE;

    }

    public Boolean validateDocRegistracion(DocumentosRegistracion documentosRegistracion){

        if(!documentosRegistracion.getBienesSocios().isEmpty() && documentosRegistracion.getBalanceCertificado1()!= null &&
            !documentosRegistracion.getBalanceCertificado1().isEmpty() && documentosRegistracion.getEstatuto() != null
                && !documentosRegistracion.getEstatuto().isEmpty()){
            altaSocioDTO.setErrorFaltaDoc(Boolean.FALSE);
            return Boolean.TRUE;

        }
        altaSocioDTO.setErrorFaltaDoc(Boolean.TRUE);
        return Boolean.FALSE;

    }

    public Boolean validateSocioExiste(List<Socio> sociosSgrList){

        for(Socio so : sociosSgrList){
            if(empresa.getCuit() == so.getEmpresa().getCuit()){
                altaSocioDTO.setErrorSocioExiste(Boolean.TRUE);
                return Boolean.TRUE;
            }
        }
        altaSocioDTO.setErrorSocioExiste(Boolean.FALSE);
        return Boolean.FALSE;
    }

    public void getErrors(){

        if(altaSocioDTO.getErrorFaltaDoc()){
            labelError.setText(Constants.ERR_FALTA_DOC);
        } else if (altaSocioDTO.getErrorSocioExiste()){
            labelError.setText(Constants.ERR_SOCIO_EXISTE);
        }
    }

    public void setAttributes(){

        empresa.setRazonSocial((String) textField1.getText());

        empresa.setCuit((String)textField2.getText());
        empresa.setTamañoEmpresaEnum((TamañoEmpresaEnum) comboBox1.getSelectedItem());
        empresa.setDireccion((String) textField6.getText());
        empresa.setTelefono((String) textField5.getText());
        empresa.setCorreoElectronico((String) textField6.getText());

        try {
            dateDesde = new SimpleDateFormat("dd/MM/yyyy").parse(textField3.getText());
            empresa.setFechaDeInicio(dateDesde);
        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }

        documentosRegistracion.setBienesSocios(new ArrayList<>());
        documentosRegistracion.getBienesSocios().add((String) bienesFIeld.getText());
        documentosRegistracion.setBalanceCertificado1((String) textField8.getText());
        documentosRegistracion.setEstatuto((String) textField9.getText());

        socio.setNombre((String) textField1.getText());
        socio.setTipoDeSocio((TipoDeSocio) comboBox3.getSelectedItem());

        if(TipoDeSocio.PARTICIPE.equals(socio.getTipoDeSocio())){
            Calendar cal = Calendar.getInstance();
            Date date = cal.getTime();
            socio.setLineaDeCredito(new LineaDeCredito(1000, date, true));
            socio.setAccionesSgrA(new ArrayList<>());
        } else {
            socio.setAccionesSgrB(new ArrayList<>());
        }

        socio.setEmpresa(empresa);
    }

    private void resetFields(){
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField5.setText("");
        textField6.setText("");
        textField7.setText("");
        textField8.setText("");
        textField9.setText("");
        balancesField.setText("");
        estatutoField.setText("");
        bienesFIeld.setText("");
    }

}
