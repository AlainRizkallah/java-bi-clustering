package biAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import main.BiAlgorithm;
import main.BiCluster;
import main.MatrixUtils;

public class ChungAndChruch implements BiAlgorithm{

	@Override
	public List<List<Integer>> execute(int[][] G, float delta) {
		MatrixUtils.printArray(G);
		
	
		
		List<List<Integer>> bicluster=MatrixUtils.twoDArrayToListList(G);
//		System.out.println(bicluster);
		
	while(HIJ(bicluster)>3f) {
		System.out.println("HIJ du bicluster: "+HIJ(bicluster));
	//System.out.println("le bicluster: (taille: "+bicluster.size()+"x"+bicluster.get(0).size()+")");
	//		MatrixUtils.printArraylist(bicluster);
		
			ArrayList<Float>D= new ArrayList<Float>();
			ArrayList<Float>E= new ArrayList<Float>();
			
			for(int i=0;i<bicluster.size();i++) 
				D.add(d(bicluster,i));
			for(int j=0;j<bicluster.get(0).size();j++)
				E.add(e(bicluster,j)); 
				
			float dmax=Collections.max(D);
			float emax=Collections.max(E);
			if(dmax>emax) 
				bicluster.remove(D.indexOf(dmax));
			else
				MatrixUtils.removeColbyIndex(bicluster, E.indexOf(emax));
			
		}
	System.out.println("HIJ du bicluster: "+HIJ(bicluster));
	System.out.println("le bicluster: (taille: "+bicluster.size()+"x"+bicluster.get(0).size()+")");
	MatrixUtils.printArraylist(bicluster);
	
		return bicluster;
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
	private float d(List<List<Integer>> matrix, int i){
		int Jlen=matrix.get(i).size();
		float S=0;
		for (int j=0;j<Jlen;j++)
			S=S+RSij(matrix,i,j);
		return S/Jlen;
	}
	private float e(List<List<Integer>> matrix, int j){
		int Ilen=matrix.size();
		float S=0;
		for (int i=0;i<Ilen;i++)
			S=S+RSij(matrix,i,j);	
		return S/Ilen;
		
	}
	
}
