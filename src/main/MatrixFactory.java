package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class MatrixFactory {
	

	
	public static List<LinkedList<Integer>> createMatrixListFromFile() throws FileNotFoundException { 
		Scanner input = new Scanner (new File("src/data2.txt"));
		// pre-read in the number of rows/columns
		List<LinkedList<Integer>> matrix = new ArrayList<LinkedList<Integer>>();

		while(input.hasNextLine()){
			
			LinkedList<Integer> row = new LinkedList<Integer>();
		    Scanner colReader = new Scanner(input.nextLine());
		    while(colReader.hasNextInt())
		    {
		    	row.add(colReader.nextInt());
	    		
		    }
		    colReader.close();
		    matrix.add(row);
		}
		input.close();
		
		return matrix;
}
	
	public static int[][] createMatrixFromFile() throws FileNotFoundException { 
		Scanner input = new Scanner (new File("src/data2.txt"));
		// pre-read in the number of rows/columns
		List<LinkedList<Integer>> matrix = new ArrayList<LinkedList<Integer>>();

		while(input.hasNextLine()){
			
			LinkedList<Integer> row = new LinkedList<Integer>();
		    Scanner colReader = new Scanner(input.nextLine());
		    while(colReader.hasNextInt())
		    {
		    	row.add(colReader.nextInt());
	    		
		    }
		    colReader.close();
		    matrix.add(row);
		}
		input.close();
		int rows = matrix.size();
		int cols = matrix.get(0).size();
		int[][] res = new int[rows][cols];
		for (int i =0;i<rows;i++) {
			res[i] = matrix.get(i).stream().mapToInt(a->a).toArray();
		}

		
		
		return res;
}


}
