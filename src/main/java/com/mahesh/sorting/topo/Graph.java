/**
 * 
 */
package com.mahesh.sorting.topo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author mahesh.vira
 * This demonstrates the Topology Sorting Algorithm.
 * It is DFS with extra Stack
 * Time Complexity is O(V+E)
 * Directed Graph Using Adjacency list
 */
public class Graph {

	private int v; //no of vertices
	private LinkedList<Integer> adj [];
	
	
	@SuppressWarnings("unchecked")
	public Graph(int v) {
		this.v = v;
		this.adj = new LinkedList[v];
		for(int i=0;i<v;i++) {
			adj[i]= new LinkedList<>();
		}
	}
	
	void addEdge(int v,int w) {
		adj[v].add(w);
	}

	void topologicalSortUtil(int v,boolean visited[],Stack<Integer> stack) {
		
		//Mark Current Node as Visited
		visited[v]=true;
		Integer i;
		
		Iterator<Integer> it = adj[v].iterator();
		while(it.hasNext()) {
			i=it.next();
			if(!visited[i]) {
				topologicalSortUtil(i, visited, stack);
			}
		}
		
		//push current vertex to stack which stored result
		stack.push(new Integer(v));
		
	}
	
	void topologicalSort() {
		
		Stack<Integer> stack = new Stack<>();
		
		//mark all vertices not visited
		//No need to loop through as in java the array of boolean are by default set to false
		boolean visited[]=new boolean[v];
		
		//loop through all vertices
		for(int i=0;i<v;i++) {
			if(!visited[i]) {//If not visited
				topologicalSortUtil(i, visited, stack);
			}
		}
		
		//Print Stack
		while(!stack.empty()) {
			System.out.println(stack.pop()+ " ");
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
 
        System.out.println("Following is a Topological " +
                           "sort of the given graph");
        g.topologicalSort();
		
	}

}
