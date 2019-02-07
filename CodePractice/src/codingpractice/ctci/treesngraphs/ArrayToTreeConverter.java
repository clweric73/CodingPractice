package codingpractice.ctci.treesngraphs;

import codingpractice.datastructure.BNode;

public class ArrayToTreeConverter {
	public BNode sortedArrayToBinaryTree(int[] array) {
		// check if array is valid
		if(array.length <= 0)
			return null;
		
		return sortedArrayToBinaryTree(array, 0, (array.length - 1));
	}
	
	private BNode sortedArrayToBinaryTree(int[] array, int startIndex, int endIndex) {
		// base case
		if(startIndex > endIndex)
			return null;
		
		int midIndex = (((endIndex - startIndex) / 2) + startIndex);
		BNode node = new BNode(array[midIndex], null, null);
		
		// recursive to left to build left tree
		node.setLeft(sortedArrayToBinaryTree(array, startIndex, (midIndex - 1)));
		
		// recursive to right to build right tree
		node.setRight(sortedArrayToBinaryTree(array, (midIndex + 1), endIndex));
		
		return node;
	}

}
