package codingpractice;

import codingpractice.datastructure.BinaryTree;
import codingpractice.datastructure.Node;
import codingpractice.search.BfsInorderTreeTraversalRecursive;
import codingpractice.search.BfsPostorderTraversalRecursive;
import codingpractice.search.BfsPreorderTreeTraversalRecursive;
import codingpractice.search.DisplayData;

public class Main {

	public static void main(String[] args) {
		TraversalTreeRecursive();
	}

	private static void TraversalTreeRecursive() {
		BinaryTree bTree = new BinaryTree();
		Node root = bTree.generateStructureWithRandomData();
		
		System.out.println("== Pre Order ==");
		
		DisplayData treeDisplay = new BfsPreorderTreeTraversalRecursive();
		treeDisplay.displayData(root);
		
		System.out.println("\n== Post Order ==");
		
		treeDisplay = new BfsPostorderTraversalRecursive();
		treeDisplay.displayData(root);
		
		System.out.println("\n== In Order ==");
		
		treeDisplay = new BfsInorderTreeTraversalRecursive();
		treeDisplay.displayData(root);
	}

}
