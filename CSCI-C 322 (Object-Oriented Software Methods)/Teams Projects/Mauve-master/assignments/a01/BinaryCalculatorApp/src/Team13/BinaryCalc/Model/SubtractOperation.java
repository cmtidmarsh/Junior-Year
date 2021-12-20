package Team13.BinaryCalc.Model;

public class SubtractOperation implements Operation{
    @Override
    public int performOperation(int firstOperand, int secondOperand) {
        return firstOperand - secondOperand;
    }
}