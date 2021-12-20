Team 4 Lab 13 
Christian Dummer cjdummer@iu.edu
Samantha Sharp sharpsam@iu.edu
Adam Wittenberg adamwitt@iu.edu




HashMap<Integer, Pair<Integer, Integer>> getPlayerPositions(int except)
* Parameters: except the player who you want to filter out of the list (the client).
* Returns: A hashmap of player ID's with a Pair of (X, Y) coordinates.
* Functionality: Retrieves all of the player positions who are in the server, except for your own position.
* Example use: Gets all other players’ positions in order to appear on the user’s side. The controller would retrieve these positions so other players would appear.




Void sendPlayerPosition(int playerID, int positionX, int positionY)
* Parameters: playerID - the ID of the client side player who needs an updated position
   * positionX: the x coordinate to send to the player
   * postionY: the y coordinate to send to the player
    -  Returns: nothing, is a void method
    - Functionality: sends the x and y coordinates to the player with the    corresponding ID.
    - Example use: player moves and needs to visually see their position updated, as recognized by the server.




Void updateResources() 
* Parameters: none 
* Returns: nothing, is a void method
* Functionality: generates resources on the board, called externally off of whatever timer is implemented.
* Example Use: After some developer-defined time, this method is called to run the forager equation and calculate where resources grow.




Int[][] getResources()
* Parameters: none 
* Returns: A 2d array of ints that represents the game board
* Functionality: Returns a data representation of the board to the client side for their view to update.
* Example use: a new player is made on the client side and joins the game. Their controller then calls this function from the server to get the current board state to show the client.


gatherResource(int forPlayer)
* Parameters: forPlayer - PlayerID who picked up the resource
* Returns: An integer indicating the number of resources that user had picked up at that space
* Functionality: Gathers resource for a given player from the given playerID, returning the amount of that resource that the given player has gathered
* Example Use: When a player is playing the game and wants to gather a resource at the given space, this method would be called and the integer returned is then added to that players total resources