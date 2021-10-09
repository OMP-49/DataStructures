/**
 * 
 */
package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Om
 *
 */
public class Graph {
	private int vertices;
	private LinkedList<Integer> adj[];
	
	/** Constructor to create a graph of v vertices
	 * 
	 * @param v
	 */
	public Graph(int v) {
		super();
		vertices = v;
		adj = new LinkedList[v];
		for(int i=0; i<v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
				
	}
	
	/** Function to add an edge from u to v
	 * 
	 * @param u
	 * @param v
	 */
	
	public void addEdge(int u, int v) {
		adj[u].add(v);
	}
	
	/** Function to print BFS traversal of a graph
	 * 
	 * @param sourceVertex
	 */
	 
	public void printBFS(int sourceVertex) {
		boolean visited[] = new boolean[vertices]; 
		for(int i=0;i<vertices;i++) {
			visited[i]= false;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(sourceVertex);
		visited[sourceVertex] = true;
		while(!q.isEmpty()) {
			int currentVertex = q.poll();
			System.out.print(currentVertex + " ");
			for(int vertex : adj[currentVertex]) {
				if(!visited[vertex]) {
					visited[vertex] = true;
					q.add(vertex);
				}
			}
		}
		
	}
	

}
