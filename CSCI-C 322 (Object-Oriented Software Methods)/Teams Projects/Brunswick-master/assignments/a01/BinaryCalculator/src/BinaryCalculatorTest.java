import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BinaryCalculatorTest {
    public static void main(String[] args) {

        BinaryCalculatorView view = new BinaryCalculatorView();
        BinaryCalculatorModel model = new BinaryCalculatorModel();
        BinaryCalculatorController controller = new BinaryCalculatorController(view, model);
    }
}
