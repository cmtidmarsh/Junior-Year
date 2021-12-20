

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

public class CalcController implements ActionListener { //TODO check if implements is the correct use here
    CalcModel model = new CalcModel();
    CalcView view = new CalcView();

    CalcController() {
        view.zeroButton.addActionListener(this);
        view.oneButton.addActionListener(this);
        view.acClearButton.addActionListener(this);
        view.addButton.addActionListener(this);
        view.subtractButton.addActionListener(this);
        view.equalsButton.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.zeroButton) {
            onButtonZeroPress();
        } else if(e.getSource() == view.oneButton) {
            onButtonOnePress();
        } else if(e.getSource() == view.acClearButton) {
            updateLabel("");
            model.setFirstOperand("");
            model.setSecondOperand("");
            model.setOperator(null);
        } else if(e.getSource() == view.addButton) {
            onButtonAddPress();
        } else if(e.getSource() == view.subtractButton) {
            onButtonSubPress();
        } else if(e.getSource() == view.equalsButton) {
            onButtonEqualsPress();
        }
    }
    public void onButtonOnePress() {
        if(model.getOperator() != null) {
            model.setSecondOperand(model.getSecondOperand() + "1");
            updateLabel(model.getSecondOperand());
        } else {
            model.setFirstOperand(model.getFirstOperand() + "1");
            updateLabel(model.getFirstOperand());
        }
    }

    public void onButtonZeroPress() {
        if(model.getOperator() != null) {
            model.setSecondOperand(model.getSecondOperand() + "0");
            updateLabel(model.getSecondOperand());
        } else {
            model.setFirstOperand(model.getFirstOperand() + "0");
            updateLabel(model.getFirstOperand());
        }
    }

    public void onButtonAddPress() {
        if(model.getFirstOperand().equals("")) return;
        model.setOperator("+");
//        if(model.getSecondOperand().equals("")) {
//            updateLabel("");
//        } else {
//            String result = model.performOperation();
//            model.setDisplayValue(result);
//            updateLabel(result);
//            model.setFirstOperand(result);
//            model.setSecondOperand("");
//        }
        updateLabel("");
        //should clear the current display for entering the next number(?)
        //System.out.println("Btn: +, 1st: "+model.getFirstOperand()+", 2nd: "+model.getSecondOperand()+ ", Oper: "+model.getOperator());
    }

    public void onButtonSubPress() {
        if(model.getFirstOperand().equals("")) return;
        model.setOperator("-");
//        if(model.getSecondOperand().equals("")) {
//            updateLabel("");
//        } else {
//            String result = model.performOperation();
//            model.setDisplayValue(result);
//            updateLabel(result);
//            model.setFirstOperand(result);
//            model.setSecondOperand("");
//        }
        updateLabel("");
        //should clear the current display for entering the next number(?)
        System.out.println("Btn: -, 1st: "+model.getFirstOperand()+", 2nd: "+model.getSecondOperand() + ", Oper: "+model.getOperator());
    }

    public void onButtonEqualsPress() {
        if(model.getFirstOperand().equals("") && model.getSecondOperand().equals(""))  {
            return;
        }else if(model.getSecondOperand().equals("")) {
            model.setDisplayValue(model.getFirstOperand());
            updateLabel("= "+model.getFirstOperand());
            model.setFirstOperand("");
            model.setOperator(null);
            return;
        }
        String result = model.performOperation();
        model.setDisplayValue(result);
        updateLabel("= " +result);
        model.setFirstOperand("");
        model.setSecondOperand("");
        model.setOperator(null);
        System.out.println("Btn: =, 1st: "+model.getFirstOperand()+", 2nd: "+model.getSecondOperand()+ ", Oper: "+model.getOperator());
    }

    public void updateLabel(String text) {
        view.display.setText(text);
    }
}
