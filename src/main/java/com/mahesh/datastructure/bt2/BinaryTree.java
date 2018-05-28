/**
 * 
 */
package com.mahesh.datastructure.bt2;

/**
 * @author mahesh.vira
 *
 */
public class BinaryTree {
	
	Node root;
	
	public void add(int data){
		if(root == null) {
			root = new Node(data);
		}else {
			root.add(data);
		}
	}
	
	public void printInOrder() {
		if(root != null) {
			root.printInOrder();
		}
	}
}
