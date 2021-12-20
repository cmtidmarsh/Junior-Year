import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class ParserTest {
    public static void main(String[] args) {
        String t1 = "00001";
        String t2 = "00011001";
        String t3 = "11111";
        BufferedReader in1 = new BufferedReader(new StringReader(t1));
        BufferedReader in2 = new BufferedReader(new StringReader(t2));
        BufferedReader in3 = new BufferedReader(new StringReader(t3));
        boolean check = true;
        try {
            if (!Parser.accept(in1)) {
                System.out.println(t1 + " was not accepted but is a valid string . ");
                check = false;
            }
            if (Parser.accept(in2)) {
                System.out.println(t2 + " was accepted but is not a valid string . ");
                check = false;
            }
            if (Parser.accept(in3)) {
                System.out.println(t3 + " was accepted but is not a valid string . ");
                check = false;
            }
        } catch (IOException ex) {
            System.err.println(" Error reading input ");
        }
        if (check) {
            System.out.println(" All tests passed ! ");
        }
    }
}
