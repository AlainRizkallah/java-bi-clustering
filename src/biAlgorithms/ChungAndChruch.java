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
		List<List<Integer>> M=MatrixUtils.twoDArrayToListList(G);
		
		ArrayList<Integer> I = new ArrayList<Integer>();
		ArrayList<Integer> J = new ArrayList<Integer>();
		for (int i =0; i<G.length;i++){
			I.add(i);
		}
		for (int j =0; j<G[0].length;j++){
			J.add(j);
		}
		
//		System.out.println(bicluster);
		List<ArrayList<Integer>> removed = new ArrayList<ArrayList<Integer>>();
		delta = 1f;
		removed = deletionPhase(bicluster,I,J,delta);
		additionPhase(bicluster,removed,I,J,delta,M);
		
		List<List<Integer>> cluster = createCluster(bicluster,I,J);
	System.out.println("HIJ du bicluster: "+HIJ(bicluster,I,J));
	System.out.println("le bicluster: (taille: "+bicluster.size()+"x"+bicluster.get(0).size()+")");
	System.out.println("Matrix: ");
	MatrixUtils.printArraylist(bicluster);
	System.out.println();
	MatrixUtils.printArraylist(cluster);
	
		return bicluster;
	}
	

	private List<ArrayList<Integer>> deletionPhase (List<List<Integer>> bicluster , List<Integer> I,List<Integer> J,float delta ){
		System.out.println("==========================DELETION PHASE===========================");
		List<ArrayList<Integer>> removed = new ArrayList<ArrayList<Integer>>();
		removed.add(new ArrayList<Integer>());
		removed.add(new ArrayList<Integer>());

		while(HIJ(bicluster,I,J)>delta) {
			System.out.println("HIJ du bicluster: "+HIJ(bicluster,I,J));
		//System.out.println("le bicluster: (taille: "+bicluster.size()+"x"+bicluster.get(0).size()+")");
		//		MatrixUtils.printArraylist(bicluster);
			
				ArrayList<Float>D= new ArrayList<Float>();
				ArrayList<Float>E= new ArrayList<Float>();
				
				for(int i : I){
					D.add(d(bicluster,i,I,J));
				}
					
				for(int j :J){
					E.add(e(bicluster,j,I,J));
				}
				float dmax=Collections.max(D);
				float emax=Collections.max(E);
				if(dmax>emax){
					removed.get(0).add(I.get(D.indexOf(dmax)));
					I.remove(D.indexOf(dmax));					
				}	
				else{
					removed.get(1).add(J.get(E.indexOf(emax)));
					J.remove(E.indexOf(emax));
				}				
			}
		return(removed);
	}
	
	private void additionPhase(List<List<Integer>> bicluster, List<ArrayList<Integer>> removed,List<Integer> I,List<Integer> J, float delta, List<List<Integer>> M) {
		System.out.println("==========================ADDITION PHASE===========================");
		while(HIJ(bicluster,I,J)<delta) {
			System.out.println("HIJ du bicluster: "+HIJ(bicluster,I,J));
			//System.out.println("le bicluster: (taille: "+bicluster.size()+"x"+bicluster.get(0).size()+")");
			//		MatrixUtils.printArraylist(bicluster);
			
			ArrayList<Float>D= new ArrayList<Float>();
			ArrayList<Float>E= new ArrayList<Float>();
			if (I.size()==bicluster.size() && J.size()==bicluster.get(0).size()) break;
			for(int i : removed.get(0)) 
				D.add(d(M,i,I,J));
			for(int j : removed.get(1))
				E.add(e(M,j,I,J)); 
				
			float dmax=Collections.max(D);
			float emax=Collections.max(E);
			if(dmax<emax){
				I.add(removed.get(0).get(D.indexOf(dmax)));
				removed.get(0).remove((D.indexOf(dmax)));
			}
				
			else{
				J.add(removed.get(1).get(E.indexOf(emax)));
				removed.get(1).remove(E.indexOf(emax));
			}	
		}
		
	}

	private List<List<Integer>> createCluster(List<List<Integer>> bicluster, List<Integer> I,List<Integer> J) {
		List<List<Integer>> cluster = new ArrayList<>();
		for(int i = 0 ; i<I.size();i++){
			cluster.add(new ArrayList<Integer>());
		}
		for (int k=0;k<I.size();k++){
			for (int j: J){
			cluster.get(k).add(bicluster.get(I.get(k)).get(j));
			}
		}
		return cluster;
	}
	private float RSij(List<List<Integer>> matrix, int i, int j, List<Integer> I,List<Integer> J) {
		int eij = matrix.get(i).get(j);
		float eIj = MatrixUtils.meanByColumn(matrix, j,I);

		float eiJ= MatrixUtils.meanByRow(matrix, i,J);
		float eIJ = MatrixUtils.meanOfSubMatrix(matrix,I,J);
		return eij-eIj-eiJ+eIJ;
	}
	
	private float HIJ(List<List<Integer>> matrix,List<Integer> I,List<Integer> J) {
		if (I.size()==0||J.size()==0) return 0;
		
		float sum=0;
		for (int i: I) {
			for (int j: J) {
				float RS = RSij(matrix,i,j,I,J);
				sum+=(RS*RS);
			}
		}
		return sum/(I.size()*J.size());
	}
	private float d(List<List<Integer>> matrix, int i,List<Integer> I,List<Integer> J){
		float S=0;
		for (int j : J)
			S=S+RSij(matrix,i,j,I,J);
		return S/J.size();
	}
	private float e(List<List<Integer>> matrix, int j, List<Integer> I,List<Integer> J){
		float S=0;
		for (int i:I)
			S=S+RSij(matrix,i,j,I,J);	
		return S/I.size();
		
	}
	
}
