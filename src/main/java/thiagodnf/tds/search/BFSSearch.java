package thiagodnf.tds.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import thiagodnf.tds.tree.Node;
import thiagodnf.tds.tree.Tree;

public class BFSSearch<T> extends Search<T>{

	public BFSSearch(Tree<T> tree) {
		super(tree);
	}

	@Override
	public List<Node<T>> execute() {

		List<Node<T>> nodes = new ArrayList<>();

		if (tree.isEmpty()) {
			return nodes;
		}

		Queue<Node<T>> queue = new LinkedList<Node<T>>();

		queue.add(tree.getRoot());

		while (!queue.isEmpty()) {

			Node<T> node = queue.remove();

			nodes.add(node);

			if (node.hasLeftNode()) {
				queue.add(node.getLeftNode());
			}

			if (node.hasRightNode()) {
				queue.add(node.getRightNode());
			}
		}

		return nodes;
	}
}
