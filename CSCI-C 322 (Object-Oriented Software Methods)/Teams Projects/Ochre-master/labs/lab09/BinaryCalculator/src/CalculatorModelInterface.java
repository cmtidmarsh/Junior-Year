import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculatorModelInterface extends Remote {
    void setFirstOperand(int toInt) throws RemoteException;
    void setSecondOperand(int toInt) throws RemoteException;
    int getFirstOperand() throws RemoteException;
    int getSecondOperand() throws RemoteException;
    void setOperation(char toOperation) throws RemoteException;
    int biToDecimal(int bi) throws RemoteException;
    int decToBi(int dec) throws RemoteException;
    void setResult(int toResult) throws RemoteException;
    int getResult() throws RemoteException;
}
