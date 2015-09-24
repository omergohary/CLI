package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CLI 
{

	/**
	 * C-Tor
	 * @param in  - stream in
	 * @param out - stream out
	 */
	CLI(BufferedReader in, PrintWriter out)
	{
		m_streamIn  = in;
		m_streamOut = out;
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
						  switch(newLine)
					  	  {
							
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
}
