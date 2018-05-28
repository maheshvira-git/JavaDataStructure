/**
 * 
 */
package com.mahesh.quiz;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mahesh.vira
 *
 */
public class RouteBetween2Nodes {
	
	private int v; //no of vertices
	private LinkedList<Integer> adj [];
	
	
	@SuppressWarnings("unchecked")
	public RouteBetween2Nodes(int v) {
		this.v = v;
		this.adj = new LinkedList[v];
		for(int i=0;i<v;i++) {
			adj[i]= new LinkedList<>();
		}
	}
	
	void addEdge(int v,int w) {
		adj[v].add(w);
	}

	public String bfsSearch(int s,int e) {

		StringBuilder path = new StringBuilder("");
		
		boolean routeFound = false;
		boolean visited [] = new boolean[v];
		
		Queue<Integer> queue = new LinkedList<>();
		visited[s]=true;
		queue.add(s);
		path.append(""+s);
		
		while(!queue.isEmpty()) {
			
			s = queue.poll();
			
			Iterator<Integer> itr = adj[s].iterator();
			while(itr.hasNext()) {
				
				int n = itr.next();
				if(!visited[n]) {
					path.append(","+n);
					visited[n]=true;
					queue.add(n);
				}
				
				if(n==e) {
					routeFound=true;
					break;
				}
			}
			
			if(routeFound) {
				return path.toString();
			}
			
		}
		
		return "";
	}
	
	public static void main(String[] args) {
		
		RouteBetween2Nodes g = new RouteBetween2Nodes(4);
		
		g.addEdge(0, 1);
		g.addEdge(1, 3);
        g.addEdge(1, 2);
 
        String path = g.bfsSearch(0,3);
        
        System.out.println(path);
		
	}

}
