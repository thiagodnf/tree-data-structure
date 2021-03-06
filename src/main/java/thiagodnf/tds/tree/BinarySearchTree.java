package thiagodnf.tds.tree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import thiagodnf.tds.gui.theme.Theme;
import thiagodnf.tds.node.IntegerNode;
import thiagodnf.tds.node.Node;

public class BinarySearchTree extends Tree<Integer, Node<Integer>> {

	public BinarySearchTree(Theme colorTheme) {
		super(colorTheme);
	}
	
	public BinarySearchTree() {
		super();
	}
	
	@Override
	public Node<Integer> add(Node<Integer> node, Object value) {
		
		Integer val = (Integer) value;
		
		if (node == null) {
			node = new IntegerNode(val);
		} else {

			if (node.compareTo(val) >= 0) {
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
	public List<Object> parseInput(String input) {
		return Arrays.asList(input.split(","))
				.stream()
				.map(Integer::parseInt)
				.collect(Collectors.toList());
	}

	@Override
	public String toString(Node<Integer> node) {
		return String.valueOf(node.getValue());
	}
}
