package Front.ConsultasSGR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//Extiende de Jdialog para utilizar los métodos que le dan vida la interfaz.
public class ConsultasSGR extends JDialog {

    private JPanel pnlPrincipal;
    private JButton operacionesMonetizadas;
    private JButton ConsultaConsolidadaRVTU;
    private JButton ConsultaSaldoMora;
    private JButton CalculoComisionPorParametro;
    private JButton consultaConsolidadaPorSocio;
    private JButton totalDeComisionesCalculadasButton;
    private JButton aportesDeUnSocioButton;

    public ConsultasSGR(Window owner, String titulo) {
        //Define un owner que gestiona su lanzamiento, (panel principal, clase Operatoria Cheque.
        super(owner, titulo);

        //tamaño del panel.
        this.setSize(300, 300);

        this.setContentPane(pnlPrincipal);
        //No permite volver hasta la pantalla anterior hasta cerrar esta.

        //Inicio Centrado
        this.setLocationRelativeTo(null);

        this.setModal(true);

        //Comportamiento de Cierre
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        operacionesMonetizadas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OperacionesMonetizadasPorSocio frame = new OperacionesMonetizadasPorSocio("Consulta de operaciones monetizadas");
                frame.setVisible(true);

            }
        });
        consultaConsolidadaPorSocio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PromedioDeTazas frame = new PromedioDeTazas("Valor promedio de la tasa de descuento");
                frame.setVisible(true);
            }
        });
        CalculoComisionPorParametro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CalculodeComisionPorParámetro frame = new CalculodeComisionPorParámetro("Calculo Comision Por Parámetro");
                frame.setVisible(true);

            }
        });

        ConsultaConsolidadaRVTU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsultaConsolidada frame = new ConsultaConsolidada("Consulta Consolidada");
                frame.setVisible(true);

            }
        });
        totalDeComisionesCalculadasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ComisionesChequesEnUnDia frame = new ComisionesChequesEnUnDia("Comisiones de cheques en un dia");
                frame.setVisible(true);
            }
        });
        aportesDeUnSocioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AportesSocio frame = new AportesSocio("Aportes de un socio Protector");
                frame.setVisible(true);
            }
        });
    }
}


