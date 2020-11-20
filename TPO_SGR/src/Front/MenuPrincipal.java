package Front;

import Front.ConsultasSGR.ConsultasSGR;
import Front.OperacionesSocios.MonetizarOperaciones.MonetizarOperacionesMenu;
import Front.OperacionesSocios.PanelSolapadoOperaciones;
import Front.ABMSocios.ABMSocios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuPrincipal extends JFrame{
    private JPanel pnlPrincipal;
    private JPanel pnlMenu;
    private JButton button1;
    private JButton consultasSGRButton;
    private JButton sociosButton;
    private JButton OperarButtom;
    private MenuPrincipal self;

    public MenuPrincipal(String titulo) {
        super(titulo);
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setContentPane(pnlPrincipal);

        //Definición de tamaño del panel.
        this.setSize(400, 400);

        //Comportamiento de Cierre
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Inicio Centrado
        this.setLocationRelativeTo(null);

        this.asociarEventos();
        this.self = this;
        consultasSGRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsultasSGR frame = new ConsultasSGR(self, "Operatoria Disponible");
                frame.setVisible(true);

            }
        });
        sociosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ABMSocios frame = new ABMSocios( "Seleccione el tipo de operatoria para socio.");
                frame.setVisible(true);
            }
        });
        OperarButtom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MonetizarOperacionesMenu frame = new MonetizarOperacionesMenu("Seleccione Operacion a realizar");
                frame.setVisible(true);
            }
        });
    }

    private void asociarEventos(){
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelSolapadoOperaciones frame = new PanelSolapadoOperaciones(self, "Seleccione un tipo de operación. ");
                frame.setVisible(true);


            }


        });
    }

    public static void main(String[] args)
    {
        MenuPrincipal frame = new MenuPrincipal(" Hola ADMIN, selecciona una opción. ");

        frame.setVisible(true);


    }

}
