package main;
import java.io.FileNotFoundException;


public class Main {
	
	
	public static void main(String[] args) throws FileNotFoundException {
	System.out.println("start");
	int[][]G=MatrixFactory.createMatrixFromFile();
	System.out.println("Matrix created");
	MatrixUtils.printArray(G);

	}

}
