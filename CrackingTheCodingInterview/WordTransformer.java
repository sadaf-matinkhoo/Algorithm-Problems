import java.util.*;

public class WordTransformer {
	private HashSet<String> dictionary;
	public final char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
							  'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 
							  'u', 'v', 'w', 'x', 'y', 'z'};
	
	public WordTransformer() {
		dictionary = new HashSet<String>();
	}
	
	public static void main(String[] args) {
		WordTransformer wt = new WordTransformer();
		Scanner in = new Scanner(System.in);
		String[] allowedWords = in.nextLine().split(" ");
		for (String word : allowedWords) 
			wt.getDictionary().add(word);
		String word1 = in.nextLine();
		String word2 = in.nextLine();
		in.close();
		ArrayList<String> transformation = wt.transform(word1, word2);
		for (String word : transformation)
			System.out.print(word + " ");
		System.out.println();
	}
	
	private ArrayList<String> transform(String word1, String word2) {
		HashSet<String> seenSoFar = new HashSet<String>();
		ArrayList<String> path = transfromRecursive(word1, word2, seenSoFar);
		if (path.size() > 0) path.add(0, word1);
		return path;
	}
	
	private ArrayList<String> transfromRecursive(String word1, String word2, HashSet<String> seenSoFar) {
		ArrayList<String> path = new ArrayList<String>();
		if (word1.equals(word2)) {
			path.add(word2);
			return path;
		}
		seenSoFar.add(word1);
		for (int i = 0; i < word1.length(); i++) {
			// get a list of next-step words by changing the character at index i
			ArrayList<String> newWords = changeCharAtIndex(word1, i, seenSoFar);
			
			for (String newWord : newWords) {
				seenSoFar.add(newWord);
				path = transfromRecursive(newWord, word2, seenSoFar);
				if (path.size() > 0) {
					if (!newWord.equals(word2))
						path.add(0, newWord);
					return path;
				}
				seenSoFar.remove(newWord);
			}
		}
		return path;
	}

	// get a list of valid words (words that are in the dictionary and 
	// not yet seen in the current path) that are different from the original
	// word only in the specified character index
	private ArrayList<String> changeCharAtIndex(String word, int index, HashSet<String> seenSoFar) {
		ArrayList<String> newWords = new ArrayList<String>();
		for (char c : alphabet) {
			String newWord = word.substring(0, index) + c + word.substring(index+1);
			if (!seenSoFar.contains(newWord) && dictionary.contains(newWord))
				newWords.add(newWord);
		}
		return newWords;
	}

	public HashSet<String> getDictionary() {
		return dictionary;
	}
}
