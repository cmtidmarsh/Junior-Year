C322 / Spring-2021
Lecture 24
Team 3

Tyler Burdon      tcburdon@iu.edu
Jiaqi Huang       jh106@iu.edu
Dylan Herthoge    dherthog@iu.edu

Questions for Team 5
--------------------
- How Player client relations work?
	+ Player classes are "in sync" about their location on the map
	+ the Player class is shared between the Model and the Client
- Main method in both View and Controller but not in Model/Server?
	+ No main in View, one in Model or some in 
- How are we supposed to implement multiple models and controllers? Is it like having multiple "servers" people can play on?
	+ Just one ForageModel, no ForagerServer.
- Does gatherResource() mean gather the number of coins one player has?
	+ It means you have successfully gathered the resource
	
Notes
-----
- sendPlayerPosition should either take a Player object, or should take an ID, x, y, etc.
- To make your own playerID, get player list and then get the max id number and add 1 to it
