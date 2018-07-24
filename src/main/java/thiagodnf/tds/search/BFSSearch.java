package thiagodnf.tds.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import thiagodnf.tds.node.Node;
import thiagodnf.tds.tree.Tree;

public class BFSSearch extends Search<Object, Node<Object>>{

	@Override
	public List<String> execute(Tree<Object, Node<Object>> tree) {

		List<String> nodes = new ArrayList<>();

		if (tree.isEmpty()) {
			return nodes;
		}

		Queue<Node<Object>> queue = new LinkedList<>();

		queue.add(tree.getRoot());

		while (!queue.isEmpty()) {

			Node<Object> node = queue.remove();

			nodes.add(String.valueOf(node.getValue()));

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
		return "BFS";
	}
}
