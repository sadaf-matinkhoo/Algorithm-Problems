package validate.b.s.t;

public class TreeNode {
	private int value;
	private TreeNode[] children;
	
	public TreeNode() {
		children = new TreeNode[2];
	}
	
	public TreeNode(int value) {
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
