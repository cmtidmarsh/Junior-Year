Team 14

April 8, 2021

Daniel Akinniranye: dakinnir@iu.edu
Clare Tidmarsh: cmtidmar@iu.edu
Zachary Wendholt: zwendhol@iu.edu




Afinity map - 


Zach - user-resource interactions:

	when two players pick up an item at the same time
	mouse click to move player
	resources are one tile
	check for resource on same tile as player
	using resource
	need set ammount of resources to move to next level
	
	

Daniel - game specification for timing and event tracking:

	respawning resources (longer time ticks)
		if a resource isn't harvested in a set ammount of time, the resource spawns somewhere else
	updating the screen based on time ticks
	count down timer
	player movement
	Implement picking up items at the same time
	If player doesn't have resources for an ammount of time, they lose
	

Clare - suggest Java RMI remote object definitions for the game:

	M-VC
	

	World(model):
		countPlayerResource()
		removeResource()
		setPosition(mouseEvent)
		getPosition()
		clearBoard()
		setBoard()
		
		
		
		
		
 