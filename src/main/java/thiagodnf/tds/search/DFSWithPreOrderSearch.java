package thiagodnf.tds.search;

import java.util.ArrayList;
import java.util.List;

import thiagodnf.tds.node.Node;
import thiagodnf.tds.tree.Tree;

public class DFSWithPreOrderSearch extends Search<Object, Node<Object>>{

	@Override
	public List<String> execute(Tree<Object, Node<Object>> tree) {
		return inorder(tree.getRoot(), new ArrayList<>());
	}

	public List<String> inorder(Node<Object> node, List<String> nodes) {

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

	@Override
	public String getShortName() {
		return "DFS w/ Pre-Order";
	}
}
