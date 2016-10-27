import java.util.*;

public class RandomSet {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		int m = Integer.parseInt(in.nextLine());
		in.close();
		// initialize array with size n
		int[] arr = new int[n];
		for (int i = 0; i< n; i++) {
			arr[i] = i;
		}
		RandomSet rs = new RandomSet();
		int[] set = rs.selectRandomSet(arr,m);
		for (int num : set) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
	private int[] selectRandomSet(int[] arr, int m) {
		int[] set = new int[m];
		// initialize the set with the first m elements of array
		for (int i = 0; i < m; i++) {
			set[i] = arr[i];
		}
		Random rand = new Random();
		for (int i = m; i < arr.length; i++) {
			int randIndex = rand.nextInt(i+1);
			if(randIndex < m) set[randIndex] = arr[i];
		}
		return set;
	}
}
