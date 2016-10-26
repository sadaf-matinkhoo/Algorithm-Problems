package BreadthFirst;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
	private HashMap<Integer, ArrayList<Integer>> adjList;
	private int size;
	
	public Graph(int size) {
		adjList = new HashMap<Integer, ArrayList<Integer>>();
		this.size = size; 
	}
	
	public void addEdge(int node1, int node2) {
		updateAdjList(node1,node2);
		updateAdjList(node2,node1);
	}
	
	private void updateAdjList(int node1, int node2) {
		if (adjList.containsKey(node1)) {
			adjList.get(node1).add(node2);
		} else {
			ArrayList<Integer> neighbors = new ArrayList<Integer>();
			neighbors.add(node2);
			adjList.put(node1, neighbors);
		}
	}
	
	public int getSize() {
		return size;
	}
	
	
	public HashMap<Integer,ArrayList<Integer>> getAdjList() {
		return adjList;
	}
}
