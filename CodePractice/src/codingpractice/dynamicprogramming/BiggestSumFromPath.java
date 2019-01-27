package codingpractice.dynamicprogramming;

import codingpractice.datastructure.BNode;

public class BiggestSumFromPath {
	public int findBiggestSumFromBTree(BNode n, int currentSum){
		if(n == null)
			return currentSum;
		
		int valueFromLeft;
		int valueFromRight;
		valueFromLeft = findBiggestSumFromBTree(n.getLeft(), currentSum + n.getValue());
		valueFromRight = findBiggestSumFromBTree(n.getRight(), currentSum + n.getValue());
		
		return Math.max(valueFromLeft, valueFromRight);
	}
}
