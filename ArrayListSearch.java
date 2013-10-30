package Assignment4;

import java.io.File;
import java.util.ArrayList;

public class ArrayListSearch extends Reader{
	
	private ArrayList<Integer> inputList;
	
	public ArrayListSearch(File inputFile)
	{
		inputList = new ArrayList<Integer>();
		inputList = ReadInputs(inputFile);
	}
	
	public int GetInputListSize()
	{
		return(inputList.size());
	}
	
	public void SearchForElements(ArrayList<Integer> randomList)
	{
		for(int i = 0; i < inputList.size(); i += 1)
		{
			int temp = randomList.indexOf(inputList.get(i));
			if(temp < 0){System.out.println("Integer not in Array");}
			else{System.out.println(i);}
		}
	}
	
	public void InterpolationSearch(ArrayList<Integer> randomList)
	{
		for(int i = 0; i < inputList.size(); i += 1)
		{	  
			// Returns index of toFind in sortedArray, or -1 if not found
			  int low = 0;
			  int high = randomList.size() - 1;
			  int mid;
			 
			  while (randomList.get(low) <= inputList.get(i) && randomList.get(high) >= inputList.get(i)) 
			  {
			  /*
				  mid = (int) (low +
			         ((inputList.get(i) - randomList.get(low)) * (high - low)) /
			         (randomList.get(high) - randomList.get(low)));  //out of range is possible  here
			  */
			   long numerator1 = inputList.get(i) - randomList.get(low);
			   long numerator2 = high - low;
			   long numerator = numerator1 * numerator2;
			   long denominator = randomList.get(high) - randomList.get(low);
			   mid = (int) (numerator / denominator);
			  
			   
			   
			   if (randomList.get(mid) < inputList.get(i))
			    low = mid + 1;
			   else if (randomList.get(mid) > inputList.get(i))
			    
			    high = mid - 1;
			   else
			    System.out.println("Index: " + mid);
			  }
			 
			  if (randomList.get(low) == inputList.get(i))
				  System.out.println("Index: " + low);
			  else
				  System.out.println("Integer not in Array"); // Not found
		}
	}

}
