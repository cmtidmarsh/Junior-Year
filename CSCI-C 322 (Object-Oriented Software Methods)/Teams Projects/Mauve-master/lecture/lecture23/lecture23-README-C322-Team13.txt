C322 Spring 2021
Lecture23
04/12/2021		
Group 13
Joshua Levy: jomlevy@iu.edu (33.3% work)
Riley Campbell: riricamp@iu.edu (33.3% work)
Kendall Mangrum: kmangrum@iu.edu (33.3% work)

Josh took lead on the .java file
Kendall did the UML Class Diagram
Riley looked over the other groups work and did the README

Game Specification for User-Resource interactions

- Users and Food are 1x1 tile large
- Click a button to pick up resource(Possibly)
- Keep track of user coordinates

Timing and event tracking

- Game updates every 1/4 second
- Players move one tile per update
- Resources would update as fast as players move on each tick
- Each player object checks if it is overlapping a resource on each tick

Suggest Java RMI Remote Object Definitions for the game

- (M-VC)
- Model Possible Functions
	   - GetPlayerMovements - sends the player movements to all players
	   - SendPlayerMovement - send my movement to the server model
	   - GatherResource(forPlayer) - picks up the number of resources the player is standing on, if any
	   - UpdateResources - for all players
	   - GetBoard - gets resource board