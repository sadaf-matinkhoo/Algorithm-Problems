import java.util.EmptyStackException;
import java.util.Stack;

public class QueueViaStack<T> {
	private Stack<T> add, remove;
	private int size;
	private T forPeeking;
	
	public QueueViaStack() {
		add = new Stack<T>();
		remove = new Stack<T>();
		size = 0;
	}
	
	public void add(T element) {
		size++;
		
		if (add.isEmpty()) transferStack(remove, add);
		add.push(element);

		// if this is the first element inserted into the queue
		if (forPeeking == null) forPeeking = element;
	}
	
	public T remove() throws EmptyStackException {
		if (this.isEmpty()) throw new EmptyStackException();
		
		size--;
		
		if (remove.isEmpty()) transferStack(add, remove);
		T removedElement = remove.pop();
		
		// update the element in the front
		forPeeking = remove.peek();
		
		return removedElement;
	}
	
	public T peek() throws EmptyStackException {
		if (this.isEmpty()) throw new EmptyStackException();
		return forPeeking;
	}
	
	private void transferStack(Stack<T> s1, Stack<T> s2) {
		while (!s1.isEmpty())
			s2.push(s1.pop());
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	public static void main(String[] args) {
		QueueViaStack<Integer> q = new QueueViaStack<Integer>();
		q.add(2);
		System.out.println(q.peek());
		q.add(3);
		System.out.println(q.peek());
		System.out.println(q.remove());
		System.out.println(q.peek());
	}
}
