/**
 * 
 */
package com.mahesh.datastructure.bt1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mahesh.vira
 *
 */
public class BinaryTree {

	Node root;

	private Node addRecurrsive(Node current, int data) {

		if (current == null) {
			return new Node(data);
		}

		if (data < current.data) {
			current.left = addRecurrsive(current.left, data);
		} else if (data > current.data) {
			current.right = addRecurrsive(current.right, data);
		} else {
			return current;
		}

		return current;

	}

	private void printInOrder(Node current) {

		if (current != null) {
			printInOrder(current.left);
			System.out.println(" " + current.data);
			printInOrder(current.right);
		}
	}

	private void printPreOrder(Node current) {

		if (current != null) {
			System.out.println(" " + current.data);
			printInOrder(current.left);
			printInOrder(current.right);
		}
	}

	private void printPostOrder(Node current) {

		if (current != null) {
			printInOrder(current.left);
			printInOrder(current.right);
			System.out.println(" " + current.data);
		}
	}

	private void printLevelOrder(Node current) {

		if (current != null) {

			Queue<Node> nodes = new LinkedList<>();
			nodes.add(current);

			while (!nodes.isEmpty()) {

				Node node = nodes.poll();

				System.out.println(" " + node.data);

				if (node.left != null) {
					nodes.add(node.left);
				}

				if (node.right != null) {
					nodes.add(node.right);
				}

			}
		}

	}

	private boolean containsNodeRecurrsive(Node current, int data) {

		if (current == null) {
			return false;
		}

		if (data == current.data) {
			return true;
		}

		return data < current.data ? containsNodeRecurrsive(current.left, data)
				: containsNodeRecurrsive(current.right, data);

	}

	private Node deleteNodeRecurrsive(Node current, int data) {

		if (current == null) {
			return null;
		}

		if (data == current.data) {

			if (current.left == null && current.right == null) {
				return null;
			}

			if (current.right == null) {
				return current.left;
			}

			if (current.left == null) {
				return current.right;
			}

			int smallestValue = findSmallestValue(current.right);
			current.data = smallestValue;
			current.right = deleteNodeRecurrsive(current.right, smallestValue);

			return current;

		}

		if (data < current.data) {
			current.left = deleteNodeRecurrsive(current.left, data);
			return current;
		}

		current.right = deleteNodeRecurrsive(current.right, data);
		return current;

	}

	private int findSmallestValue(Node node) {
		return node.left == null ? node.data : findSmallestValue(node.left);
	}

	private int checkHeight(Node node) {

		if (node == null)
			return -1;

		return Math.max(checkHeight(node.left), checkHeight(node.right)) + 1;

	}

	private boolean isBalanced(Node node) {

		if (node == null)
			return true;

		int leftNodeHeight = checkHeight(node.left);

		int rightNodeHeight = checkHeight(node.right);

		int diff = leftNodeHeight - rightNodeHeight;

		if (Math.abs(diff) > 1) {
			return false;
		} else {
			return isBalanced(node.left) && isBalanced(node.right);
		}
	}

	private boolean checkBST(Node node) {
		return checkBST(node, null, null);
	}

	private boolean checkBST(Node node, Integer min, Integer max) {

		if (node == null)
			return true;

		if ((min != null && node.data <= min) || (max != null && node.data > max )) {
			return false;
		}
		
		if(!checkBST(node.left, min, node.data) || !checkBST(node.right, node.data, max)) {
			return false;
		}
		
		return true;

	}

	private Node find(Node current,int d) {
		
		if(current!=null) {
			
			if(current.data==d) return current;
			
			if(d<current.data) {
				return find(current.left,d);
			}else {
				return find(current.right,d);
			}
		}
		
		return current;
	}
	
	/******** All Public Methods **********/

	public void add(int value) {
		root = addRecurrsive(root, value);
	}

	public void printInOrder() {
		printInOrder(root);
	}

	public void printPreOrder() {
		printPreOrder(root);
	}

	public void printPostOrder() {
		printPostOrder(root);
	}

	public void printLevelOrder() {
		printLevelOrder(root);
	}

	public boolean containsNode(int data) {
		return containsNodeRecurrsive(root, data);
	}

	public void delete(int value) {
		deleteNodeRecurrsive(root, value);
	}

	public int checkHeight() {
		return checkHeight(root);
	}

	public boolean isBalanced() {
		return isBalanced(root);
	}
	
	public boolean isBst() {
		return checkBST(root);
	}
	
	public Node find(int d) {
		return find(root,d);
	}
}
