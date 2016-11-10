package paths.with.sum;

import java.util.ArrayList;

public class PathsWithSum {
	public static void main(String[] args) {
		TreeNode zero = new TreeNode(1, "0");
		TreeNode one = new TreeNode(3, "1");
		TreeNode two = new TreeNode(2, "2");
		TreeNode three = new TreeNode(6, "3");
		TreeNode four = new TreeNode(11, "4");
		TreeNode five = new TreeNode(7, "5");
		TreeNode six = new TreeNode(4, "6");
		TreeNode seven = new TreeNode(-1, "7");
		TreeNode eight = new TreeNode(2, "8");
		TreeNode nine = new TreeNode(1, "9");
		zero.getChildren()[0] = one;
		zero.getChildren()[1] = two;
		one.getChildren()[0] = three;
		one.getChildren()[1] = four;
		two.getChildren()[0] = five;
		two.getChildren()[1] = six;
		three.getChildren()[0] = seven;
		six.getChildren()[0] = eight;
		seven.getChildren()[1] = nine;
		PathCounter pc = new PathCounter(zero, 10);
		System.out.println(pc.getCount() + " paths were found.");
		for (ArrayList<String> path : pc.getPaths())
			System.out.println(path);
	}
}
