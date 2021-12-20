

Readme for lab08:

	Changes made from original UML

		Controller
			We realized that we would not need a stop() function as it is not specified in the requirements.

			We also realized that ifCell(), initialTable() and generateNewCell() was not necessary as the function of it was being completed in the Model.
			The observable was also moved from the controller to the model. Controller implement Observer, and override update. What we put in update is a function from view called display which takes a 2d Boolean array, and draw image so that View gets update everytime the given 2d Boolean array is changing.

			The square class was not necessary as the squares are drawn based on the grid in the model, not a square class.

		View
			We addded a function called draw square which paints the square itself rather than being done in the display to decouple the code. 
			
			Update is also removed as the observer pattern handles this for us. 
			
			An instance variable of Graphic was added as it is an important function of the JFrame.

		Model
			The functions for checking the surrounding areas was moved inside the increment generation because it was not necessary to be there own functions.
			The function of initial we create in model so that thing it has something to works on in increment function.
			The notifyObsevers method has also been moved to the model because this will allow it to update the observer everytime if grid is  is updated. 
				
