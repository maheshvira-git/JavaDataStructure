/**
 * 
 */
package com.mahesh.sorting.bfs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mahesh.vira
 * Time Complexity: O(V+E) where V is number of vertices in the graph and E is number of edges in the graph.
 * 
 */
public class GraphBFS {

	private int v; //no of vertices
	private LinkedList<Integer> adj [];
	
	
	@SuppressWarnings("unchecked")
	public GraphBFS(int v) {
		this.v = v;
		this.adj = new LinkedList[v];
		for(int i=0;i<v;i++) {
			adj[i]= new LinkedList<>();
		}
	}
	
	void addEdge(int v,int w) {
		adj[v].add(w);
	}

	public void bfsSearch(int s) {

		boolean visited [] = new boolean[v];
		
		Queue<Integer> queue = new LinkedList<>();
		visited[s]=true;
		queue.add(s);
		
		while(!queue.isEmpty()) {
			
			s = queue.poll();
			System.out.println(s+" ");
			
			Iterator<Integer> itr = adj[s].iterator();
			while(itr.hasNext()) {
				
				int n = itr.next();
				if(!visited[n]) {
					visited[n]=true;
					queue.add(n);
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		
		GraphBFS g = new GraphBFS(6);
		
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");
        
        g.bfsSearch(2);
		
	}

}
