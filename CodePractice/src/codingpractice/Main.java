package codingpractice;

import codingpractice.datastructure.BinaryTree;
import codingpractice.datastructure.Node;
import codingpractice.search.BfsInorderTreeTraversalRecursive;
import codingpractice.search.BfsInorderTreeTraversalStack;
import codingpractice.search.BfsPostorderTreeTraversalRecursive;
import codingpractice.search.BfsPostorderTreeTraversalStack;
import codingpractice.search.BfsPreorderTreeTraversalRecursive;
import codingpractice.search.BfsPreorderTreeTraversalStack;
import codingpractice.search.DisplayData;

public class Main {

	public static void main(String[] args) {
		BinaryTree bTree = new BinaryTree();
		Node root = bTree.generateStructureWithRandomData();
		
		TraversalTreeRecursive(root);
		TraversalTreeStack(root);
	}

	private static void TraversalTreeStack(Node root) {
		System.out.println("\n== Pre Order ==");
		
		DisplayData  treeDisplay = new BfsPreorderTreeTraversalStack();
		treeDisplay.displayData(root);
		
		System.out.println("\n== Post Order ==");
		
		treeDisplay = new BfsPostorderTreeTraversalStack();
		treeDisplay.displayData(root);
		
		System.out.println("\n== In Order ==");
		
		treeDisplay = new BfsInorderTreeTraversalStack();
		treeDisplay.displayData(root);
	}

	private static void TraversalTreeRecursive(Node root) {
		System.out.println("== Pre Order ==");
		
		DisplayData treeDisplay = new BfsPreorderTreeTraversalRecursive();
		treeDisplay.displayData(root);
		
		System.out.println("\n== Post Order ==");
		
		treeDisplay = new BfsPostorderTreeTraversalRecursive();
		treeDisplay.displayData(root);
		
		System.out.println("\n== In Order ==");
		
		treeDisplay = new BfsInorderTreeTraversalRecursive();
		treeDisplay.displayData(root);
	}

}
