package Conway;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.Timer;

public class GameOfLifeModel extends Observable {
    private int[][] board = new int[256][256];
    private Timer timer = new Timer(2000, null);

    public void update(Object o) {

    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public void simulateCycle() {
        if (timer.getActionListeners().length == 0) {
            GameOfLifeModel model = this;
            timer.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO: Logic here. Do not add any other functions as it has to follow our model EXACTLY. Just do all board calculations here.
                    int[][] stashedBoard = board;
                    int[][] updateBoard = board;

//                    Any live cell with fewer than two live neighbours dies, as if by underpopulation.
//                    Any live cell with two or three live neighbours lives on to the next generation.
//                    Any live cell with more than three live neighbours dies, as if by overpopulation.
//                    Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

                    // Non-corners
                    for (int i = 1; i < 255; i += 1) {
                        for (int j = 1; j < 255; j += 1) {
                            boolean isAlive = (stashedBoard[i][j] == 1 ? true : false);
                            int numberOfNeighbors = stashedBoard[i - 1][j - 1] + stashedBoard[i - 1][j] + stashedBoard[i - 1][j + 1]
                                    + stashedBoard[i][j - 1] + stashedBoard[i][j + 1]
                                    + stashedBoard[i + 1][j - 1] + stashedBoard[i + 1][j] + stashedBoard[i + 1][j + 1];

                            if (isAlive) {
                                if (numberOfNeighbors == 2 || numberOfNeighbors == 3) {
                                    updateBoard[i][j] = 1;
                                } else {
                                    updateBoard[i][j] = 0;
                                }
                            } else {
                                if (numberOfNeighbors == 3) {
                                    updateBoard[i][j] = 1;
                                }
                            }
                        }
                    }

                    // Corners
                    // Upper-Left Corner
                    int upperLeftNeighbors = stashedBoard[0][1] + stashedBoard[1][1] + stashedBoard[1][0];
                    int upperRightNeighbors = stashedBoard[0][254] + stashedBoard[1][254] + stashedBoard[1][255];
                    int bottomLeftNeighbors = stashedBoard[254][0] + stashedBoard[254][1] + stashedBoard[255][1];
                    int bottomRightNeighbors = stashedBoard[254][255] + stashedBoard[254][254] + stashedBoard[255][254];

                    if (stashedBoard[0][0] == 1) {
                        if (upperLeftNeighbors == 2 || upperLeftNeighbors == 3) {
                            updateBoard[0][0] = 1;
                        } else {
                            updateBoard[0][0] = 0;
                        }
                    } else {
                        if (upperLeftNeighbors == 3) {
                            updateBoard[0][0] = 1;
                        }
                    }

                    if (stashedBoard[0][255] == 1) {
                        if (upperRightNeighbors == 2 || upperRightNeighbors == 3) {
                            updateBoard[0][255] = 1;
                        } else {
                            updateBoard[0][255] = 0;
                        }
                    } else {
                        if (upperRightNeighbors == 3) {
                            updateBoard[0][255] = 1;
                        }
                    }

                    if (stashedBoard[255][0] == 1) {
                        if (bottomLeftNeighbors == 2 || bottomLeftNeighbors == 3) {
                            updateBoard[0][255] = 1;
                        } else {
                            updateBoard[0][255] = 0;
                        }
                    } else {
                        if (bottomLeftNeighbors == 3) {
                            updateBoard[0][255] = 1;
                        }
                    }

                    if (stashedBoard[255][255] == 1) {
                        if (bottomRightNeighbors == 2 || bottomRightNeighbors == 3) {
                            updateBoard[255][255] = 1;
                        } else {
                            updateBoard[255][255] = 0;
                        }
                    } else {
                        if (bottomRightNeighbors == 3) {
                            updateBoard[255][255] = 1;
                        }
                    }

                    setBoard(updateBoard);
                    setChanged();
                    notifyObservers();
                }

            });

            timer.setRepeats(true);
            timer.start();
        }
    }
    public int[][] getBoard() { return board; }
}
