package front;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pantalla implements ActionListener {

    public Pantalla(){

        JFrame frame = new JFrame();


        JButton button1 = new JButton("Cheque");
        button1.addActionListener(this);
        JButton button2 = new JButton("Comisiones");
        button1.addActionListener(this);
        JButton button3 = new JButton("ContraGarantia");
        button1.addActionListener(this);
        JButton button4 = new JButton("CuentaCorriente");
        button1.addActionListener(this);
        JButton button5 = new JButton("Pagare");
        button1.addActionListener(this);
        JButton button6 = new JButton("Prestamo");
        button1.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);


        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Menu de operaciones");
        frame.pack();
        frame.setVisible(true);


    }

    public static void main(String[] args) {

        new Pantalla();


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
