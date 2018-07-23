package thiagodnf.tds.node;

/**
 * A node is a structure which may contain a value or condition, or represent a
 * separate data structure (which could be a tree of its own). Each node in a
 * tree has zero or more child nodes, which are below it in the tree (by
 * convention, trees are drawn growing downwards). All nodes should implement
 * this class
 * 
 * @author Thiago Ferreira
 * @since 2018-07-23
 * @version 1.0.0
 *
 * @param <T> Which information the node store
 */
public abstract class Node<T> implements Comparable<T> {
	
	protected Node<T> leftNode;
	
	protected Node<T> rightNode;
	
	protected T value;
	
	public Node(T value) {
		this.value = value;
	}

	public Node<T> getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(Node<T> leftNode) {
		this.leftNode = leftNode;
	}
	
	public Node<T> getRightNode() {
		return rightNode;
	}

	public void setRightNode(Node<T> rightNode) {
		this.rightNode = rightNode;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public boolean hasLeftNode() {
		return this.getLeftNode() != null;
	}
	
	public boolean hasRightNode() {
		return this.getRightNode() != null;
	}
	
	public boolean isLeaf() {
		return !hasLeftNode() && !hasRightNode();
	}
	
	public abstract String toString();
}
