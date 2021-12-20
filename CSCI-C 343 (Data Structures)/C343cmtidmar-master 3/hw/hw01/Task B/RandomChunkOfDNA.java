// C343 / Summer 2020
// Homework01 - Task B
// June 30, 2020 14:33
// Clare Tidmarsh, cmtidmar

// given starter code:
import java.util.Random;
import static java.lang.System.out;

public class RandomChunkOfDNA {
    // generate a random DNA sequence of length n:
    public String nextDNA(int n){
        String lDNA = "";
        Random lRandomizer = new Random();

        for (int i = 0; i < n; i++){
            int j = lRandomizer.nextInt(4);
            if (j == 0) lDNA += "A";
            else if (j == 1) lDNA += "T";
            else if (j == 2) lDNA += "C";
            else if (j == 3) lDNA += "G";
        }
        return lDNA;

    }
    // some client code for testing:
    public static void main(String[] args) {
        RandomChunkOfDNA rndDNAGenerator = new RandomChunkOfDNA();
        String dna;
        for (int i = 10; i <= 1000; i = i * 10){
            out.println("");
            dna = rndDNAGenerator.nextDNA(i);
            out.println("a DNA sequence " + i + " characters long: " + dna);

        }
    }
} // end of class RandomChunkOfDNA
