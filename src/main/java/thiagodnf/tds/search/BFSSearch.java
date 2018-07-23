package thiagodnf.tds.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import thiagodnf.tds.node.Node;
import thiagodnf.tds.tree.Tree;

public class BFSSearch extends Search<Integer, Node<Integer>>{

	@Override
	public List<String> execute(Tree<Integer, Node<Integer>> tree) {

		List<String> nodes = new ArrayList<>();

		if (tree.isEmpty()) {
			return nodes;
		}

		Queue<Node<Integer>> queue = new LinkedList<>();

		queue.add(tree.getRoot());

		while (!queue.isEmpty()) {

			Node<Integer> node = queue.remove();

			nodes.add(node.toString());

			if (node.hasLeftNode()) {
				queue.add(node.getLeftNode());
			}

			if (node.hasRightNode()) {
				queue.add(node.getRightNode());
			}
		}

		return nodes;
	}
	
	@Override
	public String getShortName() {
		return "BFS: ";
	}
}
