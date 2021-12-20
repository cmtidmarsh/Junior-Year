import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.*;


public class binaryCalcView {
    private JFrame frame;
    private JLabel label;
    private JButton button0, button1, equals, ac, plus, minus;
    private JTextField displaysOperands;

    public static class CalcComponent extends JComponent { //this one draws the rectangles, called in the main
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;

            Rectangle bigBox = new Rectangle(0, 0, 400, 100);
            g2.draw(bigBox);

            Rectangle smallBox = new Rectangle(50, 50, 50, 50);

            smallBox.translate(75, 75);

            g2.draw(smallBox);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(300,400);
        frame.setTitle("Binary Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel statusLabel = new JLabel();
        statusLabel = new JLabel("HELLO",JLabel.CENTER);
        statusLabel.setSize(350,100);


        JButton button0 = new JButton("0");
        JLabel finalStatusLabel = statusLabel;
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {          //we need to change the insides of the method so that
                                                                  //it sets the value
                finalStatusLabel.setText("0");
            }
        });

        JButton button1 = new JButton("1");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalStatusLabel.setText("1");
            }
        });

        JButton equals = new JButton("=");
        equals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalStatusLabel.setText("=");
            }
        });

        JButton ac = new JButton("AC");
        ac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalStatusLabel.setText("HELLO");
            }
        });

        JButton plus = new JButton("+");
        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalStatusLabel.setText("+");
            }
        });

        JButton minus = new JButton("-");
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalStatusLabel.setText("-");
            }
        });


        JPanel panel = new JPanel(); //top panel with the top buttons
        panel.add(ac);
        panel.add(button0);
        panel.add(button1);
        frame.getContentPane( ).add(panel,BorderLayout.NORTH);

        JPanel panel1 = new JPanel(); //bottom panel with the bottom buttons
        panel1.add(plus);
        panel1.add(minus);
        panel1.add(equals);
        frame.getContentPane( ).add(panel1,BorderLayout.SOUTH);



        CalcComponent component = new CalcComponent(); //this one draws the rectangles
        frame.add(component);
        frame.add(statusLabel);

        frame.setVisible(true);
    }
}