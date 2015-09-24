/**
 * @file CLI.java
 * 
 * @author Omer Gohary
 * 
 * @description This file is responsible on the command line interface of the project
 * 				
 * @date    24/09/2015
 */

package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import controller.Command;

/**
 * This class represents the command line interface of our system
 */
public class CLI 
{

	/**
	 * C-Tor
	 * @param in  - stream in
	 * @param out - stream out
	 */
	CLI(BufferedReader in, PrintWriter out, HashMap<String, Command> commandConatinerToHandle)
	{
		m_streamIn  = in;
		m_streamOut = out;
		m_commandContainer = commandConatinerToHandle;
	}
	
	/**
	 * This function is running in a parallel thread and is responsible 
	 * on getting commands from the user and handle them.
	 * 
	 * @throws IOException
	 */
	public void Start() throws IOException
	{
		  new Thread(new Runnable() 
		  {
			  @Override
			  public void run() 
			  {
				  String newLine;
				
				  // gets strings until the user will type "exit" string
				  try 
				  {
					  while((newLine = m_streamIn.readLine()) != "exit")
					  {
						 Command matchCommand;
						 if ((matchCommand = m_commandContainer.get(newLine)) != null)
						 {
							 matchCommand.doCommand();
						 }
						 
						 else
						 {
							 System.out.println("Bad type of command");
						 }
					  }
				  } 
				  
				  catch (IOException e) 
				  {
					  e.printStackTrace();
				  }
		      }
			  
		  }).start();
	}
	
	/********************** MEMBERS **********************/
	
	/** Streams - in and out **/
	BufferedReader m_streamIn;
	PrintWriter    m_streamOut;
	
	/** The data base of possible commands to handle in this CLI **/
	HashMap<String, Command> m_commandContainer;
}
