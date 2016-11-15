import java.util.*;

public class PermutationWithDuplicates {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String word = in.nextLine();
		in.close();
		
		PermutationWithDuplicates pwd = new PermutationWithDuplicates();
		ArrayList<String> perms = pwd.findPerms(word);
		for (String perm : perms)
			System.out.println(perm);
	}
	
	private ArrayList<String> findPerms(String word) {
		HashMap<Character, Integer> charCounts = countChars(word);
		return findPerms(charCounts, word.length());
	}
	
	private HashMap<Character, Integer> countChars(String word) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			} else {
				map.put(c, 1);
			}
		}
		return map;
	}
	
	private ArrayList<String> findPerms(HashMap<Character, Integer> charCounts, int remaining) {
		ArrayList<String> result = new ArrayList<String>();;
		if (remaining == 0) {
			result.add("");
		} else {
			for (char c : charCounts.keySet()) {
				int charCount = charCounts.get(c);
				if (charCount > 0) {
					charCounts.put(c,  charCount-1);
					ArrayList<String> partialResult = findPerms(charCounts, remaining-1);
					for (String perm : partialResult) {
						result.add(c+perm);
					}
					charCounts.put(c, charCount);
				}
			}
		}
		return result;
	}
}
