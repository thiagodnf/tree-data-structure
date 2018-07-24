package thiagodnf.tds.search;

import java.util.ArrayList;
import java.util.List;

import thiagodnf.tds.node.Node;
import thiagodnf.tds.tree.Tree;

public class DFSWithPostOrderSearch extends Search<Object, Node<Object>>{

	@Override
	public List<String> execute(Tree<Object, Node<Object>> tree) {
		return postOrder(tree, tree.getRoot(), new ArrayList<>());
	}

	public List<String> postOrder(Tree<Object, Node<Object>> tree, Node<Object> node, List<String> nodes) {

		if (node.hasLeftNode()) {
			postOrder(tree, node.getLeftNode(), nodes);
		}

		if (node.hasRightNode()) {
			postOrder(tree, node.getRightNode(), nodes);
		}
		
		if (node != null) {
			nodes.add(tree.toString(node));
		}

		return nodes;
	}
	
	@Override
	public String getShortName() {
		return "DFS w/ Post-Order";
	}
}
