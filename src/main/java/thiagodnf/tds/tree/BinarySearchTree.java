package thiagodnf.tds.tree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import thiagodnf.tds.node.IntegerNode;
import thiagodnf.tds.node.Node;

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

	@Override
	public String getName() {
		return "Binary Search Tree";
	}

	@Override
	public List<Integer> parseInput(String input) {
		return Arrays.asList(input.split(","))
				.stream()
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}
}
