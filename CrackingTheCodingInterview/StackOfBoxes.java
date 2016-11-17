import java.util.*;

public class StackOfBoxes {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Integer boxCount = Integer.parseInt(in.nextLine());
		Box[] boxes = new Box[boxCount];
		for (int i = 0; i < boxCount; i++) {
			boxes[i] = new Box(in.nextLine().split(" "));
		}
		in.close();
		System.out.println("Height of the highest stack is: " + calculateHighestStack(boxes));
	}

	private static int calculateHighestStack(Box[] boxes) {
		int[] memo = new int[boxes.length];
		Arrays.fill(memo, -1);
		Arrays.sort(boxes, new Comparator<Box>() {
			@Override
			public int compare(Box b1, Box b2) {
				if (b1.getH() > b2.getH()) {
					return -1;
				} else if (b1.getH() < b2.getH()) {
					return 1;
				}
				return 0;
			}
			
		});
		return calculateMaxHeight(boxes, 0, memo);
	}

	private static int calculateMaxHeight(Box[] boxes, int index, int[] memo) {
		if (index == boxes.length) return 0;
		if (memo[index] != -1) return memo[index];
		
		int with = boxes[index].getH();
		for (int i = index+1; i < boxes.length; i++) {
			if (isSmaller(boxes[i], boxes[index])) {
				int newHeight = boxes[index].getH() + calculateMaxHeight(boxes, i, memo);
				with = Math.max(with,  newHeight);
			}
		}
		
		int without = calculateMaxHeight(boxes, index+1, memo);
		
		int max = Math.max(with, without);
		memo[index] = max;
		return max;
	}

	private static boolean isSmaller(Box box1, Box box2) {
		if (box1.getD() <= box2.getD() && box1.getW() <= box2.getW()) return true;
		return false;
	}
}

class Box {
	private int h, w, d;
	
	public Box(String[] dimensions) {
		h = Integer.parseInt(dimensions[0]);
		w = Integer.parseInt(dimensions[1]);
		d = Integer.parseInt(dimensions[2]);
	}
	
	public String toString() {
		return "h: " + h + " w: " + w + " d: " +  d;
	}

	public int getH() {
		return h;
	}

	public int getW() {
		return w;
	}

	public int getD() {
		return d;
	}
}