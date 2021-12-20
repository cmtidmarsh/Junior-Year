package Team13.BinaryCalc.View;

import javax.swing.*;
import java.awt.*;

public class CalculatorButtonPanel extends JPanel {
    public JButton btnOne, btnZero, btnPlus, btnMinus, btnEqual, btnClear;

    public CalculatorButtonPanel() {
        super();
        btnOne = new JButton("1");
        btnZero = new JButton("0");
        btnPlus = new JButton("+");
        btnMinus = new JButton("-");
        btnEqual = new JButton("=");
        btnClear = new JButton("AC");

        GridLayout layout = new GridLayout(0, 2);
        layout.setHgap(5);
        layout.setVgap(5);
        setLayout(layout);
        add(btnOne);
        add(btnZero);
        add(btnPlus);
        add(btnMinus);
        add(btnEqual);
        add(btnClear);
    }
}