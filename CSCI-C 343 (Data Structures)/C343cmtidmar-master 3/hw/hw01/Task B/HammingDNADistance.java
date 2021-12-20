// C343 / Summer 2020
// Homework01 - Task B
// June 30, 2020 14:33
// Clare Tidmarsh, cmtidmar


import static java.lang.System.out;

public class HammingDNADistance extends RandomChunkOfDNA {
    public static String[] RandomChunksOfDNA() {
        RandomChunkOfDNA rndDNAGenerator = new RandomChunkOfDNA();
        // initializing two strands of DNA
        String dna1 = new String();
        String dna2 = new String();
        for (int i = 100; i <= 100; i = i * 100) {          // computes strand 1
            for (int j = 100; j <= 100; j = j * 100) {      // computes strand 2
                out.println("");
                dna1 = rndDNAGenerator.nextDNA(i); // generating strand 1
                dna2 = rndDNAGenerator.nextDNA(i); // generating strand 2
                out.println("a DNA sequence " + i + " characters long: " + dna1);
                out.println("a DNA sequence " + i + " characters long: " + dna2);

            }

        }

        String[] dnas = {dna1, dna2}; // return strands of DNA 1 and 2 in an array since you can only have 1 return type in Java
        return dnas;

    }


    public static int hammingDistanceBetweenStringsCalculation(String[] dnas) {
        //splitting the two elements/DNA strands from the array to use as independent values for variables
        String dna1 = dnas[0];
        String dna2 = dnas[1];
        int counter = 0;        // counting each time a letter from the first DNA strand != a letter in the same
                                // position as the second DNA strand

        for (int i = 0; i < 100; i++) {
            if (dna1.charAt(i) != dna2.charAt(i)) // when a letter from strand 1 is not the same as the letter at the same position in strand 2
                counter++; // increments by 1
        }
        return counter; // returns distance
    }



    public static void main(String[] args) {
        // tester 1:
        String[] dnas1 = RandomChunksOfDNA();
        System.out.println("The Hamming Distance between two strings of DNA is "+ hammingDistanceBetweenStringsCalculation(dnas1));
        System.out.println();
        // tester 2:
        String[] dnas2 = RandomChunksOfDNA();
        System.out.println("The Hamming Distance between two strings of DNA is "+ hammingDistanceBetweenStringsCalculation(dnas2));
        System.out.println();
        // tester 3:
        String[] dnas3 = RandomChunksOfDNA();
        System.out.println("The Hamming Distance between two strings of DNA is "+ hammingDistanceBetweenStringsCalculation(dnas3));

    }
}
