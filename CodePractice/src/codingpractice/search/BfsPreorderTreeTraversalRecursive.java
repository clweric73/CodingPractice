package codingpractice.search;

import codingpractice.datastructure.Node;

public class BfsPreorderTreeTraversalRecursive implements DisplayData {

	@Override
	public void displayData(Node node) {
		System.out.print(node.getValue() + " ");
		for(Node n : node.getChildren())
			displayData(n);
	}

}
