/**
 * @file Command_generateNew3dMaze.java
 * 
 * @author Omer Gohary
 * 
 * @description This file represents a command that responsible to 
 *              ask the model to create new 3d maze
 * 				
 * @date    24/09/2015
 */

package controller;

import java.io.File;
import java.io.IOException;

import model.Model;

/**
 * The command that responsible on "generate 3d maze" request
 */
public class Command_generateNew3dMaze implements Command
{
	public Command_generateNew3dMaze(Model model)
	{
		m_model = model;
	}

	@Override
	public void doCommand(String args) throws IOException 
	{
		/* in this case:
		   args[0] = name
		   args[1-2-3] = dimX,Y,Z
		   Example: OmerMaze 3 3 3 */
		
		 String[] arr = args.split(" ", 4);		
		
		 m_model.generate3dMaze(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Integer.parseInt(arr[3]));
	}
	
	/************ Member **********/
	Model m_model;
}

