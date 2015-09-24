/**
 * @file Model.java
 * 
 * @author Omer Gohary
 * 
 * @description This file represents an interface to the model in the MVC
 * 				
 * @date    24/09/2015
 */

package model;

import java.io.IOException;

import controller.Controller;

public interface Model
{
	public void setController(Controller controllerToCommunicate);
	
	public void generate3dMaze(String mazeName, int dimX, int dimY, int dimZ) throws IOException;
}
