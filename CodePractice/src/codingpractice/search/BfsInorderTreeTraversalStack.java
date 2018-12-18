package codingpractice.search;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import codingpractice.datastructure.Node;

public class BfsInorderTreeTraversalStack implements DisplayData {

	@Override
	public void displayData(Node node) {
		if(node == null)
			return;
		
		Stack<Node> stack = new Stack<>();
		Set<Node> visited = new HashSet<Node>();
		Node currentNode = node;
		stack.push(currentNode);
		
		while(!stack.isEmpty()) {
			currentNode = stack.pop();
			if(currentNode.getChildren().size() == 0 
					|| visited.contains(currentNode.getChildren().get(0))) {
				System.out.print(currentNode.getValue() + " ");
				visited.add(currentNode);
			} else {
				stack.push(currentNode.getChildren().get(1));
				stack.push(currentNode);
				stack.push(currentNode.getChildren().get(0));
			}
		}
	}
}
