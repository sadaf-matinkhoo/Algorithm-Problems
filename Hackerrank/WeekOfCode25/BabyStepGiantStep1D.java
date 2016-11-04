package week.of.code.twentyfive;

import java.util.*;

public class BabyStepGiantStep1D {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numCases = Integer.parseInt(in.nextLine());
		for (int i = 0; i < numCases; i++) {
			String[] numbers = in.nextLine().split(" ");
			int[] nums = new int[3];
			for (int j = 0; j < 3; j++) {
				nums[j] = Integer.parseInt(numbers[j]);
			}
			Steps steps = new Steps(nums);
			System.out.println("minimum #of steps required: " + steps.getSteps1D());
		}
		in.close();
	}
}

class Steps {
	private int small, big;
	private int dest;
	
	Steps(int[] nums) {
		small = nums[0];
		big = nums[1];
		dest = nums[2];
	}
	
	public int getSteps1D() {
		int count = Integer.MAX_VALUE;
		
		// calculate #of steps of both taken in the same direction
		for (int i = 0; i*small < dest; i++) {
			if ((dest - i*small) % big == 0) {
				count = Math.min(count, i + (dest - i*small) / big);
			}
		}
		
		
		// calculate #of steps if small steps are in +
		// and big steps are in - direction
		int smallSteps = dest / small + 1;
		while (true) {
			if (smallSteps >= count) break;
			if ((smallSteps * small - dest) % big == 0) {
				count = Math.min(count, smallSteps + (smallSteps * small - dest) / big);
				break;
			}
			smallSteps++;
		}
		
		// calculate #of steps if small steps are in -
		// and big steps are in + direction
		int bigSteps = dest / big + 1;
		while (true) {
			if (bigSteps >= count) break;
			if ((bigSteps * big - dest) % small == 0) {
				count = Math.min(count, bigSteps + (bigSteps * big - dest) / small);
				break;
			}
			bigSteps++;
		}
		
		return count;
	}
}
