import java.util.*;

public class MajorityElement {
	public static void main(String[] args) {
		MajorityElement me = new MajorityElement();
		Scanner in = new Scanner(System.in);
		int numCases = Integer.parseInt(in.nextLine());
		for (int i = 0; i < numCases; i++) {
			int caseSize = Integer.parseInt(in.nextLine());
			String[] arr = in.nextLine().split(" ");
			int[] intArray = new int[caseSize];
			for (int j = 0; j < caseSize; j++) {
				intArray[j] = Integer.parseInt(arr[j]);
			}
			System.out.println("The majority element is " + me.findMajorityElement(intArray));
		}
		in.close();
	}
	
	private int findMajorityElement(int[] arr) {
		int result = -1;
		int count = 0, index = 0, size = 0;
		while (index < arr.length) {
			if (count == 0) {
				result = arr[index];
				count = 1;
				size = 1;
			} else if(result == arr[index]) {
				count++;
				size++;
			} else if (count > size/2) {
				size++;
			} else {
				count = 0;
				size = 0;
			}
			index++;
		}
		
		return isValid(arr,result) ? result : -1;
	}
	
	private boolean isValid(int[] arr, int num) {
		int count = 0;
		for (int n : arr) {
			if (n == num) count++;
		}
		return count > arr.length / 2;
	}
}
