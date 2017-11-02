/**
 * Created on Nov 17, 2011
 *
 * Project: assignment3SortingPolygons 
 */
package application;

/**
 * AppDriver.java
 *
 * @author dwatson
 * @version 1.0
 * 
 * Class Definition: 
 */
public class AppDriverForName
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		if(args.length == 3)
		{	
			String s1 = args[0];
			String s2 = args[1];
			String s3 = args[2];
			
			PolygonSorterForName ps = new PolygonSorterForName(s1,s2,s3);
			ps.loadPolygonsToArray();
			ps.sortPolygons();
		}
		else
		{
			System.out.println("Entered the wrong arguments");
		}
	}
}
