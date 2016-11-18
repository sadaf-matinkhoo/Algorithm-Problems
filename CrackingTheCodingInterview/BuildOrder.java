import java.util.*;

public class BuildOrder {
	public static void main(String[] args) {
		HashMap<Integer, Integer> incomingCounts = new HashMap<Integer, Integer>();
		HashMap<Integer, ArrayList<Integer>> outgoings = new HashMap<Integer, ArrayList<Integer>>();
				
		Scanner in = new Scanner(System.in);
		int nodeCount = Integer.parseInt(in.nextLine());
		int edgeCount = Integer.parseInt(in.nextLine());
		for (int i = 0; i < edgeCount; i++) {
			String[] edge = in.nextLine().split(" ");
			int head = Integer.parseInt(edge[1]);
			int tail = Integer.parseInt(edge[0]);
			// add edge to outgoings
			ArrayList<Integer> dependents = null;
			if (outgoings.containsKey(head)) {
				dependents = outgoings.get(head);
			} else {
				dependents = new ArrayList<Integer>();
			}
			dependents.add(tail);
			outgoings.put(head, dependents);
			
			// add count to incomingCounts
			int count = 0;
			if (incomingCounts.containsKey(tail)) {
				count = incomingCounts.get(tail) + 1;
			} else {
				count = 1;
			}
			incomingCounts.put(tail, count);
		}
		in.close();
		
		ArrayList<Integer> buildOrder = findBuildOrder(nodeCount, incomingCounts, outgoings);
		if (buildOrder != null) {
			System.out.println(buildOrder);
		} else {
			System.out.println("Could not find a valid build order!");
		}
	}

	private static ArrayList<Integer> findBuildOrder(int nodeCount, HashMap<Integer, Integer> incomingCounts,
												HashMap<Integer, ArrayList<Integer>> outgoings) {
		ArrayList<Integer> buildOrder = new ArrayList<Integer>();
		LinkedList<Integer> noIncomings = findNoIncomings(nodeCount, incomingCounts);
		
		while(!noIncomings.isEmpty()) {
			int node = noIncomings.removeFirst();
			buildOrder.add(node);
			if (!outgoings.containsKey(node)) continue;
			for (int neighbor : outgoings.get(node)) {
				int newCount = incomingCounts.get(neighbor) - 1;
				if (newCount == 0)  noIncomings.add(neighbor);
				incomingCounts.put(neighbor, newCount);
			}
		}
		
		return buildOrder.size() == nodeCount ? buildOrder : null;
	}

	private static LinkedList<Integer> findNoIncomings(int nodeCount, HashMap<Integer, Integer> incomingCounts) {
		LinkedList<Integer> result = new LinkedList<Integer>();
		for (int i = 0; i < nodeCount; i++) {
			if (!incomingCounts.containsKey(i))
				result.add(i);
		}
		return result;
	}
}
