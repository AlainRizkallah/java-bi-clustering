package biAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import main.BiAlgorithm;
import utils.ClusterUtils;
import utils.MatrixUtils;

public class ChungAndChruch implements BiAlgorithm{
	
	int [][] matrix;

	@Override
	public List<List<Integer>> execute(int[][] g, double delta) {
		MatrixUtils.printArraylist(g);
//		int[][] matrix=ClusterUtils.twoDArrayToListList(G);
		this.matrix = g;
		ArrayList<Integer> I = new ArrayList<Integer>();
		ArrayList<Integer> J = new ArrayList<Integer>();
		
		
		for (int i =0; i<matrix.length;i++){
			I.add(i);
		}
		for (int j =0; j<matrix[0].length;j++){
			J.add(j);
		}
		
		List<ArrayList<Integer>> removed = new ArrayList<ArrayList<Integer>>();

		removed = deletionPhase(I,J,delta);
		additionPhase(removed,I,J,delta);

		
		List<List<Integer>> cluster =ClusterUtils.createCluster(matrix,I,J);
		System.out.println("==========================   RESULTS    ===========================");
		System.out.println("Matrix: ");
		MatrixUtils.printArraylist(matrix);
		System.out.println("le cluster: (taille: "+cluster.size()+"x"+cluster.get(0).size()+")");
		System.out.println("Delta: "+delta);
		System.out.println("I: ");
		System.out.println(I);
		System.out.println("J: ");
		System.out.println(J);
		System.out.println("HIJ du bicluster: "+HIJ(I,J));
		MatrixUtils.printArraylist(cluster);
		

	
		return cluster;
	}
	

	private List<ArrayList<Integer>> deletionPhase (List<Integer> I,List<Integer> J,double delta ){
		System.out.println("==========================DELETION PHASE===========================");
		List<ArrayList<Integer>> removed = new ArrayList<ArrayList<Integer>>();
		removed.add(new ArrayList<Integer>());
		removed.add(new ArrayList<Integer>());
		double hij = HIJ(I,J);
		while(hij>delta) {
			System.out.println("HIJ du bicluster: "+hij);
			
				ArrayList<Double>D= new ArrayList<Double>();
				ArrayList<Double>E= new ArrayList<Double>();
				
				for(int i : I){
					D.add(d(i,I,J));
				}
					
				for(int j :J){
					E.add(e(j,I,J));
				}
				double dmax=Collections.max(D);
				double emax=Collections.max(E);

				if(dmax>emax){
//					System.out.println("Index max D:  "+D.indexOf(dmax));
//					System.out.println(dmax);
					removed.get(0).add(I.get(D.indexOf(dmax)));
					I.remove(D.indexOf(dmax));					
				}	
				else{
					removed.get(1).add(J.get(E.indexOf(emax)));
//					System.out.println("Index max E: "+E.indexOf(emax));
//					System.out.println(emax);
					J.remove(E.indexOf(emax));
				}	
				hij = HIJ(I,J);
			}
		
		return(removed);
	}
	
	private void additionPhase(List<ArrayList<Integer>> removed,List<Integer> I,List<Integer> J, double delta) {
		System.out.println("==========================ADDITION PHASE===========================");
		ArrayList<Integer> Iprime = new ArrayList<Integer>(I);
		ArrayList<Integer> Jprime = new ArrayList<Integer>(J);
		
//		Iprime.addAll(I);
//		Jprime.addAll(J);
		double hij = HIJ(Iprime,Jprime);
		while(hij<delta) {
			I = new ArrayList<Integer>(I);
			J = new ArrayList<Integer>(J);
			
//			I.addAll(Iprime);
//			J.addAll(Jprime);

			
			System.out.println("HIJ du bicluster: "+hij);
		
			ArrayList<Double>D= new ArrayList<Double>();
			ArrayList<Double>E= new ArrayList<Double>();
			if (I.size()==matrix.length && J.size()==matrix[0].length) break;
			for(int i : removed.get(0)) 
				D.add(d(i,I,J));
			for(int j : removed.get(1))
				E.add(e(j,I,J)); 
				
			if(E.size()==0){
				double dmax=Collections.max(D);
				Iprime.add(removed.get(0).get(D.indexOf(dmax)));
				removed.get(0).remove((D.indexOf(dmax)));
			}
			else if(D.size()==0){
				double emax=Collections.max(E);
				Jprime.add(removed.get(1).get(E.indexOf(emax)));
				removed.get(1).remove(E.indexOf(emax));
			}
			else{
				double dmax=Collections.max(D);
				double emax=Collections.max(E);
				if(dmax<emax){
					Iprime.add(removed.get(0).get(D.indexOf(dmax)));
					removed.get(0).remove((D.indexOf(dmax)));
				}
					
				else{
					Jprime.add(removed.get(1).get(E.indexOf(emax)));
					removed.get(1).remove(E.indexOf(emax));
				}
			}	
			
			hij = HIJ(Iprime,Jprime);

		}
		
	}


	private double RSij(int i, int j, List<Integer> I,List<Integer> J) {
		int eij = matrix[i][j];
	double eIj = MatrixUtils.meanByColumn(matrix, j,I);

	double eiJ= MatrixUtils.meanByRow(matrix, i,J);
	double eIJ = MatrixUtils.meanOfSubMatrix(matrix,I,J);
		return eij-eIj-eiJ+eIJ;
	}
	
	private double HIJ(List<Integer> I,List<Integer> J) {
		if (I.size()==0||J.size()==0) return 0;
		
	double sum=0;
		for (int i: I) {
			for (int j: J) {
			double RS = RSij(i,j,I,J);
				sum+=Math.pow(RS, 2);
			}
		}
		return sum/(I.size()*J.size());
	}
	private double d(int i,List<Integer> I,List<Integer> J){
	double S=0;
		for (int j : J) {
			S=S+Math.pow(RSij(i,j,I,J),2);
		}
			
		return S/J.size();
	}
	private double e(int j, List<Integer> I,List<Integer> J){
	double S=0;
		for (int i:I)
			S=S+Math.pow(RSij(i,j,I,J),2);	
		return S/I.size();
		
	}
	
}
