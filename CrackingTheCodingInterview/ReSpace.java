import java.util.*;

public class ReSpace {
	private HashSet<String> dictionary = new HashSet<String>();
	
	public static void main(String[] args) {
		ReSpace r = new ReSpace();
		Scanner in = new Scanner(System.in);
		for (String word : in.nextLine().split(" ")) {
			r.getDictionary().add(word);
		}
		String document = in.nextLine();
		in.close();
		ParsedDocument pd = r.getMinimumUnknownChars(document);
		System.out.println("The least #of unrecognized characters is " + pd.getInvalidCharacters());
		System.out.println("The parsed document is: " + pd.getParsedDocument());
	}
	
	private ParsedDocument getMinimumUnknownChars(String document) {
		HashMap<String, ParsedDocument> memo = new HashMap<String, ParsedDocument>();
		return getMinimumUnknownChars(document, 0, memo);
	}

	private ParsedDocument getMinimumUnknownChars(String document, int index, HashMap<String, ParsedDocument> memo) {
		if (index >= document.length()) return new ParsedDocument(0, "");
		if (memo.containsKey(document.substring(index))) return memo.get(document.substring(index));
		
		int minInvalids = Integer.MAX_VALUE;
		String bestParsed = "";
		String left = "";
		
		for (int i = index; i < document.length(); i++) {
			left += document.charAt(i);
			int invalids = dictionary.contains(left) ? 0 : left.length();
			if (invalids < minInvalids) {
				ParsedDocument right = getMinimumUnknownChars(document, i+1, memo);
				if (invalids + right.getInvalidCharacters() < minInvalids) {
					minInvalids = invalids + right.getInvalidCharacters();
					bestParsed = left + " " + right.getParsedDocument();
				}
			}
		}
		
		ParsedDocument result = new ParsedDocument(minInvalids, bestParsed);
		memo.put(document.substring(index), result);
		return result;
	}

	public HashSet<String> getDictionary() {
		return dictionary;
	}
}

class ParsedDocument {
	private int invalidCharacters;
	private String parsedDocument;
	
	public ParsedDocument(int invalidCharacters, String parsedDocument) {
		this.invalidCharacters = invalidCharacters;
		this.parsedDocument = parsedDocument;
	}
	
	public int getInvalidCharacters() {
		return invalidCharacters;
	}
	public void setInvalidCharacters(int invalidCharacters) {
		this.invalidCharacters = invalidCharacters;
	}
	public String getParsedDocument() {
		return parsedDocument;
	}
	public void setParsedDocument(String parsedDocument) {
		this.parsedDocument = parsedDocument;
	}
}