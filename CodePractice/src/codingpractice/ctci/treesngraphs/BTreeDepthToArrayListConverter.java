package codingpractice.ctci.treesngraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import codingpractice.datastructure.BNode;

public class BTreeDepthToArrayListConverter {
	public List<LinkedList<Integer>> convert(BNode root){
		if(root == null)
			return null;
		
		List<LinkedList<Integer>> depthLists = new ArrayList<LinkedList<Integer>>();
		// added to arrayList element 0 for depth 0
		treeToLists(root, 0, depthLists);
		
		return depthLists;
	}
	
	private void treeToLists(BNode node, int currDepth, List<LinkedList<Integer>> depthLists) {
		if(node == null)
			return;
		
		if((depthLists.size() - 1) < currDepth) {
			// depthLists doesn't have the list yet.  Add first element into the list
			LinkedList<Integer> newDepthList = new LinkedList<Integer>();
			newDepthList.add(node.getValue());
			depthLists.add(newDepthList);
		} else {
			// depthList exist
			depthLists.get(currDepth).add(node.getValue());
		}
		
		// go deep left one level
		treeToLists(node.getLeft(), (currDepth + 1), depthLists);
		
		// go deep right one level
		treeToLists(node.getRight(), (currDepth + 1), depthLists);
	}
}
