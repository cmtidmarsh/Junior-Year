

public interface BinaryCalculatorModelInt extends java.rmi.Remote{

    public void changeStartingValue();
    public void setOperator(String c);
    public void setFirstOperand(int value);
    public void setSecondOperand(int value);

}

