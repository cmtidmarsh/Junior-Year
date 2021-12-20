C322 / Spring-2021
Lecture 25
Team 3

Tyler Burdon      tcburdon@iu.edu
Jiaqi Huang       jh106@iu.edu
Dylan Herthoge    dherthog@iu.edu

- the ForagerInterface does not seem to provide a method for assigning Player IDs to the (many) game clients which connect to the (one) game server.
	+ How did you solve this problem for Assignment 02?
		= We had each player use it’s hashcode as an ID. When a player is instantiated it will set its own id
	+ Is that a good solution?
		= There is possibility that separate instances will generate the same ID, but it is highly unlikely
	+ Should the selected Java RMI interface be modified to provide a better Player ID mechanism?
		= Yes
	+ How would you modify the Java RMI interface?
		= We would create a new method with the following signature:
			> public Player generatePlayer()
			
			
			
			
- the ForagerInterface as described seems to be designed to work asynchronously, and without a server-side clock timer, since it provides a method void updateResources() for each client to request the resources to be updated. Each client may call this method at any time.
	+ At what rate (i.e. when, how often) does your Assignment 02 implementation update resources on the server-side grid of cells?
		= It updates the resources every 3 seconds
	+ Should the selected Java RMI interface be modified to provide a server-side clock timer for updating resources at a constant pace?
		= Yes..? The server could run its own clock and change the access of updateResources to private to ensure clients don’t call it.




Server Side:
	- ForagerIntf
	- ForagerGame
	- Cell

Client Side:
	- Controller
	- View
	- PlayerMoved

Shared:
	- Player
	- ConcretePlayer
	- PlayerDecorator
	- GreenPlayer, BluePlayer, RedPlayer
	- Pair 
	- ThreePair

Server Side classes that interact with RMI:
	- ForagerGame

Client Side classes that interact with RMI:
	- Controller
	
