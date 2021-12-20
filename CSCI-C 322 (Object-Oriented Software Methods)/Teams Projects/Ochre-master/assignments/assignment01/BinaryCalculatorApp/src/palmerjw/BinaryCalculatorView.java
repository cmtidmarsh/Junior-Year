package palmerjw;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BinaryCalculatorView {

    private JFrame frmBinaryCalculator;
    private JPanel calculatorPanel;
    private JLabel label;
    private BinaryCalculatorController controller;


    BinaryCalculatorView(BinaryCalculatorController controller)
    {
        this.controller = controller;
        initialize();
    }

    public void setVisible(boolean bool)
    {
        frmBinaryCalculator.setVisible(true);
    }

    public void setScreenText(String str)
    {
        label.setText(str);
    }
    public BinaryCalculatorController getController()
    {
        return controller;
    }

    private void initialize() {
        //creates the frame
        frmBinaryCalculator = new JFrame();
        frmBinaryCalculator.setResizable(false);
        frmBinaryCalculator.setFont(new Font("Arial", Font.PLAIN, 12));
        frmBinaryCalculator.setTitle("Binary Calculator");
        frmBinaryCalculator.setBounds(100, 100, 600, 600);
        frmBinaryCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //creates the card panel
        calculatorPanel = new JPanel();
        frmBinaryCalculator.getContentPane().add(calculatorPanel, BorderLayout.CENTER);
        calculatorPanel.setLayout(new GridLayout(4,2));
        //initalizes all the panels used
        calculatorInitialization();

    }
    private void calculatorInitialization()
    {
        label = new JLabel("0");
        calculatorPanel.add(new JPanel());
        calculatorPanel.add(label);

        //creates a button
        JButton btnAdd = new JButton("+");

        //creates an action listener that checks for selected row and then goes to a different panel based on row info
        btnAdd.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent arg0)
            {
                controller.onOperationPress("+");
            }
        });
        //creates a button
        JButton btnSubtract = new JButton("-");


        //creates an actionlistener for button
        btnSubtract.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                controller.onOperationPress("-");
            }
        });

        JButton btnEquals = new JButton("=");
        btnEquals.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                controller.onEqualPress();
            }
        });

        JButton btnOne = new JButton("1");
        btnOne.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                controller.onDigitPress("1");
            }
        });

        JButton btnTwo = new JButton("0");
        btnTwo.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                controller.onDigitPress("0");
            }
        });

        JButton btnAC = new JButton("AC");
        btnAC.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                controller.onClearPress();
            }
        });

        calculatorPanel.add(btnAC);
        calculatorPanel.add(btnSubtract);
        calculatorPanel.add(btnTwo);
        calculatorPanel.add(btnAdd);
        calculatorPanel.add(btnOne);
        calculatorPanel.add(btnEquals);

    }
}
