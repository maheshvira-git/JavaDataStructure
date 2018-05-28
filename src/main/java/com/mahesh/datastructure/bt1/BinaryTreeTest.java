/**
 * 
 */
package com.mahesh.datastructure.bt1;

/**
 * @author mahesh.vira
 *
 */
public class BinaryTreeTest {

	public static void main(String[] args) {

		BinaryTree tree = new BinaryTree();

		tree.add(7);
		tree.add(3);
		tree.add(8);
		tree.add(2);
		tree.add(4);
		tree.add(15);
		
		tree.printInOrder();
		
		//tree.printLevelOrder();
		
		//System.out.println("\n"+tree.isBst());
		
		Node found = tree.find(3);
		
		System.out.println(found.left + "-" + found.right);
	}

}
