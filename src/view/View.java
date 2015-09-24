/**
 * @file view.java
 * 
 * @author Omer Gohary
 * 
 * @description This file represents an interface to the view in the MVC
 * 				
 * @date    24/09/2015
 */

package view;

import java.io.IOException;
import java.util.HashMap;

import controller.Command;
import controller.Controller;

public interface View 
{
	public void setController(Controller controllerToCommunicate);
	
	public void SetCommandsContainer(HashMap<String, Command> mapToSet);

	public void start() throws IOException;
	
	public void Print(String stringToPrint);
}
