package Assignment4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Reader {
	
	static BufferedReader readInput = null;
	static ArrayList<Integer> inputIntegers;
	
	public ArrayList<Integer> ReadInputs(File inputFile)
	{
		try 
		{
			inputIntegers = new ArrayList<Integer>();
		    readInput = new BufferedReader(new FileReader(inputFile));
		    String text = null;

		    while ((text = readInput.readLine()) != null) 
		    {
		        inputIntegers.add(Integer.parseInt(text));
		    }
		    
		} 
		catch (FileNotFoundException e) 
			{e.printStackTrace();} 
		catch (IOException e) 
			{e.printStackTrace();} 
		finally 
		{
		    try 
		    {
		        if (readInput != null) {
		            readInput.close();
		        }
		    } catch (IOException e) {/* What do I do with this exception?*/    }
		}
		return(inputIntegers);
	}
}
