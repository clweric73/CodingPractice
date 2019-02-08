package codingpractice.ctci.linkedList;

import java.util.Stack;

import codingpractice.datastructure.LinkedNode;

public class SumLinkedList {
	public LinkedNode<Integer> sumLinkedListsLowToHigh(LinkedNode<Integer> listA, LinkedNode<Integer> listB) {
		LinkedNode<Integer> sumIndex = null;
		LinkedNode<Integer> sumHead = null;
		
		LinkedNode<Integer> currNodeA = listA;
		LinkedNode<Integer> currNodeB = listB;
		int carryOver = 0;
		int digitSum = 0;
		while(currNodeA != null || currNodeB != null) {
			
			if(currNodeA != null && currNodeB != null) {
				// both List has element
				digitSum = currNodeA.getElement() + currNodeB.getElement() + carryOver;
				currNodeA = currNodeA.getNext();
				currNodeB = currNodeB.getNext();
			} else if (currNodeA != null) {
				digitSum = currNodeA.getElement() + carryOver;
				currNodeA = currNodeA.getNext();
			} else {
				digitSum = currNodeB.getElement() + carryOver;
				currNodeB = currNodeB.getNext();
			}
			
			// check carry over for next iteration.
			if(digitSum >= 10) {
				carryOver = 1;
				digitSum = digitSum % 10;
			}
			else 
				carryOver = 0;
			
			// add new node into LinkedList
			if(sumHead == null) {
				// first element
				sumIndex = new LinkedNode<Integer>();
				sumHead = sumIndex;
				sumIndex.setElement(digitSum);	
			} else {
				sumIndex.setNext(new LinkedNode<Integer>());
				sumIndex.getNext().setElement(digitSum);
				sumIndex = sumIndex.getNext();
			}
		}
		
		// check last carry over
		if(carryOver > 0) {
			sumIndex.setNext(new LinkedNode<Integer>());
			sumIndex.getNext().setElement(carryOver);
			sumIndex = sumIndex.getNext();
		}
		
		return sumHead;
	}
	
	public LinkedNode<Integer> sumLinkedListsHighToLow(LinkedNode<Integer> a, LinkedNode<Integer> b){
		Stack<Integer> stackA = new Stack<Integer>();
		Stack<Integer> stackB = new Stack<Integer>();
		Stack<Integer> stackSum = new Stack<Integer>();
		
		LinkedNode<Integer> indexA = a;
		LinkedNode<Integer> indexB = b;
		// push linked list a into stack
		while(indexA != null) {
			stackA.push(indexA.getElement());
			indexA = indexA.getNext();
		}
		
		// push linked list b into stack
		while(indexB != null) {
			stackB.push(indexB.getElement());
			indexB = indexB.getNext();
		}
		
		// compare stack, if both stack has element => calc digitSum, else just push carry over
		int carryOver = 0;
		int digitSum = 0;
		while(stackA.size() > 0 || stackB.size() > 0) {
			if(stackA.size() > 0 && stackB.size() > 0) {
				// both has element do math
				digitSum = stackA.pop() + stackB.pop() + carryOver;
			} else if (stackA.size() > 0) {
				// only StackA has element just append
				digitSum = stackA.pop() + carryOver;
			} else {
				// only stackB has element just append with carryover
				digitSum = stackB.pop() + carryOver;
			}
			
			// calculate carryOver
			if(digitSum >= 10) {
				carryOver = 1;
				digitSum %= 10;
			} else {
				carryOver = 0;
				
			}
			
			// push to stackSum
			stackSum.push(digitSum);
		}
		// calculate last carry over
		if(carryOver > 0)
			stackSum.push(carryOver);
		
		// build linkedList from stack
		return convertStackToLinkedNodes(stackSum);
	}
	
	private LinkedNode<Integer> convertStackToLinkedNodes(Stack<Integer> stackSum){
		LinkedNode<Integer> sumList = null;
		LinkedNode<Integer> indexNode = null;
		
		while(!stackSum.isEmpty()) {
			if(indexNode == null) {
				// first element
				indexNode = new LinkedNode<Integer>();
				sumList = indexNode;
				indexNode.setElement(stackSum.pop());
			} else {
				indexNode.setNext(new LinkedNode<Integer>());
				indexNode.getNext().setElement(stackSum.pop());
				indexNode = indexNode.getNext();
			}
		}
		
		return sumList;
	}
}
