  
Team 14: Ochre
Clare Tidmarsh, cmtidmar@iu.edu
Daniel Akinniranye: dakinnir@iu.edu
Zachary Wendholt: zwendhol@iu.edu

Submission Date: 04.21.2021


Link to working UML class diagram:
https://lucid.app/lucidchart/invitations/accept/inv_08362cc0-0864-4ca6-a26c-c1fa4d845e9a?viewport_loc=-11%2C-11%2C3072%2C1588%2C0_0


Changes From Lab12 Diagram and Selected Design Documents:
--------------------------------------------------------

We made a significant amount of changes from our most recent UML Class Diagram (Lab12) and additions were implemented in response
to adhere to the selected design documentation.

1. Timer in Model:
In our previous UML Class Diagrams for the Forager game as well as Team 05's class, we did not implement a timer in the model. We
believe that implementing a timer in the model is crucial as the timer allows asynchronized, universal count down for all users on
the server. By having a universal timer, everyone on the server would be on the same time regardless of potential client technical
difficulties. This allows fairness each player. If the timer was only on the client side, everyone could essentially be on different
tickrates, therefore, defeating the purpose of a game between users. The timer would also account for resource respawn as it would be 
unfair if the resources on individual clients respawned at different times unsynchronized. This was also discussed in lecture the week
of 04.12.2021-04.16.2021 as well as on 04.19.2021.

2. Key Inputs (considered a change? or just a free implementation?):
Key Listener was added for user interaction, how the user interacts with the program was not stated previously in diagram.
In Team 05's affinity map, they mention the usage of pressing the spacebar to "consume"/collect resources, while in Team 16's UML
Class Diagram, they suggested using the mouse as the movement for the user. The materials in the C322-students-repo/lectures/lecture24
documents do not outline how the player moves (i.e. key events, mouse, events, etc). Assuming that most will implement MouseEvent from
Team 16's diagram, we will use key events (i.e. w,a, s, d) to cohere to the spacebar operation that Team 05 listed in their
documentation. By doing so, the user will only need to use the keyboard to play the game instead of using a mouse to and the keyboard.
With the keyboard already in use, this simplifies the controls for the user as well as accomdates for the mouse and trackpad play, as
it is more difficult to click on a trackpad and hit the spacebar fast enough.

3. The model itself and server extends the UniCastRemoteObject. The UniCastRemoteObject was thrown in the original Lab12 diagram in the interest
of time for presentations. We adjusted it to extend its respected classes for Assignment02.

4. The model, controller, and view are now directionally associated with the player class instead of the solely the model. As the player class
is seen in the model, controller, and view.

5. Forager Server was also implemented to request model giving the controller as input to adhere to selected design, when we created our Lab12
diagram we failed to create a representation on the diagram of the server class.

6. A setID() function was added to the player class. As discussed in lecture on 04.19.2021, we are not entirely sure if we are allowed to add
a setID() method in regards to the strict policy to follow the selected design documents accordingly. However, since it was discussed in class
as well as a lecture task, we believe that it is allowed to create such method for now. This is similar to Changes(1): Timer in Model.

Notes:
-------
1. Observer and Decorator chosen. We chose the Observer implementation as it has an update method that is used when a notify observers method is called. The observer will
observe what is happening in the model then will send the changes to the controller for the update. Observer is the most viable as the client is constantly updating with
player movements, resource respawning, etc. The decorator pattern is used as all users will have the same methods and will be able to be at the same coordinates or at different
coordinates with the exception that the only input that will always be different between players is their id number. Each new player will be decorated with the same methods
as the last.

2. See Changes(2). (Not sure if's it's an actual change or just our implement as a specific form movement is not listed in the documents.) 

3. Class(04/19) mentioning about how to keep track of player ID's in the model. Implementation does not need to be completed at this time?

4. Would it have been more beneficial to implement a simple factory when creating players? For instance, a user joins the server and a simple 
factory would create the player.



