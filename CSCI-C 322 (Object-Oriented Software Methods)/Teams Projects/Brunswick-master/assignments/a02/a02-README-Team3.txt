C322 / Spring-2021
Assignment02
Team 3
4/18/2021

Tyler Burdon      tcburdon@iu.edu
Jiaqi Huang       jh106@iu.edu
Dylan Herthoge    dherthog@iu.edu

NOTE
==========
change location of initial-board.txt in ForagerGame.java to reflect the path on your machine


=====================================================================

We first started by modifying the UML and made all changes necessary
	We opted to implement the Observer and Decorator Pattern
	Once we were done with the UML, we moved on to the actual coding aspect
	
We used Dylan's implementation of Lab11 and started with that
	We split it up so that Jiaqi was in charge of the players and the decorator
	Tyler was in charge of the Game Interface and Game class
	Dyaln was in charge of the Controller, View, and a lot of miscellanious server work and help where needed
	
Dylan helped with all the testing and miscellanious bug fixes along the way

=====================================================================

UML Changes:

We opted for the Observer and Decorator Patterns:

For the observer pattern we had the View implement the Observer class and the Controller implement the Observable class.
We needed a class to manage each of the users that would be playing the game so we implemented a Player class for this.
	We decided to use a decorator pattern for this so we could easily tell apart each player by allowing each user to select their colors
	These changes took the form of the new classes: GreenPlayer, BluePlayer, RedPlayer, ConcretePlayer, and PlayerDecorator


The Game class became our ForagerGame class and we created an interface for it which was specified to Group5’s specifications. 
In ForagerGame we added the necessary methods and variables responsible for keeping track of all players, resources, and the process of sending all information to the server.
To do so, our ForagerGame class implements the UnicastRemoteObject and our Interface implements java.rmi.Remote. 

Along the way, we needed a way to keep track of players UniqueID and their positions on the board, so Dylan defined 
a separate Pair data structure to help us with this. Dylan also defined a ThreePair data structure for communication between the Controller and the View.

Our View was originally very basic and in order for us to have functionality and the ability to differentiate players and enemies we 
borrowed heavily from java.awt.Color and methods to paint the board and players.



	
