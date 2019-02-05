package codingpractice.ctci.linkedList;

import codingpractice.datastructure.LinkedNode;

public class FindKthToLastNode<T> {
	class LevelWrapper{
		public int level;
	}
	
	public T findKthToLastNodeRecur(LinkedNode<T> node, int k) {
		LevelWrapper index = new LevelWrapper();
		
		return findKthToLastNodeRecur(node, k, index);
	}
	
	public T findKthToLastNodeRecur(LinkedNode<T> node, int k, LevelWrapper index) {
		if(node == null)
			return null;
		
		T retValue = findKthToLastNodeRecur(node.getNext(), k, index);
		// after return add to level count.
		index.level = index.level + 1;
		
		if(index.level == k)
			return node.getElement();
		
		return retValue;
	}

	
	public T findKthToLastNodeIter(LinkedNode<T> node, int k) throws Exception {
		LinkedNode<T> indexNode = node;
		LinkedNode<T> runnerNode = node;
		// check LinkedList size sufficient
		if(!isLinkedListSizeSufficient(node, k))
			throw new Exception("LinkedList size not sufficient for kth to last element.");
		
		// iterate through all node
		while(indexNode != null) {
			runnerNode = indexNode;
			
			// look forward into the end
			for(int i = 0; i < k-1; i++) 
				runnerNode = runnerNode.getNext();
			
			// check if runner Node.getNext() is point to end of linkedList
			if(runnerNode.getNext() == null) {
				// found the nth, return indexNode
				return indexNode.getElement();
			} else {
				indexNode = indexNode.getNext();
			}
		}
		
		return null;
	}
	
	private boolean isLinkedListSizeSufficient(LinkedNode head, int size) {
		int nodeCount = 0;
		
		while(head != null) {
			nodeCount++;
			head = head.getNext();
		}
		
		return nodeCount >= size;
	}
}
