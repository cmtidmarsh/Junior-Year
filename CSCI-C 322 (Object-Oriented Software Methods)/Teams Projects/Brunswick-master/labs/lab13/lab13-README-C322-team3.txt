C322 / Spring-2021
Lab13
Team 3

Tyler Burdon      tcburdon@iu.edu
Jiaqi Huang       jh106@iu.edu
Dylan Herthoge    dherthog@iu.edu




Dylan:
HashMap<Integer, Pair<Integer, Integer>> getPlayerPositions(int except) throws RemoteException;

Functionality: Allows the client to know where every other player is at on the game board
Input: playerID(int)
playerID: The ID integer of the player to remove from the returned HashMap
          Example values: 0, 1, 2, 3, 4, …
          Minimum: 0
          Maximum: the number of players connected to the model - 1   
Output: A hashmap between playerIDs and int Pairs representing the corresponding player location
Example: When player 0 wants to know where each player is currently located, they will call getPlayerPositions(0). The server will return a HashMap containing every players ID and their current location.




Jiaqi:
void sendPlayerPosition(int playerID, int positionX, int positionY) throws RemoteException;

Input: playerID(int): example value: 01,02,03…
definition: The player to send the position from.
positionX(int): example value: 1,11,111… 
definition: Y coordinate of the player
positionY(int): example value: 1,11,111…
definition: X coordinate of the player
Output: return nothing 
Functionality: Sends the player's new position to the server
Example use: When the player picks up a resource, this method will be called automatically by the client. Therefore, the server will know who pick up the resource.




Tyler:
int gatherResource(int forPlayer) throws RemoteException;

Input: forPlayer(int)
        Corresponds to the playerID for which player is gathering that resource
        Example Values: 001, 002, 003, 045
        Min/Max Values: Dependent on how many players are playing at given time
Output: int
        Corresponds to the resource gathered
        Example Values: 1, (2)?, (3)?, (0.5)?
        Min/Max: Dependent on how many resources gathered/logic behind Team05’s implementation (if a player is able to grab more than one per tick, if the resources are split up if multiple players are on the board, etc) but will be between 0-7 given nature of the game
Functionality: When a player goes to gather a resource from a given tile it will ultimately take away the resource from the tile, lookup the player by ID that is invoking the method (gathering the resource) and assign the resource to that given player
Example Use: Would be invoked upon player stepping on top of the resource at whatever given point or when the player invoked the method (possibly by keystroke) to show they are gathering the resource - server will respond with how many resources the player obtains




Dylan:
void updateResources() throws RemoteException;

Functionality: Allows the client to manually trigger the server to generate resources.
Input: N/A
Output: N/A
Example: Dependant on implementation. If a team decides to implement resource growth Timer on the client side, the client with the Timer would call updateResources() to initiate the process of resource growth.




Tyler and Jiaqi:
int[][] getResources() throws RemoteException;

Input: N/A 
Output: 2D Array of ints
        Corresponds to the resources currently on the board displayed as a 2D array
        Example Values:[ 0 0 0 1 2 0 0 ]
                      [ 0 1 0 2 1 0 0 ]
                      [ 0 1 5 2 1 0 3 ]
                      [ 7 1 0 2 1 0 1 ]
                      [ 0 1 0 2 1 0 0 ]
        Max/Min Values: Min value would be an array filled with all 0s and max would be filled with all 7s
Functionality: get the current locations of all resources in the board
Example use: when some resource has been consumed or generated, this method will be called automatically by the server.