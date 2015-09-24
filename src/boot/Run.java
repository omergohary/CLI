package boot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import controller.MyController;
import model.MyModel;
import view.MyView;

public class Run 
{

	public static void main(String[] args) throws IOException 
	{
		System.out.println("****************************************************************");
		System.out.println(" (1) dir														");
		System.out.println(" 			ex. dir ./bin										");
		System.out.println(" (2) generate3dMaze <maze name> <dimX> <dimY> <dimZ>			");
		System.out.println(" 			ex. generate3dMaze OmerMaze 3 3 3					");
		System.out.println(" (3) display3dMaze <maze name>                      		    ");
		System.out.println(" 			ex. generate3dMaze OmerMaze                    	    ");
		System.out.println(" (4) displayCrossSection <maze name> <dim> <index>  		    ");
		System.out.println(" 			ex. displayCrossSection OmerMaze Y 2           	    ");
		System.out.println(" (5) saveMaze <maze name> <outfile name>           	        	");
		System.out.println(" 			ex. saveMaze OmerMaze omerMaze.txt             	    ");
		System.out.println(" (6) loadMaze <infile name> <new maze name>         		    ");
		System.out.println(" 			ex. loadMaze omerMaze.txt omerMaze2            	    ");
		System.out.println(" (7) mazeSize <maze name>            						    ");
		System.out.println(" 			ex. mazeSize OmerMaze             			 	 	");
		System.out.println(" (8) fileSize <maze name>            				 		    ");
		System.out.println(" 			ex. fileSize OmerMaze             				 	");
		System.out.println(" (9) solve <maze name> <algirthm> (BFS/AirDistance/Manhattan)   ");
		System.out.println(" 			ex. solve OmerMaze BFS            				    ");
		System.out.println(" (10) displaySolution <maze name>                               ");
		System.out.println(" 			ex. solve OmerMaze               				  	");
		System.out.println(" (11) exit													    ");
		System.out.println("****************************************************************");


		
		/********** View **********/
		BufferedReader inFile = new BufferedReader(new InputStreamReader(System.in));
	    PrintWriter outFile   = new PrintWriter(System.out, true);
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
