import java.util.ArrayList;

public class EightQueens {
	public static void main(String[] args) {
		int boardSize = 8;
		ArrayList<ArrayList<Integer>> result = positionQueens(boardSize);
		for (ArrayList<Integer> positions : result) 
			System.out.println(positions);
		System.out.println(result.size() + " results found!");
	}

	private static ArrayList<ArrayList<Integer>> positionQueens(int boardSize) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> soFar = new ArrayList<Integer>();
		positionQueens(result, 0, boardSize, soFar);
		return result;
	}

	private static void positionQueens(ArrayList<ArrayList<Integer>> result, int row, int boardSize, ArrayList<Integer> soFar) {
		if (row == boardSize) {
			result.add(new ArrayList<Integer>(soFar));
			return;
		}
		
		for (int i = 0; i < boardSize; i++) {
			if (isValid(row, i, soFar)) {
				soFar.add(i);
				positionQueens(result, row + 1, boardSize, soFar);
				soFar.remove(soFar.size()-1);
			}
		} 
	}

	private static boolean isValid(int row, int col, ArrayList<Integer> soFar) {
		for (int i = 0; i < soFar.size(); i++) {
			if (col == soFar.get(i) || 
				col + row == i + soFar.get(i) ||
				col - row == soFar.get(i) - i) {
				return false;
			}
		}
		return true;
	}
}
