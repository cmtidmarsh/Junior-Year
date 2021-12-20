Team 14: Ochre
Clare Tidmarsh, cmtidmar@iu.edu
*Daniel Akinniranye: dakinnir@iu.edu
Zachary Wendholt: zwendhol@iu.edu


Submission Date: 04.15.2021


Lab 13: Description of Forager Game


getPlayerPositions(int except):
1. Signature
   1. Input Data: integer
   2. Returns: HashMap of integer pairs
   3. Ranges of Values could be the integer pairs on arrayList
   4. Example of a position a player could possibly be at: Player1 at (1, 1) on the board while Player2 at  (3, 2) on the board.
2. Functionality
   1. The idea behind getPlayerPositions is to know/track where each player is on the board. By doing so, you can track where the resource is in correlation to a player. The return is a pair of integers as it corresponds to where the player is on the map.
3. Example Use
   1. The method would be invoked by the client as the player moves positions it sends that movement to sendPlayerPosition then sendPlayerPosition to the model then records/tracks where each player is on the map where it is then sent to ForagerServer.


sendPlayerPosition(int playerID, int positionX, int positionY):
1. Signature
   1. Input Data: integer (the integer would relate to each player’s “ID” number in the game) value of player ID, integer value of the row where player is located, integer value of the column where player is located
   2. Returns: void
   3. Range of Values could be 1 to n, depending on how many players in the server.
   4. Example: Player1 could have the ID Number of 1, Player2 has the ID number of 2, … , PlayerN could have the ID number of N.
2. Functionality
   1. Number Identification would be useful in determining how many players are currently in the server and who has what resources. It essentially keeps a record of the users and the number of resources they have to then help determine things like the person with the most resources, person with least resources, etc.
3. Example Use
   1. This method would be used alongside getPlayerPosition() as the controller would get the position of each player, then the sendPlayerPosition would send that position to the model and server to be updated.


gatherResource(int forPlayer):
1. Signature
   1. Input: int that relates to the player ID
   2. Returns: void
   3. Example values: (23) relating to the id of player 23 
   4. Possible ranges: 0 - max number of players
2. Functionality: return the number of resources at a location that a user is standing on. 
3. Example Use: find out how many resources player 2 can find at the tile they are located at. 


updateResources():
1. Signature
   1. Input: no input
   2. Returns: void
2. Functionality: update the board after a user does an action (gathering a resource). The board is then updated to reflect these changes based on a timer. 
3. Example Use: continuously updating the board based on user interaction with the board. 


getResources():
1. Signature
   1. Input : no input
   2. Returns: 2d array of type int
   3. Example values: array relating to the board containing values for those spaces
   4. Possible ranges: an array that relates to the size of the square, with values from 0 - max amount of resource allowed. 
2. Functionality: the functionality is to get the state of the resources for the board. 
3. Example Use: the get resources could be used to check whether a player can harvest resources at a location of the board.
