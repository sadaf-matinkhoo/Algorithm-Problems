package paths.with.sum;

import java.util.ArrayList;

public class PathCounter {
	private int pathCount = 0;
	private int goalSum;
	private ArrayList<ArrayList<String>> paths;
	
	public PathCounter(TreeNode root, int sum) {
		goalSum = sum;
		paths = new ArrayList<ArrayList<String>>();
		
		ArrayList<String> path = new ArrayList<String>();
		pathCount = countPaths(root, sum, path);
	}
	
	private int countPaths(TreeNode node, int sum, ArrayList<String> path) {
		if (node == null) return 0;
		
		path.add(node.name);
		int count = 0;
		
		if (node.getValue() == sum) {
			count = 1;
			paths.add(path);
		}
		
		TreeNode left = node.getChildren()[0];
		TreeNode right = node.getChildren()[1];
		
		// paths that start at this node and sum to specified value
		ArrayList<String> leftPath = new ArrayList<String>(path);
		count += countPaths(left, sum - node.getValue(), leftPath);
		
		ArrayList<String> rightPath = new ArrayList<String>(path);
		count += countPaths(right, sum - node.getValue(), rightPath);
		
		// paths that start at the children of this node and sum to specified value
		count += countPaths(left, goalSum, new ArrayList<String>());
		count += countPaths(right, goalSum, new ArrayList<String>());
		
		return count;
	}
	
	public int getCount() {
		return pathCount;
	}
	
	public ArrayList<ArrayList<String>> getPaths() {
		return paths;
	}
}
