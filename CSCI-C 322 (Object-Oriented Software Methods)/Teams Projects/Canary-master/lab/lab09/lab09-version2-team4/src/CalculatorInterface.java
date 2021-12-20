import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface CalculatorInterface extends Remote {
    public int binaryToDecimal(String n1) throws RemoteException;
    public int decimalToBinary(ArrayList<Integer> arr, int n) throws RemoteException;
    public String performOperation(String n1, String n2, String o) throws RemoteException;
}
