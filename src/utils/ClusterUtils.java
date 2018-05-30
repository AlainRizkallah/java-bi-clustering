package utils;

import java.util.ArrayList;
import java.util.List;

public class ClusterUtils {
	
	public static List<List<Integer>> createCluster(int[][] matrix, List<Integer> I,List<Integer> J) {
		List<List<Integer>> cluster = new ArrayList<>();
		for(int i = 0 ; i<I.size();i++){
			cluster.add(new ArrayList<Integer>());
		}
		for (int k=0;k<I.size();k++){
			for (int j: J){
			cluster.get(k).add(matrix[I.get(k)][j]);
			}
		}
		return cluster;
	}
	
	public static List<List<Integer>> twoDArrayToListList(int[][] twoDArray) {
		List<List<Integer>> list = new ArrayList<>();
		for (int[] array : twoDArray) {
			List<Integer> sublist = new ArrayList<>();
			for (int x : array)
				sublist.add(x);
			list.add(sublist);
		}
		return list;
	}

}
