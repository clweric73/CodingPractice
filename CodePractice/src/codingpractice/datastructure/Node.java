package codingpractice.datastructure;

import java.util.LinkedList;
import java.util.List;

public class Node {
	String value;
	List<Node> children;
	public Node(String value, Node... nodes){
		this.value = value;
		this.children = new LinkedList<>();
		for(Node n : nodes)
			this.children.add(n);
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public List<Node> getChildren() {
		return children;
	}
	public void setChildren(List<Node> children) {
		this.children = children;
	}
}
