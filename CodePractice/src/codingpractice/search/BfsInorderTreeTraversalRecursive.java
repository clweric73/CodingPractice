package codingpractice.search;

import codingpractice.datastructure.Node;

public class BfsInorderTreeTraversalRecursive implements DisplayData {

	@Override
	public void displayData(Node node) {
		if(node.getChildren().size() >= 1)
			displayData(node.getChildren().get(0));
		System.out.print(node.getValue() + " ");
		if(node.getChildren().size() >= 2)
			displayData(node.getChildren().get(1));
	}

}
