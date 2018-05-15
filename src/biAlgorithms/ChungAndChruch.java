package biAlgorithms;

import java.util.ArrayList;

import main.BiAlgorithm;
import main.MatrixUtils;

public class ChungAndChruch implements BiAlgorithm{

	@Override
	public ArrayList<ArrayList<Integer>> execute() {
		
		return null;
	}

	private float RSij(ArrayList<ArrayList<Integer>> matrix, int i, int j) {
		int eij = matrix.get(i).get(j);
		float eIj = MatrixUtils.meanByColumn(matrix, j);
		float eiJ= MatrixUtils.meanByRow(matrix, i);
		float eIJ = MatrixUtils.meanOfSubMatrix(matrix);
		return eij-eIj-eiJ+eIJ;
	}
	
	private float HIJ(ArrayList<ArrayList<Integer>> matrix) {
		int nbRows = matrix.size();
		int nbCols = matrix.get(0).size();
		return 0;
	}
}
