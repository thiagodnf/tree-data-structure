package thiagodnf.tds.node;

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
