package codingpractice.ctci.treesngraphs;

import codingpractice.datastructure.BNode;

public class TreeChecker {
	public boolean isTreeBalanced(BNode root){
		boolean[] isBalanced = new boolean[1];
		isBalanced[0] = true;
		
		isTreeBalanced(root, isBalanced);
		
		return isBalanced[0];
	}
	
	private int isTreeBalanced(BNode node, boolean[] isBalanced){
		if(node == null || isBalanced[0] == false)
			return 0;
		
		int maxLeftValue = 0;
		int maxRightValue = 0;
		
		maxLeftValue = isTreeBalanced(node.getLeft(), isBalanced);
		maxRightValue = isTreeBalanced(node.getRight(), isBalanced);
		
		// assign isBalanced value, only check if its equal true
		if(isBalanced[0] == true){
			isBalanced[0] = (Math.abs(maxLeftValue - maxRightValue) <= 1);
		}
		
		return (Math.max(maxLeftValue, maxRightValue) + 1);
	}
	
	public boolean isBinarySearchTree(BNode root, Integer min, Integer max){
		if(root == null)
			return true;
		
		// check left child
		boolean leftResult = isBinarySearchTree(root.getLeft(), min, root.getValue());
		
		// check right child
		boolean rightResult = isBinarySearchTree(root.getRight(), root.getValue(), max);
		
		// check min
		boolean currResult = true;
		if(min != null && root.getValue() < min)
			currResult = false;
		if (max != null && root.getValue() > max)
			currResult = false;
		
		// return any false
		return (leftResult && rightResult && currResult);
	}
}
