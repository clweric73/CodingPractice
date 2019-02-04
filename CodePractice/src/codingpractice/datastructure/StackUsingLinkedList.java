package codingpractice.datastructure;

public class StackUsingLinkedList implements Stack {
	private LinkedNode<Integer> head;
	private LinkedNode<Integer> tail;
	private int stackSize;
	
	public StackUsingLinkedList(){ 
		this.head = new LinkedNode<Integer>();
		this.tail = head;
	}
	
	@Override
	public void push(int element) {
		LinkedNode<Integer> newNode = new LinkedNode<Integer>();
		newNode.setElement(element);
		newNode.setNext(head);
		head = newNode;
		
		stackSize++;
	}

	@Override
	public int pop() throws Exception {
		if(stackSize <= 0){
			throw new Exception("Stack is empty.");
		}
		
		LinkedNode<Integer> retNode = head;
		head = head.getNext();
		stackSize--;
		
		return retNode.getElement();
	}

	@Override
	public int getSize() {
		return stackSize;
	}
}
