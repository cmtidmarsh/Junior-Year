package Team13.BinaryCalc.Model;

public class AddOperation implements Operation{
    @Override
    public int performOperation(int firstOperand, int secondOperand) {
        return firstOperand + secondOperand;
    }
}
