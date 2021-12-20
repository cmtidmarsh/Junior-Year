package Conway;

import java.rmi.Naming;
import java.rmi.Remote;

public class GameOfLifeDemo {
    public static void main(String[] args) {
        try {
            Remote robj = Naming.lookup("//localhost/GameOfLifeServer");
            GameOfLifeInterface modelInterface = (GameOfLifeInterface)robj;
            new GameOfLifeController(modelInterface);
        } catch (Exception var5) {
            System.out.println(var5.getMessage());
        }
    }
}
