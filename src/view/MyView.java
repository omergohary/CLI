/**
 * @file MyView.java
 * 
 * @author Omer Gohary
 * 
 * @description This file implements the view interface
 * 				
 * @date    24/09/2015
 */

package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import controller.Command;
import controller.Controller;
import view.View;

public class MyView implements View 
{
	/**
	 * C-Tor. Allocate the hash map
	 */
	public MyView(BufferedReader in, PrintWriter out)
	{
		m_commandContainer = null;
		m_isInitialized    = false;
		m_streamIn  	   = in;
		m_streamOut 	   = out;
	}

	@Override
	public void start() throws IOException 
	{
		if (m_isInitialized != true)
		{
			System.out.println("MyView had not got its hash map from the controller yet!");
			return;
		}
		
		try 
		{
			m_cli = new CLI(m_streamIn, m_streamOut, m_commandContainer);
		} 
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		// run CLI
		m_cli.Start();
	}
	
	/**
	 * Setter to the hash map data member
	 * 
	 * @param mapToSet - the map to set
	 */
	@Override
	public void SetCommandsContainer(HashMap<String, Command> mapToSet)
	{
		m_commandContainer = mapToSet;
		m_isInitialized    = true;
	}
	
	@Override
	public void setController(Controller controllerToCommunicate)
	{
		m_controller = controllerToCommunicate;
	}
	

	@Override
	public void Print(String stringToPrint) 
	{
		System.out.println(stringToPrint);
	}
	
	
	/********************* Members *******************/
	
	
	/** Streams - in and out **/
	BufferedReader m_streamIn;
	PrintWriter    m_streamOut;
	
	boolean m_isInitialized;
	HashMap<String, Command> m_commandContainer;
	CLI m_cli;
	
	Controller m_controller;
}
