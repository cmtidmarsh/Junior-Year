import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BinaryCalculatorInt extends Remote {
    public void clear() throws RemoteException;
    public void setFirstOperand(int firstOperand) throws RemoteException;
    public void setOperation(String operation) throws RemoteException;
    public void setSecondOperand(int secondOperand) throws RemoteException;
    public void performOperation(int firstOperand, int secondOperand, String operation) throws RemoteException;

}
