import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class BinaryCalculatorController implements Observer {
    BinaryCalculatorView view;
    BinaryCalculatorModel model;

    public BinaryCalculatorController(BinaryCalculatorView view, BinaryCalculatorModel model)
    {
        this.view = view;
        this.model = model;

        this.view.buttonZero.addActionListener(new ZeroListener());
        this.view.buttonOne.addActionListener(new OneListener());
        this.view.buttonSub.addActionListener(new SubListener());
        this.view.buttonAdd.addActionListener(new AddListener());
        this.view.buttonEqual.addActionListener(new EqualsListener());
        this.view.buttonClear.addActionListener(new ClearListener());
        model.addObserver(this);
//        view.clear();
    }

    @Override
    public void update(Observable o, Object arg)
    {
          view.display.setText("" + arg);
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
            model.setFirstOperand(Integer.parseInt(view.display.getText()));
            model.setOperation('-');
            //view.display.setText("");
        }
    }

    class AddListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            model.setFirstOperand(Integer.parseInt(view.display.getText()));
            model.setOperation('+');
            //view.display.setText("");
        }
    }

    class EqualsListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            model.setSecondOperand(Integer.parseInt(view.display.getText()));
            model.setResult(model.result);
            //view.display.setText("" + model.getResult());
        }
    }

    class ClearListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            model.setFirstOperand(0);
            model.setSecondOperand(0);
            view.display.setText("");
        }
    }

}
