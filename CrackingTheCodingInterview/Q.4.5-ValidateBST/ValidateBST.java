package validate.b.s.t;

public class ValidateBST {
	public static void main(String[] args) {
		TreeNode zero = new TreeNode(16);
		TreeNode one = new TreeNode(5);
		TreeNode two = new TreeNode(15);
		TreeNode three = new TreeNode(1);
		TreeNode four = new TreeNode(9);
		TreeNode five = new TreeNode(20);
		zero.getChildren()[0] = one;
		zero.getChildren()[1] = two;
		one.getChildren()[0] = three;
		one.getChildren()[1] = four;
		two.getChildren()[1] = five;
		BSTvalidator bv = new BSTvalidator(zero);
		System.out.println(bv.isValid());
	}
}
