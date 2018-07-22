package thiagodnf.tds.search;

import java.util.ArrayList;
import java.util.List;

import thiagodnf.tds.tree.Node;
import thiagodnf.tds.tree.Tree;

public class DFSWithInorderSearch<T> extends Search<T>{

	public DFSWithInorderSearch(Tree<T> tree) {
		super(tree);
	}
	
	@Override
	public List<Node<T>> execute() {
		return inorder(tree.getRoot(), new ArrayList<>());
	}

	public List<Node<T>> inorder(Node<T> node, List<Node<T>> nodes) {

		if (node.hasLeftNode()) {
			inorder(node.getLeftNode(), nodes);
		}

		if (node != null) {
			nodes.add(node);
		}

		if (node.hasRightNode()) {
			inorder(node.getRightNode(), nodes);
		}

		return nodes;
	}

}
