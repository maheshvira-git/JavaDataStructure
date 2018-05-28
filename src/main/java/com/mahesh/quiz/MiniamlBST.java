/**
 * 
 */
package com.mahesh.quiz;

/**
 * 
 * Prepare a Binary Search Tree from Sorted Array
 * @author mahesh.vira
 *
 */
class Node {
	
	int data;
	Node left;
	Node right;
	
	Node(int data){
		this.data=data;
		left=null;
		right=null;
	}

	public void inOrder() {

		if(this.left!=null)
			this.left.inOrder();
		System.out.println(this.data);
		if(this.right!=null)
			this.right.inOrder();
		
	}
	
}
public class MiniamlBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int arr[] = new int[] {1,12,23,24,25,36,47,58};
		MiniamlBST m = new MiniamlBST();
		Node minimalBST = m.minimalBST(arr, 0, arr.length-1);
		minimalBST.inOrder();
	}
	
	public Node minimalBST(int arr[],int start,int end) {
		
		if(end < start) return null;
		
		int mid = (start+end)/2;
		
		Node n = new Node(arr[mid]);
		n.left = minimalBST(arr,start,mid-1);
		n.right = minimalBST(arr,mid+1,end);
		
		return n;
		
	}

}
