package main;
import java.io.File;
import java.io.FileNotFoundException;
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
					return G;
		} 


}
