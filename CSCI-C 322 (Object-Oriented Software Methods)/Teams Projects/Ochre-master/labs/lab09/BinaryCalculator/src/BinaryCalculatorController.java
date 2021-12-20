import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Observable;
import java.util.Observer;

public class BinaryCalculatorController {
    BinaryCalculatorView view;
    CalculatorModelInterface model;

    public BinaryCalculatorController(BinaryCalculatorView view, CalculatorModelInterface model)
    {
        this.view = view;
        this.model = model;

        this.view.buttonZero.addActionListener(new ZeroListener());
        this.view.buttonOne.addActionListener(new OneListener());
        this.view.buttonSub.addActionListener(new SubListener());
        this.view.buttonAdd.addActionListener(new AddListener());
        this.view.buttonEqual.addActionListener(new EqualsListener());
        this.view.buttonClear.addActionListener(new ClearListener());
//        view.clear();
    }

    // These listeners are what the design team wanted in update
    class ZeroListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            view.display.setText(view.display.getText() + "0");
        }
    }

    class OneListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            view.display.setText(view.display.getText() + "1");
        }
    }

    class SubListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            try {
                model.setFirstOperand(Integer.parseInt(view.display.getText()));
            } catch (RemoteException remoteException) {
                remoteException.printStackTrace();
            }
            try {
                model.setOperation('-');
            } catch (RemoteException remoteException) {
                remoteException.printStackTrace();
            }
            view.display.setText("");
        }
    }

    class AddListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            try {
                model.setFirstOperand(Integer.parseInt(view.display.getText()));
            } catch (RemoteException remoteException) {
                remoteException.printStackTrace();
            }
            try {
                model.setOperation('+');
            } catch (RemoteException remoteException) {
                remoteException.printStackTrace();
            }
            view.display.setText("");
        }
    }

    class EqualsListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            try {
                model.setSecondOperand(Integer.parseInt(view.display.getText()));
            } catch (RemoteException remoteException) {
                remoteException.printStackTrace();
            }
            try {
                model.setResult(model.getResult());
            } catch (RemoteException remoteException) {
                remoteException.printStackTrace();
            }
            try {
                view.display.setText("" + model.getResult());
            } catch (RemoteException remoteException) {
                remoteException.printStackTrace();
            }
        }
    }

    class ClearListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            try {
                model.setFirstOperand(0);
            } catch (RemoteException remoteException) {
                remoteException.printStackTrace();
            }
            try {
                model.setSecondOperand(0);
            } catch (RemoteException remoteException) {
                remoteException.printStackTrace();
            }
            view.display.setText("");
        }
    }

}
