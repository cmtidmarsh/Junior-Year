Team 9 (Flamingo)
C322 / Spring 2021
Lecture 23
4/12/21

Team:
Camisa Vines (cdvines)
Tanner Hay (tanhay)
Adam Martinez (asm9)

We noticed that the main method was in the model, but decided it would be better in the controller

The main change that we made was with the 2d array for the board. Rather than holding booleans, it will hold a new class called Cell.
Each cell is either a Player, a Resource, or Dead. They all also have x and y coordinates that coorespond with their position on the board.
If a Cell is a Resource, it will have a value 0-7 that represents how much resource it has. Similarly, if it is a Player then it will
have a value that holds the amount of resource the player has.

This was done to prevent looping through every player for every cell to check if there was a player there.



