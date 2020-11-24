package Front.OperacionesSocios;

import enums.TipoDeSocio;
import main.Sistema;
import main.Socio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SuscribirAccionesSParticipe extends JDialog{
    private JPanel jPanel;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JLabel labelComprador;
    private JLabel labelVendedor;
    private JButton suscribirAccionesButton;
    private JTextField textField1;
    private Sistema sistema;

    public SuscribirAccionesSParticipe(String titulo){

        //tamaño del panel.
        this.setSize(600, 300);

        this.setContentPane(jPanel);
        //No permite volver hasta la pantalla anterior hasta cerrar esta.

        //Inicio Centrado
        this.setLocationRelativeTo(null);

        this.setModal(true);

        //Comportamiento de Cierre
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        DefaultComboBoxModel modelVendedores = new DefaultComboBoxModel();
        DefaultComboBoxModel modelCompradores = new DefaultComboBoxModel();

        List<Socio> socioList = sistema.getInstance().getSgr().getSocios();
        List<Socio> sociosVendedores = new ArrayList<>();
        List<Socio> sociosCompradores = new ArrayList<>();

        for(Socio aux : socioList){
            if(TipoDeSocio.PARTICIPE.equals(aux.getTipoDeSocio())){
                if(aux.getAccionesSgrA() != null && !aux.getAccionesSgrA().isEmpty()){
                    sociosVendedores.add(aux);
                } else {
                    sociosCompradores.add(aux);
                }
            }
        }

        modelVendedores.addAll(sociosVendedores);
        modelCompradores.addAll(sociosCompradores);
        comboBox1.setModel(modelVendedores);
        comboBox2.setModel(modelCompradores);

        suscribirAccionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Socio socioVendedor = (Socio) comboBox1.getSelectedItem();
                Socio socioComprador = (Socio) comboBox2.getSelectedItem();
                Integer cantidad = Integer.valueOf(textField1.getText());

//                if(validateExcedeMonto(socioVendedor.getAccionesSgrA(), cantidad)){
//
//                    JOptionPane.showMessageDialog(jPanel,"La cantidad a comprar es mayor a la del vendedor", "Error", JOptionPane.INFORMATION_MESSAGE);
//                } else {

                    if(socioVendedor != null && socioComprador != null){

                        try {
                            sistema.getInstance().VentaDeAcciones(socioVendedor, socioComprador, cantidad);
                            JOptionPane.showMessageDialog(jPanel,"Operacion procesada correctamente", "Ok", JOptionPane.INFORMATION_MESSAGE);
                        } catch (Exception e1){
                            JOptionPane.showMessageDialog(jPanel,"Error al querer suscribir acciones", "Error", JOptionPane.INFORMATION_MESSAGE);
                            e1.printStackTrace();
                        }
                    }
//                }

            }
        });
    }

//    private Boolean validateExcedeMonto(List<String> accionesVendedor, Integer cantidadAComprar){
//
//        Integer cantidadVendedor = 0;
//        for(String aux : accionesVendedor){
//            cantidadVendedor += Integer.valueOf(aux);
//        }
//
//        return cantidadAComprar<cantidadVendedor ? Boolean.FALSE : Boolean.TRUE;
//    }
}
