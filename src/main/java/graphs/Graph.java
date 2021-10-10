/**
 * 
 */
package graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
	@SuppressWarnings("unchecked")
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
	
	/** Function to print DFS traversal of a graph
	 * 
	 */
	public void printDFS() {
		boolean visited[] = new boolean[vertices]; 
		for(int i=0;i<vertices;i++) {
			visited[i]= false;
		}
		Stack<Integer> s = new Stack<Integer>();
		
		for(int i=0;i<vertices;i++) {
			if(!visited[i]) {
				s.add(i);
				visited[i]= true;
				while(!s.empty()) {
					int currentVertex = s.pop();
					System.out.print(currentVertex + " ");
					for(int vertex: adj[currentVertex]) {
						if(!visited[vertex]) {
							visited[vertex] = true;
							s.add(vertex);
						}
						
					}
				}
			}
		}
	}
	
	/** Function to print topological sort of a graph
	 * 
	 */
	public void topologicalSort() {
		int inDegree[] = new int[vertices];
		for(int i=0;i<vertices;i++) {
			inDegree[i]= 0;
		}
		for(int i=0;i<vertices;i++) {
			for(int v: adj[i]) {
				inDegree[v]++;
			}
		}
		
		boolean isSortComplete = false;
		while(!isSortComplete) {
			for(int i=0;i<vertices;i++) {
				if(inDegree[i] == 0) {
					inDegree[i]= -1;
					System.out.println(i + " ");
					topologicalSorUtil(adj[i], inDegree);
				}
			}
			isSortComplete = true;
			for(int i=0;i<vertices;i++) {
				if(inDegree[i] >=0) {
					isSortComplete = false;
				}
			}
			
		}
	}

	private void topologicalSorUtil(LinkedList<Integer> linkedList, int[] inDegree) {
		for(int v: linkedList) {
			if(inDegree[v]>0) {
				inDegree[v]--;
			}
		}
		
	}
	
	

}
