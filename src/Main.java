import java.io.FileNotFoundException;


public class Main {
	
	
	public static void main(String[] args) throws FileNotFoundException {
	System.out.println("start");
	int[][]G=MatrixFactory.createMatrixFromFile();
	System.out.println("Matrix created");
	for (int i = 0; i < G.length; i++) {
	    for (int j = 0; j < G[i].length; j++) {
	        System.out.print(G[i][j] + "\t ");
	    }
	    System.out.println();
	}

	}

}
