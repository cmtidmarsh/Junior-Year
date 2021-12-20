import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;


//Client class
public class CalculatorClient{
    CalculatorServer BinaryCalculator;
    CalculatorView CalculatorInterface;

    public CalculatorClient(CalculatorServer model){
        this.BinaryCalculator = model;
        this.CalculatorInterface = new CalculatorView();
    }

    public static void main(String[] args) {
        try {
            Remote robj = Naming.lookup("Calculator");
            CalculatorServer calculator = new CalculatorServer();
            CalculatorClient controller = new CalculatorClient(calculator);
            controller.CalculatorInterface.initializeView();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void clickNumberButton(int button) throws RemoteException {
        if(this.BinaryCalculator.operation.equals("")){
            //blank
            if(BinaryCalculator.firstOperand == 0) {
                BinaryCalculator.setFirstOperand(button);
            }else{
                //not blank
                String i = "" + BinaryCalculator.firstOperand + button;
                BinaryCalculator.setFirstOperand(Integer.parseInt(i));
            }

        }else {
            //blank
            if (BinaryCalculator.secondOperand == 0) {
                BinaryCalculator.setSecondOperand(button);
            } else {
                //not blank
                String j = "" + BinaryCalculator.secondOperand + button;
                BinaryCalculator.setSecondOperand(Integer.parseInt(j));
            }
        }
    }

    public void clickOperand(String operand) throws RemoteException {
        BinaryCalculator.setOperation(operand);

    }

    public void clickResult() throws RemoteException {
        BinaryCalculator.performOperation(BinaryCalculator.firstOperand,
                BinaryCalculator.secondOperand, BinaryCalculator.operation);

        BinaryCalculator.firstOperand = BinaryCalculator.result;
        BinaryCalculator.secondOperand = 0;
    }

    public void clickClear() {
        BinaryCalculator.clear();
    }

    public class CalculatorView extends JFrame {

        public CalculatorView() {
            setTitle("CalculatorView");
            setSize(400, 400);
            initializeView();
        }

        private void initializeView(){
            JPanel panel = new JPanel();
            JLabel display = new JLabel();
//            display.setBounds(200, 200, 400 , 400);
//            display.setSize(new Dimension(350, 350));

            // Create JButton and JPanel
            JButton Button1 = new JButton("Sum");
            Button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        clickOperand("+");
                    } catch (RemoteException remoteException) {
                        remoteException.printStackTrace();
                    }
                    display.setText(BinaryCalculator.firstOperand + " " + BinaryCalculator.operation + " " + BinaryCalculator.secondOperand);
                }
            });
            JButton Button2 = new JButton("Diff");
            Button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        clickOperand("-");
                    } catch (RemoteException remoteException) {
                        remoteException.printStackTrace();
                    }
                    display.setText(BinaryCalculator.firstOperand + " " + BinaryCalculator.operation + " " + BinaryCalculator.secondOperand);
                }
            });
            JButton Button3 = new JButton("1");
            Button3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        clickNumberButton(1);
                    } catch (RemoteException remoteException) {
                        remoteException.printStackTrace();
                    }
                    System.out.println(BinaryCalculator.firstOperand + ", " + BinaryCalculator.secondOperand);
                    display.setText(BinaryCalculator.firstOperand + " " + BinaryCalculator.operation + " " + BinaryCalculator.secondOperand);
                }
            });
            JButton Button4 = new JButton("0");
            Button4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        clickNumberButton(0);
                    } catch (RemoteException remoteException) {
                        remoteException.printStackTrace();
                    }
                    System.out.println(BinaryCalculator.firstOperand + ", " + BinaryCalculator.secondOperand);
                    display.setText(BinaryCalculator.firstOperand + " " + BinaryCalculator.operation + " " + BinaryCalculator.secondOperand);
                }
            });
            JButton Button5 = new JButton("=");
            Button5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        clickResult();
                    } catch (RemoteException remoteException) {
                        remoteException.printStackTrace();
                    }
                    display.setText(BinaryCalculator.result + "");
                }
            });
            JButton Button6 = new JButton("A/C");
            Button6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    clickClear();
                    System.out.println(BinaryCalculator.firstOperand + ", " + BinaryCalculator.secondOperand);
                    display.setText("");
                }
            });
            // Add button to JPanel
            panel.add(Button1);
            panel.add(Button2);
            panel.add(Button3);
            panel.add(Button4);
            panel.add(Button5);
            panel.add(Button6);

            panel.add(display);

            // And JPanel needs to be added to the JFrame itself!
            this.getContentPane().add(panel);

            setVisible(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }

    }
}
