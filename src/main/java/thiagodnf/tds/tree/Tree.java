package thiagodnf.tds.tree;

import java.util.ArrayList;
import java.util.List;

public abstract class Tree<T> {
	
	private Node<T> root;
	
	public int getNumberOfNodes() {
		return getNumberOfNodes(getRoot());
	}

	public int getNumberOfNodes(Node<T> node) {

		if (node == null) {
			return 0;
		}

		int nodesOnLeft = getNumberOfNodes(node.getLeftNode());
		int nodesOnRight = getNumberOfNodes(node.getRightNode());

		return nodesOnLeft + nodesOnRight + 1;
	}
	
	public int getDepth() {
		return getDepth(getRoot());
	}
	
	public int getDepth(Node<T> node) {

		if (node == null) {
			return 0;
		}

		int depthOnLeft = getDepth(node.getLeftNode());
		int depthOnRight = getDepth(node.getRightNode());

		if (depthOnLeft == depthOnRight) {
			return depthOnLeft + 1;
		} else if (depthOnLeft > depthOnRight) {
			return depthOnLeft + 1;
		} else {
			return depthOnRight + 1;
		}
	}
	
	public List<Node<T>> getDepthFirstSearch() {
		return getDepthFirstSearch(getRoot(), new ArrayList<>());
	}
	
	public List<Node<T>> getDepthFirstSearch(Node<T> node, List<Node<T>> nodes) {

		if(node == null) {
			return nodes;
		}
		
		nodes.add(node);
		
		if (node.hasLeftNode()) {
			nodes.addAll(getDepthFirstSearch(node.getLeftNode(), nodes));
		}
		
		if (node.hasRightNode()) {
			nodes.addAll(getDepthFirstSearch(node.getRightNode(), nodes));
		}
		
		return nodes;
	}
	
	public int getNumberOfLeaves() {
		return getNumberOfLeaves(getRoot());
	}

	public int getNumberOfLeaves(Node<T> node) {

		if (node == null) {
			return 0;
		}

		if (node.isLeaf()) {
			return 1;
		}

		int leavesOnLeftNodes = getNumberOfLeaves(node.getLeftNode());
		int leavesOnRightNodes = getNumberOfLeaves(node.getRightNode());

		return leavesOnLeftNodes + leavesOnRightNodes;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void setRoot(Node<T> root) {
		this.root = root;
	}
	
	public Node<T> getRoot() {
		return this.root;
	}
	
	public void add(List<T> values) {
		for (T value : values) {
			add(value);
		}
	}
	
	public void add(T value) {
		setRoot(add(root, value));
	}
	
	public abstract Node<T> add(Node<T> node, T value);
}
