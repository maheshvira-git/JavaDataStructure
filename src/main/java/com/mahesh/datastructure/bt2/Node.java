/**
 * 
 */
package com.mahesh.datastructure.bt2;

/**
 * @author mahesh.vira
 *
 */
public class Node {

	int data;
	Node left;
	Node right;
	
	public Node(int data) {
		this.data=data;
		this.left=null;
		this.right=null;
	}
	
	public void add(int data) {
		if(data >= this.data) {
			if(this.right==null) {
				this.right = new Node(data);
			}else {
				this.right.add(data);
			}
		}else {
			if(this.left==null) {
				this.left = new Node(data);
			}else {
				this.left.add(data);
			}
		}
	}

	public void printInOrder() {
		if(this.left!=null)
			this.left.printInOrder();
		System.out.println(this.data);
		if(this.right!=null)
			this.right.printInOrder();
	}
	
}
