//C322 Lecture 14 Task - Lab08
//Team03
//3-15-21
//Ben Billings (benbilli@iu.edu), Jiahui Chang (chanji@iu.edu), Chris Taddeucci (ctaddeuc@iu.edu)

import java.util.Observable;

public class GameOfLifeModel extends Observable {

    private final int[][] old2DArray; // int[row][column]
    private final int[][] new2DArray; // int[row][column]

    public GameOfLifeModel() {
        // Initialize old2DArray and new2DArray
        // 1 = live cell; 0 = dead cell;
        old2DArray = new int[256][256];
        new2DArray = new int[256][256];
        for (int row = 0; row < 256; row++) {
            for (int column = 0; column < 256; column++) {
                if (Math.random() < 0.6) {
                    old2DArray[row][column] = 1;
                    new2DArray[row][column] = 1;
                }
            }
        }
    }

    public void update2DArray() {

        // Support understanding :

        // Positions relative to A
        // 1  8  7    (0,0)(1,0)(2,0)
        // 2  A  6    (0,1)(1,1)(2,1)
        // 3  4  5    (0,2)(1,2)(2,2)

        // (row - 1)(column - 1) Position 1
        // (row - 1)(column)     Position 2
        // (row - 1)(column + 1) Position 3
        // (row)(column + 1)     Position 4
        // (row + 1)(column + 1) Position 5
        // (row + 1)(column)     Position 6
        // (row + 1)(column - 1) Position 7
        // (row)(column - 1)     Position 8

        // Update to new2DArray
        for (int row = 0; row < 256; row++) {

            for (int column = 0; column < 256; column++) {

                String pointStr = row + "" + column;

                int countNeighbor;

                // Check neighbors
                switch (pointStr) {
                    case "00": // top-left
                        // get position 4,5,6 's alive cell
                        countNeighbor = old2DArray[row][column + 1] + old2DArray[row + 1][column + 1]
                                + old2DArray[row + 1][column];
                        break;
                    case "2550": // top-right
                        // get position 2,3,4 's alive cell
                        countNeighbor = old2DArray[row - 1][column] + old2DArray[row - 1][column + 1]
                                + old2DArray[row][column + 1];
                        break;
                    case "0255": // bottom-left
                        // get position 6,7,8 's alive cell
                        countNeighbor = old2DArray[row + 1][column] + old2DArray[row + 1][column - 1]
                                + old2DArray[row][column - 1];
                        break;
                    case "255255": // bottom-right
                        // get position 1,2,8 's alive cell
                        countNeighbor = old2DArray[row - 1][column - 1] + old2DArray[row - 1][column]
                                + old2DArray[row][column - 1];
                        break;

                    default:// rest of it

                        if (column == 0) { // top side without corner

                            // get position 2,3,4,5,6 's alive cell
                            countNeighbor = old2DArray[row - 1][column] + old2DArray[row - 1][column + 1]
                                    + old2DArray[row][column + 1] + old2DArray[row + 1][column + 1] + old2DArray[row + 1][column];

                        } else if (column == 255) { // bottom side without corner

                            // get position 1,2,6,7,8 's alive cell
                            countNeighbor = old2DArray[row - 1][column - 1] + old2DArray[row - 1][column]
                                    + old2DArray[row + 1][column] + old2DArray[row + 1][column - 1] + old2DArray[row][column - 1];

                        } else if (row == 0) { // left side without corner

                            // get position 4,5,6,7,8 's alive cell
                            countNeighbor = old2DArray[row][column + 1] + old2DArray[row + 1][column + 1]
                                    + old2DArray[row + 1][column] + old2DArray[row + 1][column - 1] + old2DArray[row][column - 1];

                        } else if (row == 255) { // right side without corner

                            // get position 1,2,3,4,8 's alive cell
                            countNeighbor = old2DArray[row - 1][column - 1] + old2DArray[row - 1][column]
                                    + old2DArray[row - 1][column + 1] + old2DArray[row][column + 1] + old2DArray[row][column - 1];

                        } else { // inside

                            // get position 1,2,3,4,5,6,7,8 's alive cell
                            countNeighbor = old2DArray[row - 1][column - 1] + old2DArray[row - 1][column]
                                    + old2DArray[row - 1][column + 1] + old2DArray[row][column + 1]
                                    + old2DArray[row + 1][column + 1] + old2DArray[row + 1][column]
                                    + old2DArray[row + 1][column - 1] + old2DArray[row][column - 1];
                        }
                        break;
                }

                // Rules
                if (old2DArray[row][column] == 1) { // live cell
                    if (countNeighbor < 2) { // Any live cell with fewer than two live neighbours dies, as if by underpopulation.
                        new2DArray[row][column] = 0;
                    }
                    if (countNeighbor == 2 || countNeighbor == 3) { // Any live cell with two or three live neighbours lives on to the next generation.
                        new2DArray[row][column] = 1;
                    }
                    if (countNeighbor > 3) { // Any live cell with more than three live neighbours dies, as if by overpopulation.
                        new2DArray[row][column] = 0;
                    }

                } else { // dead cell
                    if (countNeighbor == 3) { // Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
                        new2DArray[row][column] = 1;
                    }
                }
            }
        }
        // End of update new2DArray ^^^

        for (int row = 0; row < 256; row++) {
            System.arraycopy(new2DArray[row], 0, old2DArray[row], 0, 256);
        }

        setChanged();
        notifyObservers();
    }

    public int[][] getNew2DArray() {
        return new2DArray;
    }
}