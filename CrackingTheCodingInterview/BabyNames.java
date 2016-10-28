import java.util.*;

public class BabyNames {
	public static void main(String[] args) {
		// read the input
		// create a map of each name to its frequency
		// create a 2-D string array of name frequencies
		Scanner in = new Scanner(System.in);
		int numFreq = Integer.parseInt(in.nextLine());
		int numEqual = Integer.parseInt(in.nextLine());
		HashMap<String,Integer> frequencies = new HashMap<String, Integer>();
		for (int i = 0; i < numFreq; i++) {
			String[] line = in.nextLine().split(" ");
			frequencies.put(line[0], Integer.parseInt(line[1]));
		}
		String[][] equivalencies = new String[numEqual][2];
		for (int i = 0; i < numEqual; i++) {
			equivalencies[i] = in.nextLine().split(" ");
		}
		in.close();	
		HashMap<String, ArrayList<String>> equivalents = computeEquivalentNames(equivalencies);
		System.out.println(equivalents);
		updateFrequencies(frequencies, equivalents);
		System.out.println(frequencies);
	}
	
	private static HashMap<String, ArrayList<String>> computeEquivalentNames(String[][] equivalencies) {
		HashMap<String, ArrayList<String>> result = new HashMap<String, ArrayList<String>>();
		HashMap<String, String> roots = new HashMap<String, String>();
		for (int i = 0; i < equivalencies.length; i++) {
			String s1 = equivalencies[i][0];
			String s2 = equivalencies[i][1];
			if (!roots.containsKey(s1) && !roots.containsKey(s2)) {
				roots.put(s2, s1);
				roots.put(s1, s1);
				ArrayList<String> list = new ArrayList<String>();
				list.add(s2);
				result.put(s1, list);
			} else if (roots.containsKey(s1) && !roots.containsKey(s2)) {
				roots.put(s2, roots.get(s1));
				result.get(roots.get(s1)).add(s2);
			} else if (roots.containsKey(s2) && !roots.containsKey(s1)) {
				roots.put(s1, roots.get(s2));
				result.get(roots.get(s2)).add(s1);
			} else {
				ArrayList<String> list1, list2;
				String root1, root2;
				if (result.get(s1).size() < result.get(s2).size()) {
					list1 = result.get(s1);
					list2 = result.get(s2);
					root1 = s1;
					root2 = s2;
				} else {
					list1 = result.get(s2);
					list2 = result.get(s1);
					root1 = s2;
					root2 = s1;
				}
				for (String name: list1) {
					roots.put(name, root2);
					list2.add(name);
				}
				result.remove(root1);
			}
		}
		
		return result;
	}
	
	private static void updateFrequencies(HashMap<String, Integer> freq, HashMap<String, ArrayList<String>> equivalents) {
		for (String name : equivalents.keySet()) {
			int count = freq.containsKey(name) ? freq.get(name) : 0;
			for (String equivalentName : equivalents.get(name)) {
				if (freq.containsKey(equivalentName)) {
					count += freq.get(equivalentName);
					freq.remove(equivalentName);
				}
			}
			freq.put(name, count);
		}
	}
}
