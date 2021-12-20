C322 / Spring-2021
Lecture 25
April 19, 2021

Team 4
Christian Dummer cjdummer@iu.edu
Samantha Sharp sharpsam@iu.edu
Adam Wittenberg adamwitt@iu.edu

Briefly list each class in your Assignment 02 design: 
Classes on server-side 
* ForagerModel
* ForagerInterface
* Player
* Pair

Classes on client-side. 
* Controller
* View
* Tile
* Player
* Pair

Briefly describe which server-side classes interact with the Java RMI interface
* ForagerModel, this class is distributed over RMI to connect with each controller object that is created (i.e. a new player)  

Briefly describe which client-side classes interact with the Java RMI interface
* Controller, any time a new user starts up the program, a controller is created that generates a player object for them, and then interacts with the distributed model to get the current state of the board, and let them start playing. 

The ForagerInterface does not seem to provide a method for assigning Player IDs to the (many) game clients which connect to the (one) game server. How did you solve this problem for Assignment 02? 
* When a player is created their ID is a hashcode

Is that a good solution? 
* Somewhat as this generates a unique code for each player object

Should the selected Java RMI interface be modified to provide a better Player ID mechanism? 
* Yes, as the model recognizing each individual player would work fine to assign each of them an ID.

How would you modify the Java RMI interface? 
* Add a method that is called when a new player is added to the player list, generating a unique ID for that new player.

The ForagerInterface as described seems to be designed to work asynchronously, and without a server-side clock timer, since it provides a method void updateResources() for each client to request the resources to be updated. Each client may call this method at any time. At what rate (i.e. when, how often) does your Assignment 02 implementation update resources on the server-side grid of cells? 
* Roughly every 10 seconds

Should the selected Java RMI interface be modified to provide a server-side clock timer for updating resources at a constant pace?
* Yes, the game would be far more consistent if the server has its own clock controlling the flow of the game rather than the players.