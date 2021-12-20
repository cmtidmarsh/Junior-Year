
Ochre - Team 14
April 19, 2021

Daniel Akinniranye: dakinnir@iu.edu
Clare Tidmarsh: cmtidmar@iu.edu
Zachary Wendholt: zwendhol@iu.edu

C322 Student Team Feedback
--------------------------
Which Team member contributed most to this task?
Zach.
Which Team member contributed least to this task?
Daniel. 
Did anyone not contribute at all to this task?
Daniel.
Are there any problems with your Team?
No, Daniel was not in live lecture.



3-person team evaluation
-------------------------
first name	last name	% contributed to team work
Clare	Tidmarsh	(40%)
Zach  Wendholt    	(60%)
Daniel Akinniranye	(0%)

Task A
---------
Classes on Server-Side:
ForagerInterface
ForagerModel
ForagerServer

Classes on Client-Side:
Controller
View
Player (user)


Server-side classes that interact with Java RMI
ForagerInterface

client -side classes that interact with Java RMI
Controller

The ForagerInterface does not seem to provide a method for assigning Player IDs to the (many) game clients which connect to the (one) game server.

 • How did you solve this problem for Assignment 02?
By putting the player class on the client side, as well creating a method in the controller that creates unique IDs by checking the array of the different player IDs in the model. 

• Is that a good solution? 
	Yes. 


• Should the selected Java RMI interface be modified to provide a better Player ID mechanism?
Yes.
 
• How would you modify the Java RMI interface?
The JAVA RMI interface should be modified to be able to assign each user to an ID on the server side as the server will keep track of all information pertaining to the player ID, their location, etc. 





The ForagerInterface as described seems to be designed to work asynchronously, and without a server-side clock timer, since it provides a method void updateResources() for each client to request the resources to be updated. Each client may call this method at any time. 

• At what rate (i.e. when, how often) does your Assignment 02 implementation update resources on the server-side grid of cells? 
The resources will update every 5 seconds on the server-side grid of cells. This allows users enough time to gather resources in between respawns. 

• Should the selected Java RMI interface be modified to provide a server-side clock timer for updating resources at a constant pace?

Yes. There would be differences in the time ticks between different players, meaning that they would be interacting with the model based on different times if they are not using a server-side clock. 


Task B
--------

Present
