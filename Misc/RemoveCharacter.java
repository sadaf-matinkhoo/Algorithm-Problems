import java.util.*;

public class RemoveCharacter {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String word = in.nextLine();
		char c = in.nextLine().charAt(0);
		in.close();
		
		RemoveCharacter rc = new RemoveCharacter();
		String modifiedWord = rc.removeChar(word, c); 
		System.out.println(modifiedWord);
	}
	
	private String removeChar(String word, char c) {
		int placeHolder = 0, runner = 0;
		char[] chars = word.toCharArray();
		while (runner < word.length()) {
			if (chars[runner] != c) {
				chars[placeHolder] = chars[runner];
				placeHolder++;
			} 
			runner++;
		}
		char[] newChars = new char[placeHolder];
		System.arraycopy(chars, 0, newChars, 0, placeHolder);
		return new String(newChars);
	}
}
