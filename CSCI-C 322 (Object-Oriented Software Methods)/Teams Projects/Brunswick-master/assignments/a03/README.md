Assignment 03 Documentation
C322 Spring '21
Mitja

Ploy Unchit punchit@iu.edu
Gary Baker garybake@iu.edu
Michael Bouvette mjbouvet@iu.edu

Things to note - our implementation has a sliding display for the board. there are four sections and only one is shown at
a time. if you go to the right at the start, you will move to the other section. 
We updated the UML that was turned in for Assignment02 for our UML. We got the OK from Prof. Mitja that we can do this.

Player interaction with resources:
-the player will gather the resources from the tile they're on if the tile has resources every time the player connects
to the server and updates the board
-we did this so the player doesn't have to worry about pressing a button to collect the resources because it is done
automatically

Player interaction with other players:
-Players collide with other players if they try to move to a square another player is on (players do not stack)
-However all players spawn on the same square, if they haven't move, they will stack
-To let players see the other players if they stack at the spawn, the current player is a small circle, while the other
players are larger squares with the current player overlayed on top of the other players
-The current player is overlayed on top of the other player so you could see both stacked on top of each other.
-We have the players collide so only one player could collect the resources as a time
-We also changed the color of the player from red to yellow so that we could see it better.

Starting assignment of resources:
-We made it so there's 3 unique starting game boards: 50/50, 65/35, 80/20
-When the model started, the administrator could choose which game board to start with
-After 6 minutes, the game ends and a message is printed to the administrator that the game has ended and that if they
wanna play again, they have to restart it

Game timer:
-We changed the growth parameter to .15 and the tick rate of the server to 300 milliseconds
-We don't display the timer so that it doesn't influence the players, but the timer is shown on the command line of the
administrator
-We did this so we could slow the game down

Growth Changes:
-We completely changed how the resources grew because they did it incorrectly
-The growth parameter didn't matter and the resources grew uniformly in their implementation
-We changed it to the correct growth formula

Observer:
-We used an observer to get the other player's position
-We needed to see where the other players are

Decorator:
-We used a decorator for the colors of the players
-We needed to differentiate between different players and give color options
