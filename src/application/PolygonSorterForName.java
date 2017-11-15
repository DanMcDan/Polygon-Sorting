/**
 * Created on Nov 17, 2011
 *
 * Project: assignment3SortingPolygons 
 */
package application;

import shapes.*;
import sorting.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.*;

/**
 * PolygonSorter.java
 *
 * @author dwatson
 * @version 1.0
 * 
 * Class Definition: 
 */
public class PolygonSorterForName
{
	//Attributes
	private Polygon []			polygonArray;
	private char				compareType;
	private char 				sortType;
	private String				fileName;
	private Scanner			 	scn;
	private int					count;
	private long startTime = System.currentTimeMillis();
	
	
	private int NUMBERDOTS = 40;
	private int count2 = 0;
	

	/**
	 * Public constructor for creating a PolygonSorterForName object
	 * @param arg1 Comes from the user and be either the -f[filepath] or -t[v||h||a] or -s[m||s||i||z||q||b]
	 * @param arg2 Comes from the user and be either the -f[filepath] or -t[v||h||a] or -s[m||s||i||z||q||b]
	 * @param arg3 Comes from the user and be either the -f[filepath] or -t[v||h||a] or -s[m||s||i||z||q||b]
	 */
	public PolygonSorterForName(String arg1, String arg2, String arg3)
	{
		arg1 = arg1.toLowerCase();
		arg2 = arg2.toLowerCase();
		arg3 = arg3.toLowerCase();
		
		if(arg1.charAt(1) == 'f') fileName = arg1.substring(2);
		else if(arg2.charAt(1) == 'f')fileName = arg2.substring(2);
		else fileName = arg3.substring(2);
		
		
		
		if(arg1.charAt(1) == 't') compareType = arg1.charAt(2);
		else if(arg2.charAt(1) == 't') compareType = arg2.charAt(2);
		else compareType = arg3.charAt(2);
		
		
		
		if(arg1.charAt(1) == 's') sortType = arg1.charAt(2);
		else if(arg2.charAt(1) == 's') sortType = arg2.charAt(2);
		else sortType = arg3.charAt(2);
		 
		System.out.println(fileName+" "+compareType+" "+sortType);
	}
	
	/**
	 * Reads the input file, loading up the polygon array with the information
	 */
	public void loadPolygonsToArray()
	{
		try
		{
			scn = new Scanner(new File("res/"+fileName));
		}
		catch (FileNotFoundException e) {e.printStackTrace();}
		
		scn.useDelimiter(" ");
		
		String s = scn.next();
		count = Integer.parseInt(s);
		polygonArray = new Polygon[count];
		
		int dots = 0;
		int dot = count / NUMBERDOTS;
		
		for(int i = 0; i < count; i++)
		{
			
			
			count2++;
			if(count2 == dot)
			{
				StringBuilder loading = new StringBuilder(24 + NUMBERDOTS);
				
				loading
					.append("\rLoading: ")
					.append(String.format("[%3.0f%%] ", (double) dots / (double) NUMBERDOTS * 100))
					.append("[");
				
				for(int j = 0; j < dots ; j++)
				{
					loading.append("#");
				}
				
				for(int j = dots; j < NUMBERDOTS; j++)
				{
					loading.append(" ");
				}
				
				long eta = (count - i) * (System.currentTimeMillis() - startTime) / i;
				
				loading
					.append("] ")
					.append(String.format("ETA: %2ds", TimeUnit.MILLISECONDS.toSeconds(eta)));
				
				
				System.out.print(loading);
				count2 = 0;
				dots++;
			}
			
			
			String className = scn.next();
			double height = Double.parseDouble(scn.next());
			double width = Double.parseDouble(scn.next());
			
			Polygon o = null;
			
			switch(className) {
			case "Cone":
				o = new Cone(height, width, compareType);
				break;
				
			case "Cylinder":
				o = new Cylinder(height, width, compareType);
				break;
				
			case "OctagonalPrism":
				o = new OctagonalPrism(height, width, compareType);
				break;
				
			case "PentagonalPrism":
				o = new PentagonalPrism(height, width, compareType);
				break;

			case "Pyramid":
				o = new Pyramid(height, width, compareType);
				break;
				
			case "SquarePrism":
				o = new SquarePrism(height, width, compareType);
				break;
				
			case "TriangularPrism":
				o = new TriangularPrism(height, width, compareType);
				break;
			}
			
			polygonArray[i] = o;
		}
		scn.close();	
	}
	
	
	/**
	 * Picks a sorting algorithm to use based on the user input
	 */
	public void sortPolygons()
	{
		long start, stop;
		
		System.out.println("\nStarting sort...... ");
		start = System.currentTimeMillis();
		
		if(sortType == 'b')BubbleSort.sort(polygonArray);
		if(sortType == 's')SelectionSort.sort(polygonArray);
		if(sortType == 'i')InsertionSort.sort(polygonArray);
		if(sortType == 'm')MergeSort.sort(polygonArray);
		if(sortType == 'q')QuickSort.sort(polygonArray);
		if(sortType == 'z')HeapSort.sort(polygonArray);
		
		stop = System.currentTimeMillis();
		System.out.println("Done!");

		for(int i = 0; i < count; i = i + 1000)
		{
			System.out.println(i+1 + "st:  " + polygonArray[i]);
		}
		System.out.println("Last element: " + polygonArray[count-1]);
		System.out.println("\nTime = "+(stop - start));
	}
}
