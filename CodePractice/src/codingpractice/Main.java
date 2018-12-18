package codingpractice;

import java.util.Arrays;

import codingpractice.datastructure.BinaryTree;
import codingpractice.datastructure.Node;
import codingpractice.dynamicprogramming.MakeChange;
import codingpractice.search.BfsInorderTreeTraversalRecursive;
import codingpractice.search.BfsInorderTreeTraversalStack;
import codingpractice.search.BfsPostorderTreeTraversalRecursive;
import codingpractice.search.BfsPostorderTreeTraversalStack;
import codingpractice.search.BfsPreorderTreeTraversalRecursive;
import codingpractice.search.BfsPreorderTreeTraversalStack;
import codingpractice.search.DisplayData;
import codingpractice.sort.QuickSort;
import codingpractice.sort.Sort;

public class Main {

	public static void main(String[] args) {
//		BinaryTree bTree = new BinaryTree();
//		Node root = bTree.generateStructureWithRandomData();
//		
//		TraversalTreeRecursive(root);
//		TraversalTreeStack(root);
		MakeChange m = new MakeChange();
		System.out.println(m.howManyWaysToMakeChange(new int[] {25, 10, 5, 1}, 27));
//		int[] a = new int[]{3,7,2,1,6,9,3,3};
//		Sort s = new QuickSort();
//		s.sortArray(a);
//		System.out.println(Arrays.toString(a));
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
