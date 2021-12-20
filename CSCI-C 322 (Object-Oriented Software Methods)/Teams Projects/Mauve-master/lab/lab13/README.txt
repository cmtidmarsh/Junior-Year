C322 Spring 2021
Lab13 
04/15/2021		
Group 13
Joshua Levy: jomlevy@iu.edu (33.3% work)
Riley Campbell: riricamp@iu.edu (33.3% work)
Kendall Mangrum: kmangrum@iu.edu (33.3% work)

getPlayerPosition:
Input type: int
Output type: HashMap<Integer, Pair<Integer, Integer>>
Returns positions of all other players
Called every tick to update players views based on other players movement

sendPlayerPosition:
Input type: int, int, int
Output type: void
Updates a players position based on their last move, so from the player to the model
Called every time a player makes a move. Sends the ID of the player as well as their new position

gatherResources:
Input type: int
Output type: int
Returns the number of resources collected by a given player based on their player ID which is the input
Called every tick and checks collisions on the board

updateResources:
Input type: void
Output type: void
Refreshes the board and grows resources based on the Forager game logic
Called every tick

getResources:
Input type: void
Output type: int[][]
Returns the resource state of the board as a 2d array of ints. The ints represent the resource level on each space
Called client side to update each client based on the current resources of the board. Called each tick