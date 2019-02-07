package codingpractice.datastructure;

public class BNode {
	private int value;
	private BNode left;
	private BNode right;
	
	public BNode(int value, BNode left, BNode right){
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
	public BNode getLeft(){
		return left;
	}
	
	public BNode getRight(){
		return right;
	}
	
	public int getValue(){
		return value;
	}
	
	public void setLeft(BNode node) {
		left = node;
	}
	
	public void setRight(BNode node) {
		right = node;
	}
}
