package main;
import java.util.ArrayList;
import java.util.Arrays;


public class MatrixUtils {
	//mean on rows or a given column index
	public static float meanByRow(ArrayList<ArrayList<Integer> > matrix, int index){
		return getMean(getRowbyIndex(matrix,index));
	}
	//mean on columns or a given row index
	public static float meanByColumn(ArrayList<ArrayList<Integer> > matrix, int index){
		
		return getMean(getColbyIndex(matrix,index));
	}
	// mean of a sub-matrix
	public static float meanOfSubMatrix(ArrayList<ArrayList<Integer> > matrix){
		return 0;
	}
	
	public static void printArray(int[][]G) {
		for (int i = 0; i < G.length; i++) {
			System.out.println(Arrays.toString(G[i]));
		}

	}

	public static ArrayList<Integer> getRowbyIndex(ArrayList<ArrayList<Integer>> matrix, int index){
		return matrix.get(index);
	}
	public static ArrayList<Integer> getColbyIndex(ArrayList<ArrayList<Integer>> matrix, int index){
		ArrayList<Integer> col=  new ArrayList<Integer>();
		for (ArrayList<Integer> row:matrix) {
			col.add(row.get(index));
		}
		return null;
	}
	
	
	public static float getMean(ArrayList<Integer> array) {
		int len = array.size();
		float sum = 0;
		for (int e:array) {
			sum+=e;
		}
		return sum/len;
	}
	public static float getMean(int[] array) {
		int len =array.length;
		float sum = 0;
		for (int e:array) {
			sum+=e;
		}
		return sum/len;
	}
}

