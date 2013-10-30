package Assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;


public class Assignment4 
{
	public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException
	{		
		// Testing Values
		PrintWriter writer = new PrintWriter("input.txt", "UTF-8");
		Random gen = new Random();
		for(int i = 0; i < 1000; i += 1)
		{
			int temp = Math.abs(gen.nextInt(10));
			writer.println(temp);
		}
		writer.close();
		
		
		int sizeOfRandoms = 1000000;
		//File inputFile = new File(args[0]);
		File inputFile = new File("input.txt");
		LinkedList<Integer> randomLinkedList;
		Stopwatch timer = new Stopwatch();
		ArrayList<Integer> randomArrayList = BuildList(sizeOfRandoms);
		
		ArrayListSearch search1 = new ArrayListSearch(inputFile);
		timer.start();
		search1.SearchForElements(randomArrayList);
		timer.stop();
		System.out.println("ArrayList searching took " + timer.getElapsedTime());
		timer.reset();
		
		randomLinkedList = new LinkedList<Integer>(randomArrayList);
		LinkedListSearch search2 = new LinkedListSearch(inputFile);
		timer.start();
		search2.SearchForElements(randomLinkedList);
		timer.stop();
		System.out.println("LinkedList searching took " + timer.getElapsedTime());
		timer.reset();
		
		timer.start();
		Collections.sort(randomArrayList);
		timer.stop();
		System.out.println("ArrayList sorting took " + timer.getElapsedTime());
		timer.reset();
		
		timer.start();
		Collections.sort(randomLinkedList);
		timer.stop();
		System.out.println("LinkedList sorting took " + timer.getElapsedTime());
		timer.reset();
		
		timer.start();
		search1.InterpolationSearch(randomArrayList);
		timer.stop();
		System.out.println("ArrayList Interpol searching took " + timer.getElapsedTime());
		timer.reset();		
		
		timer.start();
		search2.InterpolationSearch(randomLinkedList);
		timer.stop();
		System.out.println("LinkedList Interpol searching took " + timer.getElapsedTime());
		timer.reset();
	}
	
	public static ArrayList<Integer> BuildList(int size)
	{
		ArrayList<Integer> randomList = new ArrayList<Integer>();
		randomList.ensureCapacity(size + 1);
		Random randomNumber = new Random();
		
		for(int i = 0; i < size; i += 1)
		{
			int temp = Math.abs(randomNumber.nextInt());
			randomList.add(temp);
		}
		return(randomList);
	}

	
}

