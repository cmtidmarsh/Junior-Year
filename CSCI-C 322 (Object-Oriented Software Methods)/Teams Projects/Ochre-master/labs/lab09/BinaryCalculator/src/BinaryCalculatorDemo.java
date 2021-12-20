import java.rmi.*;

public class BinaryCalculatorDemo {
    public static void main(String[] args) {
        try {
            Remote robj = Naming.lookup("//localhost/CalculatorModelServer");
            CalculatorModelInterface modelInterface = (CalculatorModelInterface)robj;

            BinaryCalculatorView view = new BinaryCalculatorView();
            BinaryCalculatorController controller = new BinaryCalculatorController(view, modelInterface);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
