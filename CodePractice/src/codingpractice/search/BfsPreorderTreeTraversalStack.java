package codingpractice.search;

import java.util.Stack;

import codingpractice.datastructure.Node;

public class BfsPreorderTreeTraversalStack implements DisplayData {

	@Override
	public void displayData(Node node) {
		if ( node == null )
			return;
		
		Stack<Node> stack = new Stack<>();
		Node currentNode = node;
		stack.push(currentNode);
		
		while(!stack.isEmpty()) {
			// process node
			currentNode = stack.pop();
			System.out.print(currentNode.getValue() + " ");
			
			if(currentNode.getChildren().size() > 1) {
				stack.push(currentNode.getChildren().get(1));
				stack.push(currentNode.getChildren().get(0));
			}
		}
	}
}
