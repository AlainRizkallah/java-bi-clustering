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
		biCluster = algo.execute(matrix);
	}
	public List<List<Integer>> getBiCluster(){
		return biCluster;
	}
	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
}
