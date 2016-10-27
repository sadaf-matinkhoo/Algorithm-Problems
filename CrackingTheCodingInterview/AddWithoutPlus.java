import java.util.*;

public class AddWithoutPlus {
	public static void main(String[] args) {
		AddWithoutPlus awp = new AddWithoutPlus();
		Scanner in = new Scanner(System.in);
		int num1 = Integer.parseInt(in.nextLine());
		int num2 = Integer.parseInt(in.nextLine()); 
		in.close();
		System.out.println(awp.add(num1,num2));
	}
	
	private int add(int num1, int num2) {
		int carryOver = 0, sum = 0;
		while (true) {
			sum = num1 ^ num2;
			carryOver = (num1 & num2) << 1;
			if (carryOver == 0) break;
			num1 = sum;
			num2 = carryOver;
		}
		return sum;
	}
}
