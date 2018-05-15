package main;

import java.util.ArrayList;

public class BiCluster {

	private BiAlgorithm algo;
	private int[][] matrix;
	ArrayList<ArrayList<Integer>> biCluster;
	
	public BiCluster(int[][] matrix, BiAlgorithm algo) {
		this.algo = algo;
		this.matrix = matrix;
	}
	
	public void compute() {
		biCluster = algo.execute();
	}
	public ArrayList<ArrayList<Integer>> getBiCluster(){
		return biCluster;
	}
}
