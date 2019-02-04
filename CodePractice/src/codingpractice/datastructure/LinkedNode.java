package codingpractice.datastructure;

public class LinkedNode<T> {
	private T element;
	private LinkedNode<T> nextNode;
	
	public LinkedNode(){
		this.element = null;
		this.nextNode = null;
	}
	
	public LinkedNode<T> getNext(){
		return this.nextNode;
	}
	
	public void setNext(LinkedNode<T> node){
		this.nextNode = node;
	}
	
	public T getElement(){
		return element;
	}
	
	public void setElement(T element){
		this.element = element;
	}
}
