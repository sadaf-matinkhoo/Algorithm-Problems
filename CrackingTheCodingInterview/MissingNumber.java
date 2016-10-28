import java.util.ArrayList;
import java.util.Scanner;


public class MissingNumber {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int arrSize = Integer.parseInt(in.nextLine());
		int missingNum = Integer.parseInt(in.nextLine());
		in.close();
		MissingNumber mn = new MissingNumber();
		ArrayList<Integer> arr = mn.initializeArray(arrSize, missingNum);
		System.out.println("Missing number is: " + mn.findMissingNumber(arr, 0));
	}
	
	private ArrayList<Integer> initializeArray(int size, int missing) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i <= size; i++) {
			if (i >= missing) {
				arr.add(i+1);
			} else {
				arr.add(i);
			}
		}
		return arr;
	}
	
	private int findMissingNumber(ArrayList<Integer> arr, int col) {
		// base case
		if (col >= 32) return 0;
		
		ArrayList<Integer> odds = new ArrayList<Integer>();
		ArrayList<Integer> evens = new ArrayList<Integer>();
		for (Integer num : arr) {
			if (fetchBit(num, col) == 0) {
				evens.add(num);
			} else {
				odds.add(num);
			}
		}
		
		int firstPart = 0;
		if (evens.size() <= odds.size()) {
			firstPart = findMissingNumber(evens, col+1);
			return (firstPart << 1) | 0;
		} else {
			firstPart = findMissingNumber(odds, col+1);
			return (firstPart << 1) | 1;
		}
	}
	
	private int fetchBit(int num, int index) {
		int mask = 1 << index;
		return (num & mask) == 0 ? 0 : 1;
	}
}
