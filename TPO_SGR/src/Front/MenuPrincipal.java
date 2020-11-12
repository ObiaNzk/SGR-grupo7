package Front;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuPrincipal extends JFrame{
    private JPanel pnlPrincipal;
    private JPanel pnlMenu;
    private JButton button1;
    private JButton consultasSGRButton;
    private JButton test2Button;
    private JButton test3Button;
    private MenuPrincipal self;

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
    }

    private void asociarEventos(){
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OperacionesDisponibles frame = new OperacionesDisponibles(self, "Ingrese los datos del cheque. ");
                frame.setVisible(true);

            }
        });
    }

    public static void main(String[] args)
    {
        MenuPrincipal frame = new MenuPrincipal("Pantalla de Carga Operacion Test");

        frame.setVisible(true);


    }

}
