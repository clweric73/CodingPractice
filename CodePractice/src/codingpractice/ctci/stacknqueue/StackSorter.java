package codingpractice.ctci.stacknqueue;

import java.util.Stack;

public class StackSorter {
	public void sortStackUsingAnotherStack(Stack<Integer> stack) throws Exception {
		Stack<Integer> tmpStack = new Stack<>();
		int element;
		
		while(!stack.isEmpty()) {
			// pop one element from src stack
			element = stack.pop();
			
			// find the right place in temp
			while(!tmpStack.isEmpty() && element < tmpStack.peek()) {
				stack.push(tmpStack.pop());
			}
			
			tmpStack.push(element);
		}
		
		// push everything in tmpStack back to stack
		while(!tmpStack.isEmpty())
			stack.push(tmpStack.pop());
	}
}
