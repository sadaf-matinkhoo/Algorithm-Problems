package week.of.code.twentyfive;

import java.util.*;

public class AppendAndDelete {
	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		String s = in.nextLine();
		String t = in.nextLine();
		int k = Integer.parseInt(in.nextLine());
		in.close();
		DeleteAppend da = new DeleteAppend(s, t, k);
		System.out.println(da.isPossible());
	}
}

class DeleteAppend {
	private String s, t;
	private int k;
	
	DeleteAppend (String s, String t, int k) {
		this.s = s;
		this.t = t;
		this.k = k;
	}
	
	public String isPossible() {
		if (k >= s.length()+t.length()) return "Yes";
		int index = findDivergencePoint();
		int deletions = s.length() - index;
		int appends = t.length() - index;
		if (k < deletions + appends) return "No";
		if ((k - deletions - appends) % 2 == 1 ) return "No";
		return "Yes";
	}

	private int findDivergencePoint() {
		int i = 0;
		while (i < s.length() && i < t.length() && s.charAt(i) == t.charAt(i)) {
			i++;
		}
		return i;
	}
} 