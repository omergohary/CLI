package view;

import java.io.BufferedReader;
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
	
	
	/********************** MEMBERS **********************/
	
	/** Streams - in and out **/
	BufferedReader m_streamIn;
	PrintWriter    m_streamOut;
}
