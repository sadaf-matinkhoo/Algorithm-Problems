import java.util.*;

public class CountOfTwos {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = Integer.parseInt(in.nextLine());
		in.close();
		CountOfTwos cts = new CountOfTwos();
		System.out.println(cts.countTwos(num));
	}
	
	private int countTwos(int num) {
		int count = 0;
		int pow = 1;
		while (num/pow > 0) {
			count += (num / pow / 10) * pow;
			pow *= 10;
			int remainder = num - num / pow * pow;
			count += Math.max(0, Math.min(remainder - 2 * pow / 10 + 1, pow / 10));
		}
		return count;
	}
}
