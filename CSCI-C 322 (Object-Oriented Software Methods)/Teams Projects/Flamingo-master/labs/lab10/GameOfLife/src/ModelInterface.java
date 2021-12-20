//interface class

import java.rmi.RemoteException;

public interface ModelInterface extends java.rmi.Remote {
 Model[][] currentState = new Model[256][256];
 Model[][] nextState = new Model[256][256];
 //methods here
 void setState(int x, int y, int state)  throws RemoteException; //given x y and state sets state of that cel
 public int[][] checkRules(int[][] input) throws RemoteException;
 public int getState() throws RemoteException;

 //void update(int[][] start);
}
