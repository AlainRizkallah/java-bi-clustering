package main;
import java.io.FileNotFoundException;

import biAlgorithms.ChungAndChruch;


public class Main {
	
	
	public static void main(String[] args) throws FileNotFoundException {
	System.out.println("start");
	int[][]G=MatrixFactory.createMatrixFromFile();
	System.out.println("Matrix created");
	//MatrixUtils.printArray(G);
	
	BiCluster Bicluster = new BiCluster(G, new ChungAndChruch());
	Bicluster.compute();

	}

}
