package codingpractice.search;

import java.util.Stack;

import codingpractice.datastructure.Node;

public class BfsInorderTreeTraversalStack implements DisplayData {

	@Override
	public void displayData(Node node) {
		if(node == null)
			return;
		
		Stack<Node> stack = new Stack<>();
		Node currentNode = node;
		Node prevNode = null;
		stack.push(currentNode);
		
		while(!stack.isEmpty()) {
			currentNode = stack.pop();
			// check if currentNode is parent left node
			if(currentNode.getChildren().size() > 1 && currentNode.getChildren().get(0) == prevNode)
				System.out.print(currentNode.getValue() + " ");
			else if(currentNode.getChildren().size() > 1){
				stack.push(currentNode.getChildren().get(1));
				stack.push(currentNode);
				stack.push(currentNode.getChildren().get(0));
			} else {
				System.out.print(currentNode.getValue() + " ");
			}
			prevNode = currentNode;
		}
	}
}
