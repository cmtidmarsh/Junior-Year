import java.rmi.Naming;
import java.rmi.Remote;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) {
        try {
            Remote robj = Naming.lookup("//localhost/Model");
            ControllerFactory factory = new ControllerFactory();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Admin, true or false: ");
            String username = scanner.next();
            ModelIntf ModelServer = (ModelIntf) robj;
            View view = new View();
            GeneralController game = factory.createController(Boolean.parseBoolean(username), ModelServer, view);
            while (true) {
                game.updateView();
                game.gatherResources();
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
