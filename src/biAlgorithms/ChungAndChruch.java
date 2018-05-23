package biAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import main.BiAlgorithm;
import main.BiCluster;
import main.MatrixUtils;

public class ChungAndChruch implements BiAlgorithm{

	@Override
	public List<List<Integer>> execute(int[][] G) {
		MatrixUtils.printArray(G);
	
		return null;
	}

	private float RSij(List<List<Integer>> matrix, int i, int j) {
		int eij = matrix.get(i).get(j);
		float eIj = MatrixUtils.meanByColumn(matrix, j);
		float eiJ= MatrixUtils.meanByRow(matrix, i);
		float eIJ = MatrixUtils.meanOfSubMatrix(matrix);
		return eij-eIj-eiJ+eIJ;
	}
	
	private float HIJ(List<List<Integer>> matrix) {
		int I = matrix.size();
		int J = matrix.get(0).size();
		if (I==0||J==0) return 0;
		
		float sum=0;
		for (int i=0;i<I;i++) {
			for (int j=0;j<J;j++) {
				float RS = RSij(matrix,i,j);
				sum+=(RS*RS);
			}
		}
		return sum/(I*J);
	}
	
}
