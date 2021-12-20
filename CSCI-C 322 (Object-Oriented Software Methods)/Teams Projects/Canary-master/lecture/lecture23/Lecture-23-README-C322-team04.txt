C322 / Spring-2021
Lecture 23
April 12, 2021

Team 4
Christian Dummer cjdummer@iu.edu
Samantha Sharp sharpsam@iu.edu
Adam Wittenberg adamwitt@iu.edu

*From Team 5, with some wording changed*

Game Specification for user-resource interactions
- Users are 1 tile large
- Resources are 1 tile large
- Hit spacebar to pick up resource
- Check if where they moved to has a resource
- user "eats" resource and gains some level of currency or food
- Different tile colors for how many resources are in that tile (such as a rainbow pattern)

Game Specification for timing and event tracking
- Timer for generating more resources. can have some level of randomness
- Player punishement for running out of food
- Player movements sent to other players either by timer or by their own movement
- Player collision
	- Player stacking
	- Player order preference (only 1 player per tile)

Suggest Java RMI Remote Object Definitions for the game
- Model Possible Functions
	- GetPlayerMovements - sends the player movements to all players
	- SendPlayerMovement - send my movement to the server model
	- GatherResource(forPlayer) - picks up the number of resources the player is standing on, if any
	- UpdateResources - for all players
	- GetBoard - gets resource board