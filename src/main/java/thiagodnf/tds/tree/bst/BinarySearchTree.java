package thiagodnf.tds.tree.bst;

import thiagodnf.tds.tree.Node;
import thiagodnf.tds.tree.Tree;

public class BinarySearchTree<T> extends Tree<T> {

	@Override
	public Node<T> add(Node<T> node, T value) {

		if (node == null) {
			node = new BinarySearchNode<T>(value);
		} else {

			if (node.compareTo(value) >= 0) {
				node.setLeftNode(add(node.getLeftNode(), value));
			} else {
				node.setRightNode(add(node.getRightNode(), value));
			}
		}

		return node;
	}

}
