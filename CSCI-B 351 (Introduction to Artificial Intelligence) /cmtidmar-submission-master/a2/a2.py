#!/usr/bin/python3
# B351/Q351 Spring 2019
# Professor Saúl Blanco
# Do not share these assignments or their solutions outside of this class.
<<<<<<< HEAD
=======
#testing github commits
>>>>>>> 56ed2f2f961fe788a7cb9ec06fff432c195b9c11

import csv
import itertools

class Board():

    ##########################################
    ####   Constructor
    ##########################################
    def __init__(self, filename):

        # initialize all of the variables
        self.n2 = 0
        self.n = 0
        self.spaces = 0
        self.board = None
        self.valsInRows = None
        self.valsInCols = None
        self.valsInBoxes = None
        self.unsolvedSpaces = None

        # load the file and initialize the in-memory board with the data
        self.loadSudoku(filename)


    # loads the sudoku board from the given file
    def loadSudoku(self, filename):

        with open(filename) as csvFile:
            self.n = -1
            reader = csv.reader(csvFile)
            for row in reader:

                # Assign the n value and construct the approriately sized dependent data
                if self.n == -1:
                    self.n = int(len(row) ** (1/2))
                    if not self.n ** 2 == len(row):
                        raise Exception('Each row must have n^2 values! (See row 0)')
                    else:
                        self.n2 = len(row)
                        self.spaces = self.n ** 4
                        self.board = {}
                        self.valsInRows = [set() for _ in range(self.n2)]
                        self.valsInCols = [set() for _ in range(self.n2)]
                        self.valsInBoxes = [set() for _ in range(self.n2)]
                        self.unsolvedSpaces = set(itertools.product(range(self.n2), range(self.n2)))

                # check if each row has the correct number of values
                else:
                    if len(row) != self.n2:
                        raise Exception('Each row must have the same number of values. (See row ' + str(reader.line_num - 1) + ')')

                # add each value to the correct place in the board; record that the row, col, and box contains value
                for index, item in enumerate(row):
                    if not item == '':
                        self.board[(reader.line_num-1, index)] = int(item)
                        self.valsInRows[reader.line_num-1].add(int(item))
                        self.valsInCols[index].add(int(item))
                        self.valsInBoxes[self.spaceToBox(reader.line_num-1, index)].add(int(item))
                        self.unsolvedSpaces.remove((reader.line_num-1, index))


    ##########################################
    ####   Utility Functions
    ##########################################

    # converts a given row and column to its inner box number
    def spaceToBox(self, row, col):
        return self.n * (row // self.n) + col // self.n

    # prints out a command line representation of the board
    def print(self):
        for r in range(self.n2):
            # add row divider
            if r % self.n == 0 and not r == 0:
                if self.n2 > 9:
                    print("  " + "----" * self.n2)
                else:
                    print("  " + "---" * self.n2)

            row = ""

            for c in range(self.n2):

                if (r,c) in self.board:
                    val = self.board[(r,c)]
                else:
                    val = None

                # add column divider
                if c % self.n == 0 and not c == 0:
                    row += " | "
                else:
                    row += "  "

                # add value placeholder
                if self.n2 > 9:
                    if val is None: row += "__"
                    else: row += "%2i" % val
                else:
                    if val is None: row += "_"
                    else: row += str(val)
            print(row)


    ##########################################
    ####   Move Functions - YOUR IMPLEMENTATIONS GO HERE
    ##########################################

    # makes a move, records it in its row, col, and box, and removes the space from unsolvedSpaces
    def makeMove(self, space, value):
        self.board[space] = value
<<<<<<< HEAD
        self.valsInCols[space[1].add(value)]
        self.valsInRows[space[0].add(value)]
        self.valsInBoxes[self.spaceToBox(space[0], space[1])].add(value)
        self.unsolved.remove(space)





=======
        self.valsInRows[space[0]].add(value)
        self.valsInCols[space[1]].add(value)
        self.valsInBoxes[self.spaceToBox(space[0], space[1])].add(value)
        self.unsolvedSpaces.remove(space)
>>>>>>> 56ed2f2f961fe788a7cb9ec06fff432c195b9c11
        

    # removes the move, its record in its row, col, and box, and adds the space back to unsolvedSpaces
    def undoMove(self, space, value):
        if space in self.board:
            del self.board[space]
<<<<<<< HEAD
            self.valsInCols[space[1].remove(value)]
            self.valsInRows[space[0].remove(value)]
            self.valsInBoxes[self.spaceToBox(space[0], space[1])].remove(value)
            self.unsolved.add(space)
=======
            self.valsInRows[space[0]].remove(value)
            self.valsInCols[space[1]].remove(value)
            self.valsInBoxes[self.spaceToBox(space[0], space[1])].remove(value)
            self.unsolvedSpaces.add(space)
>>>>>>> 56ed2f2f961fe788a7cb9ec06fff432c195b9c11

    # returns True if the space is empty and on the board,
    # and assigning value to it if not blocked by any constraints
    def isValidMove(self, space, value):
<<<<<<< HEAD
        if space in self.unsolved:
=======
        if space in self.unsolvedSpaces:
>>>>>>> 56ed2f2f961fe788a7cb9ec06fff432c195b9c11
            if value in self.valsInCols[space[1]]:
                return False
            if value in self.valsInRows[space[0]]:
                return False
<<<<<<< HEAD
            if value in self.valsInBoxes[self.spaceToBox[space[0], space[1]]:
=======
            if value in self.valsInBoxes[self.spaceToBox(space[0], space[1])]:
>>>>>>> 56ed2f2f961fe788a7cb9ec06fff432c195b9c11
                return False
            return True
        else:
            return False
            
            
    # optional helper function for use by getMostConstrainedUnsolvedSpace
    def evaluateSpace(self, space):
<<<<<<< HEAD
        raise NotImplementedError

    # gets the unsolved space with the most current constraints
    # returns None if unsolvedSpaces is empty
    def getMostConstrainedUnsolvedSpace(self):
        if not self.unsolved:
            return None
        constraints = -1
        position = -1
        for space in self.unsolved:
            if space > constraints:
=======
        evaluate = self.valsInBoxes[self.spaceToBox(space[0], space[1])] | self.valsInRows[space[0]] | self.valsInCols[space[1]]
        return len(evaluate)
    # gets the unsolved space with the most current constraints
    # returns None if unsolvedSpaces is empty
    def getMostConstrainedUnsolvedSpace(self):
        if not self.unsolvedSpaces:
            return None
        constraints = -1
        position = -1
        for space in self.unsolvedSpaces:
            if self.evaluateSpace(space) > constraints:
                constraints = self.evaluateSpace(space)
>>>>>>> 56ed2f2f961fe788a7cb9ec06fff432c195b9c11
                position = space
        return position

class Solver:
    ##########################################
    ####   Constructor
    ##########################################
    def __init__(self):
        pass

    ##########################################
    ####   Solver
    ##########################################

    # recursively selects the most constrained unsolved space and attempts
    # to assign a value to it

    # upon completion, it will leave the board in the solved state (or original
    # state if a solution does not exist)

    # returns True if a solution exists and False if one does not
    def solveBoard(self, board):
<<<<<<< HEAD
        if unsolvedSpaces == 0:
            return True
        unsolved = board.getMostConstrainedUnsolvedSpace()
        for value in range(1, board.n2+1):
            if board.isValidMove(unsolved, value):
                board.makeMove(unsolved, value)
                solution = self.solve(board)
                if solution:
                    return True
            else:
                board.undoMove(unsolved, value)
=======
        unsolvedSp = board.getMostConstrainedUnsolvedSpace()
        if unsolvedSp is None:
            return True
        for value in range(1, board.n2 + 1):
            if board.isValidMove(unsolvedSp, value):
                board.makeMove(unsolvedSp, value)
                can_solve = self.solveBoard(board)
                if can_solve:
                    return True
                else:
                    board.undoMove(unsolvedSp, value)
>>>>>>> 56ed2f2f961fe788a7cb9ec06fff432c195b9c11
        return False
            


if __name__ == "__main__":
    # change this to the input file that you'd like to test
    board = Board('tests/example.csv')
    s = Solver()
    s.solveBoard(board)
    board.print()
