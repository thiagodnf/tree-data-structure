package thiagodnf.tds.tree;

import java.util.List;

import thiagodnf.tds.node.Node;

/**
 * A tree is a widely used abstract data type (ADT) - or data structure
 * implementing this ADT—that simulates a hierarchical tree structure, with a
 * root value and subtrees of children with a parent node, represented as a set
 * of linked nodes. All trees should extend this class
 * 
 * @author Thiago Ferreira
 * @since 2018-07-23
 * @version 1.0.0
 */
public abstract class Tree<S, T extends Node<S>> {
	
	private T root;
	
	public int getNumberOfNodes() {
		return getNumberOfNodes(getRoot());
	}

	public int getNumberOfNodes(Node<S> node) {

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
	
	public int getDepth(Node<S> node) {

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
	
	public int getNumberOfLeaves() {
		return getNumberOfLeaves(getRoot());
	}

	public int getNumberOfLeaves(Node<S> node) {

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
		return getRoot() == null;
	}
	
	public void setRoot(T root) {
		this.root = root;
	}
	
	public T getRoot() {
		return this.root;
	}
	
	public void add(List<S> values) {
		for (S value : values) {
			add(value);
		}
	}
	
	public void add(S value) {
		setRoot(add(root, value));
	}
	
	public abstract T add(T node, S value);
	
	public abstract String getName();
}
