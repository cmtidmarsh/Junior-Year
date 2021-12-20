Team 9 (Flamingo)
C322 / Spring 2021
Lecture 22
4/7/21

Team:
Camisa Vines (cdvines)
Tanner Hay (tanhay)
Adam Martinez (asm9)

Camisa's questions:
1. How many users can collect the same resource? How _large_ are resources?
2. How will timing and event tracking affect RMI communication?
3. What event will trigger game end?

Tanner's questions:
1. Should the users step to collect or press a key to collect
2. Should the player and food be on the same timer
3. How divided should the classes be?

Adam's questions:
1. Where can resources spawn?
2. How should players collect the resources?
3. How often should resources spawn?


Affinity Map:
User-Resource Interaction:
    - C1, T1, T2, A2 
Timing and Event tracking:
    - C2, A1, A3
RMI Object Definition:
    - C3, T3


M-VC Specification Questions
• game specification for user-resource interactions / How should the game be configured?
    - Resources should be 1 tile. Resources can spawn on any tile that there is not a player. 
      In order to collect the resource, the player must navigate to the tile and then move onto it. 
      After 1 player collects the resource, it is gone and can only be collected after another one spawns in the same tile.

• game specification for timing and event tracking / How timing is considered in the design?
    - Have 2 different clocks/cycles one for movement and another for growth. 
      The movement should be faster than the growth so that it can lead to cases where all the recourses are consumed

• suggest Java RMI remote object definitions for the game / In other words, What should the server provide to the client?
    - We will definitely need the Model, View, and Controllers Objects
    - With the Model on the server side, it will need to make its methods and variables regarding the game board visible to the Controller
    - It will also need a way to recieve information from the Controller about the games state.
    - All user actions will be taken in by the view and sent to the server to recieve instructions for next state.


