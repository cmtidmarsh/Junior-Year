//  C343 / Summer 2020
// Homework - 03
// July 13, 22:50
// Clare Tidmarsh, cmtidmar

import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.Arrays;

    public class HW03Model extends Observable {
        public int width; // rows
        public int height; // columns
        public int[][] array;

        //constructor
        public HW03Model(int width, int height) {
            array = new int[width][height];
            this.width = width;
            this.height = height;
        }

        public int[][] getArray() {
            //this method should return a reference to the 2D array stored in the HW03Model class
            System.out.println(Arrays.toString(array[0])); //testing to get the first row
            System.out.println(Arrays.toString(array[1])); // testing get the second row
            return array;
        }

        public int[][] randomize() {
            Random random = new Random();
            int min = -255;
            int max = 255;
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    array[i][j] = random.nextInt(max - min) + min;
                    System.out.println(array[i][j]); // testing for errors (WORKS!)
                }
            }
            return array;
        }

        void sortColumns() {
            // bubble sort
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < height - 1; j++) {
                    if (array[i][j] > array[i][j + 1]) {
                        int newAssignment = array[i][j];
                       array[i][j] = array[i][j + 1];
                        array[i][j + 1]= newAssignment;
                    }
                }
            }
//        System.out.println(Arrays.toString(array[0]));
//        System.out.println(Arrays.toString(array[1]));
            notifyObservers();
            //return array;

        }

        void sortRows() {
            // bubble sort
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < width - 1; j++) {
                    if (array[j][i] > array[j + 1][i]) {
                        int newAssignment = array[j][i];
                        array[j][i] = array[j + 1][i];
                         array[j + 1][i] = newAssignment;
                    }
                }
            }
//        System.out.println(Arrays.toString(array[0]));
//        System.out.println(Arrays.toString(array[1]));
            notifyObservers();
            // return array;
        }

        public void sortArray1() {
            // This method should first sort each column, then sort each row in the array
            long lTimeBefore = System.nanoTime();
            sortColumns();
            sortRows();
            System.out.println(Arrays.toString(array[0]));
            System.out.println(Arrays.toString(array[1]));
            long lTimeAfter = System.nanoTime();
            long lElapsedNanoSeconds = (lTimeAfter - lTimeBefore);
            System.out.println(lElapsedNanoSeconds);
        }

        public void sortArray2() {
            // This method should first sort each row, then sort each column in the array.
            // your method's declaration {
            long lTimeBefore = System.nanoTime();
            sortRows();
            sortColumns();
            System.out.println(Arrays.toString(array[0]));
            System.out.println(Arrays.toString(array[1]));
            long lTimeAfter = System.nanoTime();
            long lElapsedNanoSeconds = (lTimeAfter - lTimeBefore);
            System.out.println(lElapsedNanoSeconds);
        }
    }
