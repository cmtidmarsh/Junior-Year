C322 / Spring-2021
April 8, 2021
Team 4
	Christian Dummer cjdummer@iu.edu
	Samantha Sharp sharpsam@iu.edu
	Adam Wittenberg adamwitt@iu.edu

User-Resource Interactions 
    **How do users interact with resources?**
    -Users activate the grid space that contains food in order to consume that food
    -The user will be a circle contained within a square on the grid, the user will use the arrow keys to traverse the grid,
    and can only activate a grid space that they are directly on top of.
    -Users gain resources that fill their health bar, and every move with the arrow keys slightly depletes their health bar

Timing and Event Tracking 
    **How long is a round?**
    -Rounds can last 10 seconds, that is enough time to move around and consume a resource or two
    **How fast does a user move?**
    -Users move one square per second

RMI Object Definitions 
    -We are going with a M-VC design so the model needs to be hosted as a distributed object
    -This model should keep track of the state, where every user is on the board,
    the position of each food item on the grid.