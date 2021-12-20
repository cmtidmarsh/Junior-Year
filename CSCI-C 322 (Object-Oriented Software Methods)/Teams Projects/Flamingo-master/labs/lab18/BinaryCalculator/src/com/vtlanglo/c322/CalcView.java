//package com.vtlanglo.c322;

import javax.swing.*;
import java.awt.*;

public class CalcView extends JFrame {
    public JButton zeroButton;
    public JButton oneButton;
    public JButton acClearButton;
    public JButton subtractButton;
    public JButton addButton;
    public JButton equalsButton;
    public JLabel display;
    JPanel panel;

    public String getDisplayValue() { //the team before us didnot give us return type for this, so I made it String -v
        return ""; //TODO
    }

    public void setDisplayValue() {

    }

    CalcView() {
        panel = new JPanel();
        panel.setLayout(null);

        display = new JLabel("");
        display.setBounds(20, 20, 300, 20);
        panel.add(display);

        zeroButton = new JButton("0");
        zeroButton.setBounds(20, 300, 50, 50);
        panel.add(zeroButton);

        oneButton = new JButton("1");
        oneButton.setBounds(20, 240, 50, 50);
        panel.add(oneButton);

        acClearButton = new JButton("AC");
        acClearButton.setBounds(20, 180, 50, 50);
        panel.add(acClearButton);

        equalsButton = new JButton("=");
        equalsButton.setBounds(100, 300, 50, 50);
        panel.add(equalsButton);

        addButton = new JButton("+");
        addButton.setBounds(100, 240, 50, 50);
        panel.add(addButton);

        subtractButton = new JButton("-");
        subtractButton.setBounds(100, 180, 50, 50);
        panel.add(subtractButton);

        this.add(panel);
        this.setSize(200, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        CalcView calcView = new CalcView();
    }

}
