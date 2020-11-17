package Front.ComboBox;

import main.Sistema;
import operaciones.Comision;
import operaciones.Comisiones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComisionesEnUnDia extends JDialog{

    private JButton calcularComisionesEnUnButton;
    private JLabel labelComision;
    private JPanel jPanel;
    private Sistema sistema;
    private List<Comision> comisionList = new ArrayList<>();

    public ComisionesEnUnDia(Window owner, String comisiones_en_un_dia){

        super(owner, "Comisiones en un dia");

        this.setContentPane(jPanel);
        this.setSize(300, 300);
        this.setModal(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);


        calcularComisionesEnUnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comisionList =  sistema.getInstance().comisionesEnUnDia(new Date());
            }
        });

        labelComision.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {

                //SETEAR  RESPONSE comisionList
//                    labelComision.setText();
            }

            @Override
            public void caretPositionChanged(InputMethodEvent event) {

            }
        });
    }
}
