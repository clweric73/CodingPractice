package codingpractice.search;

import java.util.Stack;

import codingpractice.datastructure.Node;

public class BfsPostorderTreeTraversalStack implements DisplayData {

	@Override
	public void displayData(Node node) {
		Stack<Node> stack = new Stack<>();
		Node currentNode = node;
		
		while(!stack.isEmpty() || currentNode != null) {
			while(currentNode != null) {
				stack.push(currentNode);
				if(currentNode.getChildren().size() > 0)
					currentNode = currentNode.getChildren().get(0);
				else
					currentNode = null;
			}
			
			// currentNode = null, stack filled with left tree nodes
			currentNode = stack.pop();
			
			// evaluate the popped node
			if(currentNode.getChildren().size() > 1) {
				// has right node
				Node rightNode = currentNode.getChildren().get(1);
				currentNode.getChildren().clear();
				stack.push(currentNode);
				currentNode = rightNode;
			} else {
				// no children, just display
				System.out.print(currentNode.getValue() + " ");
				currentNode = null;
			}
		}
	}

}
