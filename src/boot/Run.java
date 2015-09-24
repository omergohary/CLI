package boot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import controller.MyController;
import model.MyModel;
import view.MyView;

public class Run 
{

	public static void main(String[] args) throws IOException 
	{
		/********** View **********/
		BufferedReader inFile = new BufferedReader(new InputStreamReader(System.in));
	    PrintWriter outFile   = new PrintWriter(new BufferedWriter(new FileWriter("out.txt")));
		MyView view   	  	  = new MyView(inFile, outFile);
		
		/********** Model **********/
		MyModel model 		 = new MyModel();
		
		/********* Control *********/
		MyController control = new MyController(view, model);
		
		view.setController(control);
		model.setController(control);
		
		view.start();
	}

}
