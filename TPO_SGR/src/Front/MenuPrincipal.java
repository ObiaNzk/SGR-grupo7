package Front;

<<<<<<< HEAD
import Front.ComboBox.*;
=======
import Front.ConsultasSGR.ConsultasSGR;
import Front.OperacionesSocios.PanelSolapadoOperaciones;
import Front.ABMSocios.ABMSocios;
>>>>>>> c3be6ededd929e2d05c14f3f06921191c8e107d7

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuPrincipal extends JFrame{
    private JPanel pnlPrincipal;
    private JPanel pnlMenu;
    private JButton button1;
    private JButton consultasSGRButton;
    private JButton sociosButton;
<<<<<<< HEAD
    private JButton comisionesEnUnDiaButton;
    private JButton promediosTasasChequesPagaresButton;
    private JButton consultarPorcentajeComisionSegunButton;
    private JButton consultaConsolidadaButton;
    private JButton crearEmpresaButton;
=======
>>>>>>> c3be6ededd929e2d05c14f3f06921191c8e107d7
    private MenuPrincipal self;
    private JComboBox<String> comboBoxSocio;

    public MenuPrincipal(String titulo) {
        super(titulo);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
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
<<<<<<< HEAD


        comisionesEnUnDiaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ComisionesEnUnDia frame = new ComisionesEnUnDia(self, "Comisiones en un dia");
                frame.setVisible(true);
            }
        });
        promediosTasasChequesPagaresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ValorPromedioTasaYCheques frame = new ValorPromedioTasaYCheques(self);
                frame.setVisible(true);
            }
        });
        consultarPorcentajeComisionSegunButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsultarPorcentajeComisionPorOp frame = new ConsultarPorcentajeComisionPorOp(self);
                frame.setVisible(true);
            }
        });
        consultaConsolidadaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsultaConsolidadaView frame = new ConsultaConsolidadaView();
                frame.setVisible(true);
            }
        });
        crearEmpresaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                CrearEmpresa frame = new CrearEmpresa(self);
=======
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
                ABMSocios frame = new ABMSocios( self,"Seleccione el tipo de operatoria para socio.");
>>>>>>> c3be6ededd929e2d05c14f3f06921191c8e107d7
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

        sociosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OperacionesMonetizadasView frameSocios = new OperacionesMonetizadasView(self);
                frameSocios.setVisible(true);
            }
        });

    }

    public static void main(String[] args)
    {
        MenuPrincipal frame = new MenuPrincipal(" Hola ADMIN, selecciona una opción. ");

        frame.setVisible(true);

    }

}
