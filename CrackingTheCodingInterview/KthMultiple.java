import java.util.*;

public class KthMultiple {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numCases = Integer.parseInt(in.nextLine());
		for (int i = 0; i < numCases; i++) {
			int k = Integer.parseInt(in.nextLine());
			Multiple m = new Multiple(k);
			System.out.println(k + "'th multiple is " + m.getValue());
		}
		in.close();
	}
}


class Multiple {
	private int value;
	// lists records the multiples of 3,5, and 7 separately
	private Queue<Integer> threes, fives, sevens; 
	
	Multiple(int k) {
		threes = new LinkedList<Integer>();
		fives = new LinkedList<Integer>();
		sevens = new LinkedList<Integer>();
		threes.add(1);
		for (int i = 0; i < k; i++) {
			// read the first element in each list 
			int v3 = threes.size() > 0 ? threes.peek() : Integer.MAX_VALUE;
			int v5 = fives.size() > 0 ? fives.peek() : Integer.MAX_VALUE;
			int v7 = sevens.size() > 0 ? sevens.peek() : Integer.MAX_VALUE;
			
			// pick the smallest out of the three
			value = Math.min(v3,  Math.min(v5, v7));
			
			// if the smallest is from multiples of three, add multiples of it 
			// to all lists and remove it from the list it was picked from.
			if (value == v3) {
				threes.remove();
				threes.add(value*3);
				fives.add(value*5);
				
			// if the smallest is from multiples of five, add multiples of it 
			// to the last two lists and remove it from the list it was picked from.	
			} else if (value == v5) {
				fives.remove();
				fives.add(value*5);
				
			// if the smallest is from multiples of seven, add multiples of it 
			// to the last lists= and remove it from the list it was picked from.	
			} else if(value == v7) {
				sevens.remove();
			}
			sevens.add(value * 7);
		}
		
	}
	
	public int getValue() {
		return value;
	}
}
