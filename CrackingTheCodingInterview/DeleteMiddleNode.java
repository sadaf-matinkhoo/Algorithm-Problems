
public class DeleteMiddleNode {
	public static void main(String[] args) {
		ListNode<Integer> head = new ListNode<Integer>(0);
		ListNode<Integer> one = new ListNode<Integer>(1);
		ListNode<Integer> two = new ListNode<Integer>(2);
		ListNode<Integer> three = new ListNode<Integer>(3);
		head.setNext(one);
		one.setNext(two);
		two.setNext(three);
		
		ListNode<Integer> current = head;
		deleteNode(two);
		current = head;
		while (current != null) {
			System.out.println(current.getValue() + " ");
			current = current.getNext();
		}
	}

	private static void deleteNode(ListNode<Integer> node) {
		if (node == null) throw new NullPointerException();
		if(node.getNext() == null) {
			System.out.println("Cannot delete the tail!");
			return;
		}
		
		ListNode<Integer> next = node.getNext();
		node.setValue(next.getValue());
		node.setNext(next.getNext());
	}
	
	
}