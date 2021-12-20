// C343 / Summer 2020
//Lab - -12
// July 17, 9:00
// Clare Tidmarsh, cmtidmar


import java.util.Arrays;
import java.util.Random;

public class HW05CountingSort {

    // Finding the max value in an array
    public static int findMax(int[] array) {
        int max = array[0]; // start with the max value to be at the first position
        for (int i = 0; i < array.length; i++) { // iterate through the array
            if (array[i] > max) { // comparing each element to the max and replacing if element > current max
                max = array[i]; // store the new max
            }
        }
        return max; // return max value
    }

    // counting sort takes in an array A, return type array
    public static int[] countingSort(int[] A) {
        int k = findMax(A); // k is the largest value of all keys in A

        int[] B = new int[A.length]; // initialize new array B to the length of A
        Arrays.fill(B, 0); // Set all elements in B to 0 (for-loop had some errors when running os using Arrays.fill)
//        for (int i = 0; i <= B.length; i++){ // iterates through all elements in B
//            B[i] = 0; // sets each element in B to 0
//        }
        int[] C = new int[A.length]; // initialize new array C to the length of A, C will be the output array

        // first stage: make count array for each element
        for (int i = 0; i < A.length; i++) { // for each key that was found in A,
            B[i] = A[findMax(A)]; // saving the total counts to the array B
            B[A[i]] += 1;
        } // saving the total counts to the array B

        // second stage: for each key that was found in A
        for (int i = 0; i < A[k]; i++) { // for each element in A
            B[i] += C[i + 1]; // calculate its starting index in the output array C, store store the calculated starting index in B
        }

        // Third Stage
        for (int i = 0; i < B.length; i++) { // for each element in length of B
            for (int j = 0; j < B[i]; j++) { // lookup each element in table array B
                C[j++] = i; // Add sorted to C
            }
        }
        return C;


    }


    public static void main(String[] args) {
        // Testing Find Max (works)
        int[] array = {1, 2, 3, 4};
        System.out.println(findMax(array));
        //countingSort(array);

        int[] A = new int[5]; // length of an array
        Random random = new Random(); // using random
        for (int i = 0; i < A.length; i++){ //for all elements in A
            A[i] = random.nextInt(1000); //place a random int
            System.out.println(A[i]); //print the unsorted
        }
        countingSort(A); //sort

    }
}

