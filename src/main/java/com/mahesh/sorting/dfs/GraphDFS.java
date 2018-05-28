/**
 * 
 */
package com.mahesh.sorting.dfs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author mahesh.vira
 *
 */
public class GraphDFS {

	private int v;
	private LinkedList<Integer> [] adj;
	
	@SuppressWarnings("unchecked")
	public GraphDFS(int v) {
		this.v=v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++) {
			adj[i]= new LinkedList<>();
		}
	}
	
	public void addEdge(int v,int w) {
		adj[v].add(w);
	}

	public void dfsSearch(int s) {

		boolean visited []  = new boolean[v];
		
		dfsSearchUtil(s,visited);
		
	}
	
	private void dfsSearchUtil(int s, boolean[] visited) {

		visited[s]=true;
		System.out.println(s+" ");
		
		Iterator<Integer> itr = adj[s].iterator();
		while(itr.hasNext()) {
			
			Integer n = itr.next();
			if(!visited[n]) {
				dfsSearchUtil(n, visited);
			}
			
		}
		
	}

	public static void main(String[] args) {

		GraphDFS g = new GraphDFS(6);
		
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Depth First Traversal "+
                           "(starting from vertex 2)");
 
        g.dfsSearch(2);
	}

}
