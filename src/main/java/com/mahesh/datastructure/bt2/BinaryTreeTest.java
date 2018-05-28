/**
 * 
 */
package com.mahesh.datastructure.bt2;

/**
 * @author mahesh.vira
 *
 */
public class BinaryTreeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();
		
		tree.add(1);
		tree.add(3);
		tree.add(2);
		tree.add(4);
		tree.add(8);

		tree.printInOrder();
		
	}

}
