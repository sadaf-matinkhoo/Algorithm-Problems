import java.util.*;

public class MultiSearch {
	public static void main(String[] args) {
		String[] smallWords;
		Scanner in = new Scanner(System.in);
		int numWords = Integer.parseInt(in.nextLine());
		smallWords = new String[numWords];
		for (int i = 0; i < numWords; i++) 
			smallWords[i] = in.nextLine();
		String largeWord = in.nextLine();
		in.close();
		ArrayList<String> found = search(largeWord, smallWords);
		
		System.out.print("words found: ");
		for (String word : found) 
			System.out.print(word + "  ");
		System.out.println();
	}

	private static ArrayList<String> search(String largeWord, String[] smallWords) {
		Trie trie = new Trie();
		trie = buildSuffixTrie(largeWord);
		
		ArrayList<String> found = new ArrayList<String>();
		for (String word : smallWords) 
			if (isFoundInTrie(word, trie)) 
				found.add(word);
		return found;
	}

	private static boolean isFoundInTrie(String word, Trie trie) {
		Node current = trie.getRoot();
		for (char c : word.toCharArray()) {
			ArrayList<Node> children = current.getChildren();
			boolean foundChar = false;
			for (Node child : children) {
				if (child.getValue() == c) {
					foundChar = true;
					current = child;
				}
			}
			if (!foundChar) return false;
		}
		return true;
	}

	private static Trie buildSuffixTrie(String largeWord) {
		Trie trie = new Trie();
		for (int i = 0; i < largeWord.length(); i++)
			trie.insert(largeWord.substring(i));
		return trie;
	}

}


class Trie {
	private Node root;
	
	public Trie() {
		root = new Node();
	}
	
	public Node getRoot() {
		return root;
	}
	
	public void insert(String word) {
		Node current = root;
		for (char c : word.toCharArray()) {
			boolean foundChar = false;
			for (Node child : current.getChildren()) {
				if (child.getValue() == c) {
					current = child;
					foundChar = true;
				}
			}
			if (!foundChar) {
				Node newNode= new Node(c);
				current.getChildren().add(newNode);
				current = newNode;
			}
		}
		current.setLeaf();
	}
}

class Node {
	private char value;
	private ArrayList<Node> children;
	private boolean isLeaf;
	
	public Node() {
		children = new ArrayList<Node>();
	}
	
	public Node(char value) {
		this.value = value;
		children = new ArrayList<Node>();
	}
	
	public char getValue() {
		return value;
	}
	
	public ArrayList<Node> getChildren() {
		return children;
	}
	
	public boolean terminates() {
		return isLeaf;
	}
	
	public void setLeaf() {
		isLeaf = true;
	}
}