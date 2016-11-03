import java.util.*;

public class WordDistance {
	private static HashMap<String, ArrayList<Integer>> wordIndices;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] file = in.nextLine().split(" ");
		buildMap(file);
		while(in.hasNext()) {
			String[] words = in.nextLine().split(" ");
			System.out.println(findDistance(words));
		}
		in.close();
	}
	
	// create a map of each word to its occurrence indices
	private static void buildMap(String[] file) {
		wordIndices = new HashMap<String, ArrayList<Integer>>();
		for (int i = 0; i < file.length; i++) {
			ArrayList<Integer> indices;
			if (!wordIndices.containsKey(file[i])) {
				indices = new ArrayList<Integer>();
			} else {
				indices = wordIndices.get(file[i]);
			}
			indices.add(i);
			wordIndices.put(file[i], indices);
		}
	}
	
	// find the closest pair of integers between to lists of integers
	// given the lists are in increasing order
	private static int findDistance(String[] words) {
		int dist = Integer.MAX_VALUE;
		ArrayList<Integer> list1 = wordIndices.get(words[0]);
		ArrayList<Integer> list2 = wordIndices.get(words[1]);
		int index1 = 0, index2 = 0, localDist;
		while(index1 < list1.size() && index2 < list2.size()) {
			localDist = list1.get(index1) - list2.get(index2);
			dist = Math.min(dist, Math.abs(localDist));
			if(localDist < 0) {
				index1++;
			} else {
				index2++;
			}
		}
		return dist == Integer.MAX_VALUE ? -1:dist-1;
	}
	
}
