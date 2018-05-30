package main;

import java.util.List;

public class BiCluster {

	private BiAlgorithm algo;
	private int[][] matrix;
	
	List<List<Integer>> biCluster;
	
	public BiCluster(int[][] matrix, BiAlgorithm algo) {
		this.algo = algo;
		this.matrix = matrix;
	}
	
	public void compute() {
		biCluster = algo.execute(matrix, 300);
	}
	public List<List<Integer>> getBiCluster(){
		return biCluster;
	}
	
}
