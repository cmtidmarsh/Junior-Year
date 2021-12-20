Flamingo Team 09:

Dean Allen           deanalle@iu.edu
Clare Tidmarsh       cmtidmar@iu.edu
Adam Wittenberg      adamwitt@iu.edu

Submission Date: 05.02.2021

Player Interaction with Resources:
The primary goal of player interaction with resources is to increment a player's score when a player enters a location that a resource
has spawn in. Then to decrement the resources in that particular location after a resource was picked up. Breaking it down, this portion
is essentially a scoreboard to keep track of how many resources an individual player gained. To satisfy this implementation, a score board
was made using the same format as the Game Timer in the View.java class, as to keep the design of the game uniform. In the Model.java, an integer
variable called SCORE was created and initialized to 0. There are absolutely no comments in the A02 code, working off of that, the GatherResources()
method has a print statement to "on resource". We interpreted that as a message to let the player know that he/she is in a tile that has a resource in
it. Once the system let's the player know that they are on a resource, the player's SCORE at the top righthand side of the board should increment by 1.
Using the player's position (p.get(positionX).get(positionY)), the tile's score should decrement by 1.

Player Interaction with Other Players:
For our player interaction with other players, our goal was to address the concern when handling player collisions. We loved how
flexible this portion was to the requirements as it gives a unique aspect to distinguish different teams and their implementations.
For our player interaction with other players, we created a method called bouncePlayer() in the Model.java class. bounceplayer() takes
into account how many players are in on the board (players.size()). It then takes in two player's x and y coordinate positions 
(currPlayerX-currPlayerY, nextPlayerX-nextPlayerY). If two players are in the same position, then a Math.random() will be preformed.
If the number generated from the random function is less than 0.5, then the player who is randomly set to currPlayer X and Y, will be
kicked off that tile to the tile directly diagonal of the previous position (X+1, Y-1). If the number generated from the random
function is greater than 0.5, then the player who is randomly set to nextPlayer X and Y, will be
kicked off that tile to the tile directly diagonal of the previous position (X+1, Y-1). In short, if a collision is seen on the board,
then one of the two players will be randomly kicked off from that tile where the collision happened and no resources from that tile
will be given to the player who got pushed off.


Starting Assignment of Resources: As of 20:55 May 2, 2021 - Not implemented

Game Timer:
The game timer was implemented in the View.java and Controller.java classes. In the Controller, a run() function was modified to start the duration of time
and end the game when the timer is up. The timer was implemented in 10 minute intervals meaning that each game should only last 10 minutes. After 10 minutes,
the game will break and message in the terminal will read out that game is over. The controller is where the functionality of the timer is implemented. The View
holds the visualization of the timer. The timer was implemented as a string on the lefthand side of the board. The timer states how much time remains throughout
the entire round in the format of 00:00 where everything to the left of the colon are how many minutes remain and everything to the right states how many seconds
remain. After every second, the timer will decrement by 1 second until 600 seconds, or 10 minutes, run out. 


Extra Notes:

04.28.2021 - No design changes have been made so far, looking at A02 implementation, it looks like they only implemented an Observer but two of the three design patterns
need to be implemented.

04.29.2021 - bouncePlayer() was added to Model.java as collision handling for Player Interaction with Other Players. I think we can
add since it doesn't stray away from the base documentation, also Player Interaction with Other Players is up for 
individual team interpretations.


UML CLASS DIAGRAM LINK:
https://lucid.app/lucidchart/invitations/accept/inv_03aa6d60-5234-409f-9669-c437da250e0f?viewport_loc=-27%2C-144%2C1903%2C1589%2C0_0
