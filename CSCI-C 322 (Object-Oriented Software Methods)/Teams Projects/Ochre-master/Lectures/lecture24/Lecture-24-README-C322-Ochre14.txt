Ochre, Team 14
Submission Date: 04.13.201

Clare Tidmarsh, cmtidmar@iu.edu
Daniel Akinniranye: dakinnir@iu.edu
Zachary Wendholt: zwendhol@iu.edu

Lecture 24: Class Assignment

Affinity Map
-----------



---Game Specification for user-resource interactions---
1.Should the gatherResources() be on the client side rather than in the model because shouldn't it be
in the player class along with the getResources(int)?
I think we forgot to ask?

2.What's difference between gatherResources(int forPlayer) and getResources(), does getResources get
all of the resources on the board while gatherResources() is the action of consuming the resource?
(goes in categories event tracking and user-resource)
"getResources(): int[][] will be the resources along the entire board"

3.(Zachary Wendholt after lecture) why would we need to use a hashmap for the method getPlayerPositions? would a 
hash map actually benefit us computationally more than a list?

---Game Specification for timing and event tracking---
1.What's difference between gatherResources(int forPlayer) and getResources(), does getResources get
all of the resources on the board while gatherResources() is the action of consuming the resource?
(goes in categories event tracking and user-resource)
"getResources(): int[][] will be the resources along the entire board"

2. Should there be a synchronized timer in the Model rather than just in the controller?
"You can put in controller or in model, you will call gatherResources() on the timer.

3.(Zachary Wendholt after lecture) If ID is used to track different players, how will the initial id be set for a new user?  

---Java RMI Remote Object Definitions for the game---
1. "controllerToModels" in the ForagerServer makes it seem as though there are multiple models, but
isn't there one unified server/model and multiple controller and view for each player?
Not enough time to ask.

2. Why is the Player class on the client side rather than the RMI? Isn't the player class also an extension
of the model in a way?
The player class will be used to be on either side, depending on how you wanted to implement it.

3. (Zachary Wendholt after lecture) does the foragerInterface need to contain the method updateResources()? it 
seems like this would be handled in the actual model. 
