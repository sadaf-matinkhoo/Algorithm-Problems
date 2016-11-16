import java.util.ArrayList;

public class Parens {
	public static void main(String[] args) {
		int n = 3;
		ArrayList<String> parens = findParens(n);
		for (String combo : parens) {
			System.out.println(combo);
		}
	}
	
	private static ArrayList<String> findParens(int n) {
		ArrayList<String> parens = new ArrayList<String>();
		findParens(parens, n-1, 1, "(");
		return parens;
	}

	private static void findParens(ArrayList<String> parens, int remainingOpen, int sum, String soFar) {
		if (remainingOpen == 0) {
			StringBuilder sb = new StringBuilder(soFar);
			for (int i =0; i < sum; i++)
				sb.append(")");
			parens.add(sb.toString());
			return;
		}
		findParens(parens, remainingOpen - 1, sum + 1, soFar + "(");
		if (sum > 0)
			findParens(parens, remainingOpen, sum-1, soFar + ")");
	}
	
	
}
