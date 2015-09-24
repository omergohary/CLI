/**
 * @file Command.java
 * 
 * @author Omer Gohary
 * 
 * @description This file represents an interface to all of the command that handle the CLI user's commands
 * 				
 * @date    24/09/2015
 */

package controller;

/**
 * This interface class represents a single command that uses in the CLI class
 */
public interface Command 
{
	/**
	 * Execute function that the command must implements
	 */
	public void doCommand();
	
}
