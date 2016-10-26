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
		queue.add(source);
		visited[source] = true;
		int dist = 1;
		while(!queue.isEmpty()) {
			int currentNode = queue.removeFirst();
			for(Integer neighbor : g.getAdjList().get(currentNode)) {
				if(!visited[neighbor]) {
					visited[neighbor] = true;
					queue.add(neighbor);
					shortestDistances.put(neighbor, dist*6);
				}
			}
			dist++;
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
