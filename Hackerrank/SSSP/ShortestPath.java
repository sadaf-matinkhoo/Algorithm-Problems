package BreadthFirst;

import java.util.HashMap;
import java.util.LinkedList;

// single source shortest path
public class ShortestPath {
	private Graph g;
	private int source;
	private HashMap<Integer, Integer> shortestDistances; 
	private boolean[] visited;
	
	public ShortestPath(Graph g, int source) {
		this.source = source;
		this.g = g;
		visited = new boolean[g.getSize()];
		shortestDistances = new HashMap<Integer, Integer>();
		LinkedList<Integer> queue = new LinkedList<Integer>();
		LinkedList<Integer> levels = new LinkedList<Integer>();
		queue.add(source);
		levels.add(0);
		visited[source] = true;
		while(!queue.isEmpty()) {
			int currentNode = queue.removeFirst();
			int level = levels.removeFirst() + 1;
			for(Integer neighbor : g.getAdjList().get(currentNode)) {
				if(!visited[neighbor]) {
					visited[neighbor] = true;
					queue.add(neighbor);
					levels.add(level);
					shortestDistances.put(neighbor, level*6);
				}
			}
		}
		
	}
	
	public void printShortestDistances(){
		for (int i = 0; i < g.getSize(); i++) {
			if (i != source) {
				int dist = shortestDistances.containsKey(i) ? shortestDistances.get(i) : -1;
				System.out.print(dist + " ");
			}
		}
		System.out.println();
	}
	
 }
