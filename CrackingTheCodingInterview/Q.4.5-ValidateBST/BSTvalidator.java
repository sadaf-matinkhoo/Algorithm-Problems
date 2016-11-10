package validate.b.s.t;

public class BSTvalidator {
	private boolean isValid = true;
	
	public BSTvalidator(TreeNode root) {
		validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private void validate(TreeNode current, int min, int max) {
		if (current == null) return;
		if (current.getValue() < min || current.getValue() > max) {
			isValid = false;
			return;
		}
		TreeNode[] children = current.getChildren();
		TreeNode left = children[0];
		TreeNode right = children[1];
		if (left != null) {
			if (left.getValue() >= current.getValue()) {
				isValid = false;
				return;
			}
		}
		if (right != null) {
			if (right.getValue() < current.getValue()) {
				isValid = false;
				return;
			}
		}
		validate(left, min, current.getValue());
		if (isValid) validate(right, current.getValue(), max);
	}
	
	public String isValid() {
		return isValid ? "Valid" : "Invalid";
	}
}
