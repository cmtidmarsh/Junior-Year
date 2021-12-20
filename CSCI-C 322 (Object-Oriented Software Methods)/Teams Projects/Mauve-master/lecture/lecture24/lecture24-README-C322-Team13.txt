Riley Campbell riricamp@iu.edu - Kendall Mangrum kmangrum@iu.edu - Joshua Levy jomlevy@iu.edu

Clarification Questions:

- Are we going to be allowed to add anything to the interface or do we have to work with what is given?
- Has sendPlayerPositioin, is a getPlayerPosition method needed?
	- This is what the hash map is for
- What do we do if the return types of our existing game don't fit with the return types of the interface?
- What do we do if we need more functions than the interface provides?


Implementation Questions
- Are there functions in this interface that a Controller or View would be dependent on?
- Are the current return types the best way to store and communicate data from the distributed objects to the individual controllers?

Notes from Team05
- Timer could be in the controller or model
- gatherResources returns how many resources a player should pick up
- One forager model for all of the clients
- Player class is used on both client and server but are not the same exact object
- updateResource is the growth of the resources
- PlayerID would get list of players and add 1 to create new player ID
- SendPlayer should sent the player class or the player id and more information

