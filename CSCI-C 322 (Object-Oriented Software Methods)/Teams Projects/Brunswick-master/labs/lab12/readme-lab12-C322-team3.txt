C322 / Spring-2021
Lab12
Team 3

Tyler Burdon      tcburdon@iu.edu
Jiaqi Huang       jh106@iu.edu
Dylan Herthoge    dherthog@iu.edu

Dylan
- contributed to UML
- user-resource interactions
	+ give to first player to "touch" the resource
		= divide between players if two obtain it on the same tick
	+ each player has resource value that is incremented when a resource is consumed
	
Tyler
- contributed to the UML and java file
- timing and event tracking
	+ have ticks (i.e. 60 ticks per second)
		= resources generated per tick
		= can only move once per tick at the given tickrate
	+ server queues calls from the clients and updates the state every tick
	
Jiaqi
- contributed to UML
- RMI remote object definitions
	+ getResourceLocation() : ArrayList<Resource>
	+ getPlayerLocations() : ArrayList<Player>
	+ giveCurrentLocation(Player)
	+ notifyResourceConsumed(Player, Resource, Int) : Int