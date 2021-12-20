/*  CSCI-C 322 Spring 2021
 *  Program: TherunTimes.java
 *  Lab01
 *  Chris Taddeucci - ctaddeuc
 */
import java.rmi.*;

public class TheRunTimes {

    public static void main(String[] args) {
        try{
            Remote robj = Naming.lookup("//localhost/HelloServer");
            HelloClient helloClient = (HelloClient)robj;

            while (true){
                String message = helloServer.printMessage();
                System.out.println("Will a message appear?:");
                System.out.println(message);
            }

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    } //end main

}
