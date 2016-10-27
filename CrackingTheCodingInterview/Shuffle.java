import java.util.*;

public class Shuffle {
	public static void main(String[] args) {
		// initialize the deck
		int[] deck = new int[52];
		for (int i = 0; i < 52; i++) {
			deck[i] = i;
		}
		Shuffle s = new Shuffle();
		s.shuffleDeck(deck);
		for (int n : deck) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	private void shuffleDeck(int[] deck) {
		Random rand = new Random();
		// Knuth's shuffling
		// swap each card at index i with a card randomly 
		// selected from the set of cards seen so far
		for (int i = 1; i < deck.length; i++) {
			int randomIndex = rand.nextInt(i+1);
			swap(deck, i, randomIndex);
		}
	}
	
	private void swap(int[] deck, int index1, int index2) {
		int temp = deck[index1];
		deck[index1] = deck[index2];
		deck[index2] = temp;
	}
}
