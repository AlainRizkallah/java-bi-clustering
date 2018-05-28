package main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MatrixUtils {
	//mean on rows or a given column index
	public static float meanByRow(List<List<Integer> > matrix, int index){
		return getMean(getRowbyIndex(matrix,index));
	}
	//mean on columns or a given row index
	public static float meanByColumn(List<List<Integer> > matrix, int index){
		return getMean(getColbyIndex(matrix,index));
	}
	// mean of a sub-matrix
	public static float meanOfSubMatrix(List<List<Integer> > matrix){
		int len = matrix.size();
		float sum = 0;
		for (List<Integer> ligne : matrix) {
			sum+= getMean(ligne);
		}
		return sum/len;
	}
	
	public static void printArray(int[][]G) {
		for (int i = 0; i < G.length; i++) {
			System.out.println(Arrays.toString(G[i]));
		}

	}

	public static List<Integer> getRowbyIndex(List<List<Integer>> matrix, int index){
		return matrix.get(index);
	}
	public static ArrayList<Integer> getColbyIndex(List<List<Integer>> matrix, int index){
		ArrayList<Integer> col=  new ArrayList<Integer>();
		for (List<Integer> row:matrix) {
			col.add(row.get(index));
		}
		return col;
	}
	
	
	public static float getMean(List<Integer> array) {
		if (array==null) return 0;
		int len = array.size();
		if (len==0) return 0;
		float sum = 0;
		for (int e:array) {
			sum+=e;
		}
		return sum/len;
	}
	public static float getMean(int[] array) {
		int len =array.length;
		if (len==0) return 0;
		float sum = 0;
		for (int e:array) {
			sum+=e;
		}
		return sum/len;
	}
	
	public static List<List<Integer>> twoDArrayToListList(int[][] twoDArray) {
		List<List<Integer>> list = new ArrayList<>();
	    for (int[] array : twoDArray) {
	    	List<Integer>sublist= new ArrayList<>();
	        for(int x : array)
	        	sublist.add(x);
	        list.add(sublist);
	    }
	    return list;
	}

}

