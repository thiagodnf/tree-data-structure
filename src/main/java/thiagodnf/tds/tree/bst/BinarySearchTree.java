package thiagodnf.tds.tree.bst;

import thiagodnf.tds.node.IntegerNode;
import thiagodnf.tds.node.Node;
import thiagodnf.tds.tree.Tree;

public class BinarySearchTree extends Tree<Integer, Node<Integer>> {

	@Override
	public Node<Integer> add(Node<Integer> node, Integer value) {

		if (node == null) {
			node = new IntegerNode(value);
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
