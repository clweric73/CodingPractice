package codingpractice.search;

import codingpractice.datastructure.Node;

public class BfsPostorderTreeTraversalRecursive implements DisplayData{

	@Override
	public void displayData(Node node) {
		for(Node n : node.getChildren())
			displayData(n);
		System.out.print(node.getValue() + " ");
		
	}

}
