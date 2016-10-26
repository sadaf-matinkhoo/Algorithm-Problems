package BreadthFirst;

import java.util.Scanner;

public class BreadthFirstProblem {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numCases = in.nextInt();
		in.nextLine();
		for (int i = 0; i < numCases; i++) {
			String[] line = in.nextLine().split(" ");
			int numNodes = Integer.parseInt(line[0]);
			int numEdges = Integer.parseInt(line[1]);
			Graph g = new Graph(numNodes);
			for (int j = 0; j < numEdges; j++) {
				String[] edge = in.nextLine().split(" ");
				int node1 = Integer.parseInt(edge[0])-1;
				int node2 = Integer.parseInt(edge[1])-1;
				g.addEdge(node1, node2);
			}
			int source = in.nextInt()-1;
			in.nextLine();
			ShortestPath sp = new ShortestPath(g, source);
			sp.printShortestDistances();
		}
		in.close();
	}
}
