Team 14

April 7, 2021

Daniel Akinniranye: dakinnir@iu.edu
Clare Tidmarsh: cmtidmar@iu.edu
Zachary Wendholt: zwendhol@iu.edu




user-resource interactions(contributed all):

	Zach - clicking to pick up resources / moving tiles. 
	Daniel - user inventory (max storage space)
	Clare - dropping items.
	Zach - using resources for movement.

game specification for timing and event tracking(contributed all):

	Clare - respawning resources (longer time ticks)
	Zach - updating the screen based on time ticks
	Clare - count down timer
	Daniel - player movement
	Zach - Implement picking up items at the same time

suggest Java RMI remote object definitions for the game(contributed all):

	M-VC
	
	Player:
		Daniel - getResource
		Clare - getPosition
		Zach - movement(mouseEvent)
	

	World:
		Zach - timeLeft: Timer		
		Clare - getNumResource()
		Daniel - getResourceLocations()
		Clare - respawnResource(timer)
		Daniel - removeResource()
		
		
