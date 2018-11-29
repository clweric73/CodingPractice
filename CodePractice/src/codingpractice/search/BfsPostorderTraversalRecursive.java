package codingpractice.search;

import codingpractice.datastructure.Node;

public class BfsPostorderTraversalRecursive implements DisplayData{

	@Override
	public void displayData(Node node) {
		for(Node n : node.getChildren())
			displayData(n);
		System.out.print(node.getValue() + " ");
		
	}

}
