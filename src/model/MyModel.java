/**
 * @file MyModel.java
 * 
 * @author Omer Gohary
 * 
 * @description This file implements the model interface
 * 				
 * @date    24/09/2015
 */

package model;

import java.io.IOException;
import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import controller.Command;
import controller.Controller;
import model.Model;

public class MyModel implements Model 
{
	/** C-Tor **/
	public MyModel()
	{
		m_mazes = new HashMap<String, Maze3d>();
	}
	
	@Override
	public void setController(Controller controllerToCommunicate)
	{
		m_controller = controllerToCommunicate;
	}
	
	@Override	
	public void generate3dMaze(final String mazeName, final int dimX, final int dimY, final int dimZ) throws IOException
	{
		  new Thread(new Runnable() 
		  {
			  @Override
			  public void run() 
			  {
				  // generate the maze
				  Maze3d generatedMaze = new MyMaze3dGenerator().generate(dimX, dimY, dimZ);
				  
				  // save it
				  m_mazes.put(mazeName, generatedMaze);
				  
				  // ask controller to send msg out
				  String msgToPrint = String.format("Maze: %s is ready!", mazeName);
				  m_controller.Print(msgToPrint);
		      }
			  
		  }).start();
	}
	
	
	/********************* Members **********************/
	Controller m_controller;
	
	HashMap<String, Maze3d> m_mazes;
}
