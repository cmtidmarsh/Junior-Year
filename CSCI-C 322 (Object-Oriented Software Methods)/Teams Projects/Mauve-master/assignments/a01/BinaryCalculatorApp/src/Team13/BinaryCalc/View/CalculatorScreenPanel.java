package Team13.BinaryCalc.View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CalculatorScreenPanel extends JPanel {
    private JLabel screenLabel;

    public CalculatorScreenPanel() {
        super();
        screenLabel = new JLabel("", JLabel.RIGHT);
        screenLabel.setPreferredSize(new Dimension(900, 300));
        screenLabel.setBorder(new EmptyBorder(0, 10, 0, 10));
        screenLabel.setFont(new Font("serif", Font.PLAIN, 64));
        screenLabel.setBackground(Color.WHITE);
        screenLabel.setOpaque(true);
        add(screenLabel);
    }

    public void setScreenText(String text) {
        screenLabel.setText(text);
    }

    public String getScreenText() {
        return screenLabel.getText();
    }

    public void clearScreen() {
        screenLabel.setText("");
    }
}
