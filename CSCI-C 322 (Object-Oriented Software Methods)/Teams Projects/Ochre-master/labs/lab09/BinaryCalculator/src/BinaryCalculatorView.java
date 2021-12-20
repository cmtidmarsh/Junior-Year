import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;

public class BinaryCalculatorView extends JPanel implements ActionListener {
    protected JButton buttonZero, buttonOne, buttonClear, buttonSub, buttonAdd, buttonEqual;
    public JLabel display;


    public BinaryCalculatorView(){
        JFrame frame = new JFrame("BinaryCalculatorView");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setOpaque(true); //content panes must be opaque
        frame.setContentPane(this);

        buttonZero = new JButton("0");
        buttonZero.setActionCommand("0");
        buttonOne = new JButton("1");
        buttonOne.setActionCommand("1");
        buttonSub = new JButton("-");
        buttonSub.setActionCommand("-");
        buttonAdd = new JButton("+");
        buttonAdd.setActionCommand("+");
        buttonEqual = new JButton("=");
        buttonEqual.setActionCommand("=");
        buttonClear = new JButton("AC");
        buttonClear.setActionCommand("AC");

        JPanel panel = new JPanel();


        panel.setLayout(new GridLayout(2,2));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2,1));

        display = new JLabel("");
        display.setHorizontalAlignment(SwingConstants.RIGHT);
//        panel.add(new JLabel(" "));
//        panel.add(display);
//        panel.add(new JLabel(" "));
        mainPanel.add(display);

        panel.add(buttonZero);
        panel.add(buttonAdd);
        panel.add(buttonEqual);

        panel.add(buttonOne);
        panel.add(buttonSub);
        panel.add(buttonClear);
        mainPanel.add(panel);
        add(mainPanel);

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /*FOR TESTING PURPOSE ONLY*/
//    public static void main(String[] args) {
//        //Create and set up the window.
//        JFrame frame = new JFrame("BinaryCalculatorView");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        //Create and set up the content pane.
//        BinaryCalculatorView newContentPane = new BinaryCalculatorView();
//        newContentPane.setOpaque(true); //content panes must be opaque
//        frame.setContentPane(newContentPane);
//
//        //Display the window.
//        frame.pack();
//        frame.setVisible(true);
//
//        newContentPane.buttonZero.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                newContentPane.display.setText(newContentPane.display.getText() + "0");
//            }
//        });
//    }
}
