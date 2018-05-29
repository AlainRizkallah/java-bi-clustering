package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class MatrixFactory {
	

	
	public static List<LinkedList<Integer>> createMatrixListFromFile(String path) throws FileNotFoundException { 
		Scanner input = new Scanner (new File(path));
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
	
	public static int[][] createMatrixFromFile(String path) throws FileNotFoundException { 
		Scanner input = new Scanner (new File(path));
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
	public static int[][] createRandomMatrix()  {

		        int [] [] matrix = new int [100] [100];

		        for (int i=0; i<matrix.length; i++) {
		            for (int j=0; j<matrix[i].length; j++) {
		                matrix[i][j] = (int) (Math.random()*2);
		            }           
		        }       
		    return(matrix);
		
		
	}

}
