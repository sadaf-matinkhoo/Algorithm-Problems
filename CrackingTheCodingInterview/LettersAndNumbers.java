import java.util.*;

public class LettersAndNumbers {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// assume array consists of A's and B's instead of letters and numbers
		String[] input = in.nextLine().split(" ");
		in.close();
		int[] result = findLongestSubarray(input);
		System.out.println("from " + result[0] + " to " + result[1]);
	}
	
	private static int[] findLongestSubarray(String[] arr) {
		int[] result = {0,0};
		
		int[] diffs = new int[arr.length];
		int countA = 0;
		HashMap<Integer, Integer> indices = new HashMap<Integer, Integer>();
		indices.put(0, -1);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("A")) {
				countA++;
			} 
			diffs[i] = 2 * countA - i - 1;
			if (!indices.containsKey(diffs[i])) {
				indices.put(diffs[i], i);
			}
		}
	
		int maxLength = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			int firstOccurence = indices.get(diffs[i]); 
			if (firstOccurence < i) {
				if (i - firstOccurence > maxLength) {
					maxLength = i - firstOccurence;
					result[0] = firstOccurence+1;
					result[1] = i;
				}
			}
		}
		
		
		return result;
	}
}
