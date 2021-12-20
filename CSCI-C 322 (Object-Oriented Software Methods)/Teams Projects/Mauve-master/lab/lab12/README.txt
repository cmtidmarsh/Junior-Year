C322 Spring 2021
Lab12 
04/08/2021		
Group 13
Joshua Levy: jomlevy@iu.edu (33.3% work)
Riley Campbell: riricamp@iu.edu (33.3% work)
Kendall Mangrum: kmangrum@iu.edu (33.3% work)

Josh took lead on the .java file
Riley and Kendall did the UML Class Diagram

The affinity map below is from lecture 12:

User-resource interactions:
-Resource would be x by x and the user would be 2x by 2x
-Keep track of user coordinates
-Whenever the coordinates of the user overlaps the coordiantes of a resource the resource would be consumed

Timing and event tracking:
-Game can update every half-quarter second
-Players would move about a unit per second
-Resources would updated as fast as players move on each tick
-Each player object checks if it is overlapping a resource on each tik

RMI remote object definitions:
-Model class housed in the server
-ModelInterface that will be passed to the controller that the model will inherit
-ModelInterface will be how we call functions locally from the controller and interact with the model