Team 13: Richard Caraher (rjcarahe@iu.edu), Nolan Cauley (nmcauley@iu.edu), Clare Tidmarsh (cmtidmar@iu.edu)
Submission: 02-22-2021

When and how to use the Singleton pattern within the Binary Calculator MVC?
-------------------------------------------------------------------------------------
Singleton pattern works will with controller and/or model since you only want to have one
instance of a controller and model, whereas, you can have multiple views.
Within the Binary Calculator MVC, the singleton pattern works best within the controller
section. Making a private controller class with an instance checker ensures that the 
MVC controller class is unique and has access to all of the information to ensure that
the data being passed between the model and the view are not overlapping and accurate. 


Snippet of Java Code
-------------------
public class Controller{

private static Controller controllerInstance;
private Controller(){}

public static Controller getInstance(){
  if (controllerInstance == null){
    controllerInstance = new Controller();
    }
return controllerInstance;
  }
}
