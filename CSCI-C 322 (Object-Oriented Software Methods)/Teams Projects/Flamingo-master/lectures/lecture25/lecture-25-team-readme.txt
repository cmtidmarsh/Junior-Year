Team 9 (Flamingo)
C322 / Spring 2021
Lecture 25
4/19/21

Team:
Camisa Vines (cdvines)
Tanner Hay (tanhay)
Adam Martinez (asm9)

rmi side:
foragerModel
foragerServer
(as well as cooresponding interfaces)

client side:
controller
view
player
tile 

The server will have a variable that keeps track of the number of players. This will be used to assign ID's based on the order that players join.
This is a good solution because it prevents duplicate ID's.
The interface seems sufficient in terms of ID's.
We would leave it the same.

We think the design should be updated so that only the server is able to call updateResources(). This would prevent all the clients from calling it themselves,
which could help performance, as well as simplify the design. There should be a clock only on the server.
Resources would be generated at some formula based on the number of players present at a time and based on  the time that each cell is empty
