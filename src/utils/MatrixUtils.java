package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MatrixUtils {
	// mean on rows or a given column index
	public static float meanByRow(List<List<Integer>> matrix, int index) {
		return getMean(getRowbyIndex(matrix, index));
	}

	// mean on columns or a given row index
	public static float meanByColumn(List<List<Integer>> matrix, int index) {
		return getMean(getColbyIndex(matrix, index));
	}

	// mean of a sub-matrix
	public static float meanOfSubMatrix(List<List<Integer>> matrix) {
		int len = matrix.size();
		float sum = 0;
		for (List<Integer> ligne : matrix) {
			sum += getMean(ligne);
		}
		return sum / len;
	}
	
	public static float meanByRow(int[][] matrix,int rowId, List<Integer> J) {
		float sum = 0;
		for (Integer j : J) {
			sum+=matrix[rowId][j];
		}
		return sum/J.size();
	}
	
	public static float meanByColumn(int[][] matrix,int colId, List<Integer> I) {
		float sum = 0;
		for (Integer i : I) {
			sum+=matrix[i][colId];
		}
		return sum/I.size();
	}
	
	public static float meanOfSubMatrix(int[][] matrix,List<Integer> I, List<Integer> J) {
		float sum = 0;
		for (Integer colId : J) {
			for (Integer rowId : J) {
				sum+=matrix[rowId][colId];
			}
		}
		return sum/(I.size()*J.size());
	}


	public static void printArraylist(List<List<Integer>> G) {
		for (List<Integer> g : G) {
			System.out.println(g);
		}

	}
	public static void printArraylist(int[][] G) {
		for (int[] g : G) {
			System.out.println(Arrays.toString(g));
		}

	}

	public static List<Integer> getRowbyIndex(List<List<Integer>> matrix,
			int index) {
		return matrix.get(index);
	}

	public static List<Integer> getColbyIndex(List<List<Integer>> matrix,
			int index) {
		List<Integer> col = new ArrayList<Integer>();
		for (List<Integer> row : matrix) {
			col.add(row.get(index));
		}
		return col;
	}

	public static void removeColbyIndex(List<List<Integer>> matrix, int index) {
		for (int i = 0; i < matrix.size(); i++)
			matrix.get(i).remove(index);
	}

	public static float getMean(List<Integer> array) {
		if (array == null)
			return 0;
		int len = array.size();
		if (len == 0)
			return 0;
		float sum = 0;
		for (int e : array) {
			sum += e;
		}
		return sum / len;
	}

	public static float getMean(int[] array) {
		int len = array.length;
		if (len == 0)
			return 0;
		float sum = 0;
		for (int e : array) {
			sum += e;
		}
		return sum / len;
	}


}
