package thiagodnf.tds.tree.bst;

import thiagodnf.tds.node.Node;

public class BinarySearchNode<T> extends Node<T> {

	public BinarySearchNode(T value) {
		super(value);
	}

	@Override
	public int compareTo(T value) {

		double diff = 0.0;

		if (value instanceof Integer) {
			diff = ((Integer) getValue()) - ((Integer) value);
		}

		if (value instanceof Double) {
			diff = ((Double) getValue()) - ((Double) value);
		}

		if (diff < 0) {
			return -1;
		} else if (diff > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return String.valueOf(getValue());
	}
}
