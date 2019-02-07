package codingpractice.ctci.treesngraphs;

import codingpractice.datastructure.BNode;

public class ArrayToTreeConverter {
	public BNode sortedArrayToBinaryTree(int[] array) {
		// check if array is valid
		if(array.length <= 0)
			return null;
		
		int midIndex = array.length / 2;
		
		BNode root = new BNode(array[midIndex], null, null);
		// left tree build
		sortedArrayToBinaryTree(array, 0, midIndex - 1, root);
		// right tree build
		sortedArrayToBinaryTree(array, midIndex + 1, array.length - 1, root);
		
		return root;
	}
	
	private void sortedArrayToBinaryTree(int[] array, int startIndex, int endIndex, BNode parentNode) {
		// base case
		if(startIndex > endIndex)
			return;
		
		int midIndex = (((endIndex - startIndex) / 2) + startIndex);
		BNode newChild = new BNode(array[midIndex], null, null);
		
		if(array[midIndex] <= parentNode.getValue()) {
			// add to left child
			parentNode.setLeft(newChild);
		} else {
			// add to right child
			parentNode.setRight(newChild);
		}
		
		// recursive to left to build left tree
		sortedArrayToBinaryTree(array, 0, midIndex - 1, newChild);
		
		// recursive to right to build right tree
		sortedArrayToBinaryTree(array, midIndex + 1, endIndex, newChild);
	}

}
