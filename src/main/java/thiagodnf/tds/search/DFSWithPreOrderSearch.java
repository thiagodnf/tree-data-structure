package thiagodnf.tds.search;

import java.util.ArrayList;
import java.util.List;

import thiagodnf.tds.node.Node;
import thiagodnf.tds.tree.Tree;

public class DFSWithPreOrderSearch<T> extends Search<T>{

	public DFSWithPreOrderSearch(Tree<T> tree) {
		super(tree);
	}
	
	@Override
	public List<String> execute() {
		return inorder(tree.getRoot(), new ArrayList<>());
	}

	public List<String> inorder(Node<T> node, List<String> nodes) {

		if (node != null) {
			nodes.add(node.toString());
		}
		
		if (node.hasLeftNode()) {
			inorder(node.getLeftNode(), nodes);
		}

		if (node.hasRightNode()) {
			inorder(node.getRightNode(), nodes);
		}

		return nodes;
	}
}
