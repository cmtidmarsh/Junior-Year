C322 Spring 2021
Assignment 03
04/28/2021		
Group 14
Joshua Levy: jomlevy@iu.edu
Luke Klein: luklein@iu.edu
Benjamin Billings: benbilli@iu.edu

How to run the game:
When clients connect to the game they are asked to input true or false to state whether they are admins.
There can be multiple admins. To start the game they must press the 'b' key. This will initialize the game
board with resources distributed between two clusters. The clusters have a default resource distribution
of 50/50. An admin can change the distribution before pressing the 'b' key by pressing the '1', '2', or 
'3' keys. These keys assign the distribution of 50/50, 65/35, and 80/20 respectively. Once 'b' is pressed
the game will begin and run for 6 minutes, or 72 refresh cycles. Then the game is done.

Design Choices:
We decided to use the Observer pattern and the Simple Factory pattern. We used the Observer pattern to
notify the Controller when a key was pressed in the View so the Controller could update the Model with 
a player move. The Controller was an Observer of the Observable View. We used the Simple Factory to 
create our different types of controllers. There is the AdminController which can set the starting
state of the game and start the game and Controller which is just a basic Controller with no admin
functionality. We have a Client class that holds a main method that utilizes the ControllerFactory
so that we could create clients easily and dynamically. 

Note on UML:
The closed diamond means that the class is a private class used in the class the diamond is pointing to
The open diamond means that the class is a public class used in the class the diamond is pointing to