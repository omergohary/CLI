/**
 * @file Command_dir.java
 * 
 * @author Omer Gohary
 * 
 * @description This file represents a command that responsible to 
 *              show the folders and files in specific dir the user typed.
 * 				
 * @date    24/09/2015
 */

package controller;

import java.io.File;
import java.io.IOException;

/**
 * The command that responsible on "dir" request
 */
public class Command_dir implements Command
{

	@Override
	public void doCommand(String args) throws IOException 
	{
		// "args" in this case must be the required user's dir
		File dir = new File(args);

		File[] files = dir.listFiles();
		for (File file : files) 
		{
			if (file.isDirectory()) 
			{
				System.out.print("Dir:");
			} 
			else
			{
				System.out.print("      File:");
			}
			
			System.out.println(file.getCanonicalPath());
		}	
	}
}
