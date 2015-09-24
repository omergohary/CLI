/**
 * @file MyController.java
 * 
 * @author Omer Gohary
 * 
 * @description This file implements the controller interface
 * 				
 * @date    24/09/2015
 */

package controller;

import java.util.HashMap;
import java.util.Hashtable;

import javax.activation.CommandMap;

import model.Model;
import view.View;

public class MyController implements Controller 
{
	public MyController(View view, Model model)
	{
		m_view  = view;
		m_model = model;
		
		/* Allocate all commands **/
		Command_dir dir 							= new Command_dir();
		Command_generateNew3dMaze generateNew3dMaze = new Command_generateNew3dMaze(m_model);
		
		/* Allocate the hash map and push all commands and strings */
		HashMap<String, Command> commandMap = new HashMap<String,Command>();
		
		commandMap.put("dir", dir);
		commandMap.put("generate3dMaze", generateNew3dMaze);
		
		// send to the view the hash-map
		m_view.SetCommandsContainer(commandMap);
	}
	
	@Override
	public void Print(String stringToPrint) 
	{
		m_view.Print(stringToPrint);
	}
	
	/*********************** Member **********************/
	
	View  m_view;
	Model m_model;
}
