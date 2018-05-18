package main;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class MatrixFactory {
	
	public static int[][] createMatrixFromFile() throws FileNotFoundException { 
					Scanner input = new Scanner (new File("src/data.txt"));
					// pre-read in the number of rows/columns
					int rows = 0;
					int columns = 0;
					boolean mark=true;
					while(input.hasNextLine()){
						
					    ++rows;
					    Scanner colReader = new Scanner(input.nextLine());
					    while(colReader.hasNextInt())
					    {
					    	if(mark)
					    		 ++columns;
					    	colReader.nextInt();
					       
					    }
					    mark=false;
					    colReader.close();
					}
					System.out.println(rows);
					System.out.println(columns);
					int[][] G = new int[rows][columns];

					input.close();
					
					// read in the data
					input = new Scanner(new File("src/data.txt"));
					for(int i = 0; i < rows; ++i)
					{
					    for(int j = 0; j < columns; ++j)
					    {
					        if(input.hasNextInt())
					        {
					            G[i][j] = input.nextInt();
					        }
					    }
					}
					input.close();
					return G;
		} 
	
	public static List<LinkedList<Integer>> createMatrixListFromFile() throws FileNotFoundException { 
		Scanner input = new Scanner (new File("src/data.txt"));
		// pre-read in the number of rows/columns
		List<LinkedList<Integer>> matrix = new ArrayList<LinkedList<Integer>>();
		boolean mark=true;
		while(input.hasNextLine()){
			
			LinkedList<Integer> row = new LinkedList<Integer>();
		    Scanner colReader = new Scanner(input.nextLine());
		    while(colReader.hasNextInt())
		    {
		    	if(mark)
		    		row.add(colReader.nextInt());
		       
		    }
		    colReader.close();
		    mark=false;
		    matrix.add(row);
		}

		input.close();
		
		
		return matrix;
}


}
