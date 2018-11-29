package codingpractice.search;

import java.util.Stack;

import codingpractice.datastructure.Node;

public class BfsInorderTreeTraversalStack implements DisplayData {
	private Stack<Node> stack;

	@Override
	public void displayData(Node node) {
		if ( node == null )
			return;
		stack = new Stack<>();
		Node currentNode = node;
		
		while(!stack.isEmpty() || currentNode != null) {
			while(currentNode != null) {
				stack.push(currentNode);
				if(currentNode.getChildren().size() > 0)
					currentNode = currentNode.getChildren().get(0);
				else 
					currentNode = null;
			}
			
			// currentNode is null, stack is filled up		
			currentNode = stack.pop();
			System.out.print(currentNode.getValue() + " ");
			
			// got to right node
			if(currentNode.getChildren().size()> 1)
				currentNode = currentNode.getChildren().get(1);
			else
				currentNode = null;
		}
	}
}
