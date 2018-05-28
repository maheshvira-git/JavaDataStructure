/**
 * 
 */
package com.mahesh.sorting.bfs.bidirection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mahesh.vira Time Complexity: O(b^(d/2)) where b is branching factor
 *         of tree and d is the distance of goal vertex from source.
 * 
 */
public class GraphBFSBiDir {

	private int v; // no of vertices
	private LinkedList<Integer> adj[];

	@SuppressWarnings("unchecked")
	public GraphBFSBiDir(int v) {
		this.v = v;
		this.adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	public void bfsSearch(int s,int t) {

		boolean found = false;
		
		boolean [] sVisited = new boolean[v];
		boolean [] tVisited = new boolean[v];
		
		Queue<Integer> sQueue = new LinkedList<>();
		Queue<Integer> tQueue = new LinkedList<>();
		
		sVisited[s] = true;
		tVisited[t] = true;
		
		sQueue.add(s);
		tQueue.add(t);

		while (!sQueue.isEmpty() || !tQueue.isEmpty()) {

			s = sQueue.poll();
			
			System.out.println(s + " ");

			Iterator<Integer> sItr = adj[s].iterator();
			
			while (sItr.hasNext()) {

				int n = sItr.next();
				if (!sVisited[n]) {
					sVisited[n] = true;
					sQueue.add(n);
				}
			}

			t = tQueue.poll();
			
			System.out.println(t + " ");
			
			Iterator<Integer> tItr = adj[t].iterator();
			
			while (tItr.hasNext()) {
				
				int n = tItr.next();
				if (!tVisited[n]) {
					tVisited[n] = true;
					tQueue.add(n);
				}
			}
			
			for(int i=0;i<v;i++) {
				if(sVisited[i]&&tVisited[i]) {
					System.out.println("found common vertex : "+i);
					found=true;
					break;
				}
			}

			if(found) {
				break;
			}
		}
	}
	
	public static void main(String[] args) {

		GraphBFSBiDir g = new GraphBFSBiDir(15);

		g.addEdge(0, 4);
		g.addEdge(1, 4);
		g.addEdge(2, 5);
		g.addEdge(3, 5);
		g.addEdge(4, 6);
		g.addEdge(5, 6);
		g.addEdge(6, 7);
		g.addEdge(7, 8);
		g.addEdge(8, 9);
		g.addEdge(8, 10);
		g.addEdge(9, 11);
		g.addEdge(9, 12);
		g.addEdge(10, 13);
		g.addEdge(10, 14);
		
		g.bfsSearch(0,14);

	}

}
