package Front.MonetizarOperaciones;
import javax.swing.*;

public class MonetizarOpe {

    public class ComboBoxExample {
        JFrame f;
        ComboBoxExample(){
            f=new JFrame("Monetizacion de Operaciones");
            String operaciones[]={"Operacion 1","Operacion 2","Operacion 3","Operacion 4","Operacion 5"};
            JComboBox cb=new JComboBox(operaciones);
            cb.setBounds(50, 50,90,20);
            f.add(cb);
            f.setLayout(null);
            f.setSize(400,500);
            f.setVisible(true);
        }
        public void main(String[] args) {
            new ComboBoxExample();
        }
    }


}
