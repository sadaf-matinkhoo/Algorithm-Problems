import java.util.Stack;

public class SortStack {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(3);
		stack.push(1);
		stack.push(5);
		stack.push(2);
		stack.push(4);
		stack.push(8);
		stack.push(5);
		SortStack ss = new SortStack();
		ss.sort(stack);
		System.out.println(stack);
	}
	
	private void sort(Stack<Integer> stack) {
		if (stack.size() <= 1) return;
		Integer topElement = stack.pop();
		sort(stack);
		insertInOrder(stack, topElement);
	}

	private void insertInOrder(Stack<Integer> stack, Integer topElement) {
		Stack<Integer> temp = new Stack<Integer>();
		while (!stack.isEmpty() && topElement > stack.peek())
			temp.push(stack.pop());
		stack.push(topElement);
		while(!temp.isEmpty())
			stack.push(temp.pop());
	}
}
