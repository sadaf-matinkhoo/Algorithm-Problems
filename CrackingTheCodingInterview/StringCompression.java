public class StringCompression {
	public static void main(String[] args) {
		String word = "aabbbcc";
		System.out.println(compress(word));
	}
	
	private static String compress(String word) {
		StringBuilder compressed = new StringBuilder();
		String lowerCase = word.toLowerCase();
		for (int i = 0; i < word.length(); i++) {
			compressed.append(lowerCase.charAt(i));
			int j = i, count = 0;
			while (j < word.length() && lowerCase.charAt(i) == lowerCase.charAt(j)) {
				count++;
				j++;
			}
			compressed.append(count);
			if (compressed.length() >= word.length()) return word;
			i = j-1;
		}
		return compressed.toString();
	}
}
