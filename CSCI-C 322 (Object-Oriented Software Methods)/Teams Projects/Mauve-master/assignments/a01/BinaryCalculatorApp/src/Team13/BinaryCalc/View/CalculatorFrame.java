package Team13.BinaryCalc.View;
import javax.swing.*;

public class CalculatorFrame extends JFrame {
    public CalculatorScreenPanel screen;
    public CalculatorButtonPanel buttons;

    public CalculatorFrame() {
        super("Binary Calculator");
        setBounds(100, 100, 900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        screen = new CalculatorScreenPanel();
        screen.setScreenText("0");

        buttons = new CalculatorButtonPanel();

        add(screen);
        add(buttons);
        setVisible(true);
    }

    public static void main(String[] args) {
        CalculatorFrame frame = new CalculatorFrame();
    }
}
