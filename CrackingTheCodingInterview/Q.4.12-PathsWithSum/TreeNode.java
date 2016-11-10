package paths.with.sum;

public class TreeNode {
	private int value;
	public String name;
	private TreeNode[] children;
	
	public TreeNode() {
		children = new TreeNode[2];
	}
	
	public TreeNode(int value, String name) {
		this.name = name;
		this.value = value;
		children = new TreeNode[2];
	}
	
	public void addLeftChild(TreeNode left) {
		children[0] = left;
	}
	
	public void addRightChild(TreeNode right) {
		children[1] = right;
	}
	
	public TreeNode[] getChildren() {
		return children;
	}
	
	public int getValue() {
		return value;
	}
}
