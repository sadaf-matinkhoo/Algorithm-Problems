import java.util.*;

public class BooleanEvaluation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String exp = in.nextLine();
		boolean val = Boolean.parseBoolean(in.nextLine());
		in.close();
		
		System.out.println(countWays(exp, val, 0, exp.length()-1));
	}

	private static int countWays(String exp, boolean val, int start, int end) {
		if (start == end) {
			if (val) return exp.charAt(start) == '1' ? 1 : 0;
			return exp.charAt(start) == '0' ? 1 : 0;
		}
		
		int count = 0;
		for (int i = start+1; i < end; i+= 2) {
			int leftFalse = countWays(exp, false, start, i-1);
			int leftTrue = countWays(exp, true, start, i-1);
			int rightFalse = countWays(exp, false, i+1, end);
			int rightTrue = countWays(exp, true, i+1, end);
			
			int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);
			int totalTrue = 0;
			char operator = exp.charAt(i);
			if (operator == '&') totalTrue = leftTrue * rightTrue;
			if (operator == '|') totalTrue = leftTrue*rightTrue + leftFalse*rightTrue+leftTrue*rightFalse;
			if (operator == '^') totalTrue = leftTrue*rightFalse + leftFalse*rightTrue;
			
			int ways = val ? totalTrue : total - totalTrue;
			count += ways;
		}
		
		return count;
	}
}
