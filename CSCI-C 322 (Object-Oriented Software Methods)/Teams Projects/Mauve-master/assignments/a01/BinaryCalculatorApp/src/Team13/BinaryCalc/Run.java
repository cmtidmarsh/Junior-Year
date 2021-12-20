package Team13.BinaryCalc;

import Team13.BinaryCalc.Controller.Controller;
import Team13.BinaryCalc.Model.Model;
import Team13.BinaryCalc.View.CalculatorFrame;

public class Run {
    public static void main(String[] args){
        Model model = new Model();
        CalculatorFrame view = new CalculatorFrame();
        Controller controller = new Controller(model, view);
    }
}
