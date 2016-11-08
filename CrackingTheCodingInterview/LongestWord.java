import java.util.*;

public class LongestWord {
	private HashSet<String> wordsSet;
	private String[] wordsArray;
	
	public LongestWord(int wordsNum) {
		wordsSet = new HashSet<String>(wordsNum);
		wordsArray = new String[wordsNum];
	}

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		 int wordsNum = Integer.parseInt(in.nextLine());
		 LongestWord lw = new LongestWord(wordsNum);
		 for (int i = 0; i < wordsNum; i++) {
			String newWord = in.nextLine(); 
			lw.getWordsSet().add(newWord);
			lw.getWordsArray()[i] = newWord;
		 }
		 in.close();
		 System.out.println(" The longest word made of other words is: " + lw.findLongestCombinationWord());
	}

	private String findLongestCombinationWord() {
		// sort the words array according to word length in descending order
		Arrays.sort(wordsArray, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() < s2.length()) {
					return 1;
				} else if (s1.length() > s2.length()) {
					return -1;
				} 
				return 0;
			}
		});
		HashSet<String> combinationWords = new HashSet<String>();
		for (String word : wordsArray) {
			System.out.println("Checking the word: " + word);
			if (isCombination(word, 0, combinationWords)) return word;
		}
		return null;
	}
	
	private boolean isCombination(String word, int index, HashSet<String> combinationWords) {
		if (index >= word.length()) return false;
		String left = "";
		for (int i = index; i < word.length(); i++) {
			left += word.charAt(i);
			if (wordsSet.contains(left) || combinationWords.contains(left)) {
				String right = word.substring(i+1);
				if (wordsSet.contains(right) || combinationWords.contains(right)) {
					return true;
				} else if (isCombination(word, i+1, combinationWords)) {
					combinationWords.add(word);
					return true;
				}
			}
		}
		return false;
	}

	public String[] getWordsArray() {
		return wordsArray;
	}

	public HashSet<String> getWordsSet() {
		return wordsSet;
	}
}
