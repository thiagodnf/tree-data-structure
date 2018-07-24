package thiagodnf.tds.search;

import java.util.ArrayList;
import java.util.List;

import thiagodnf.tds.node.Node;
import thiagodnf.tds.tree.Tree;

public class DFSWithInorderSearch extends Search<Object, Node<Object>>{

	@Override
	public List<String> execute(Tree<Object, Node<Object>> tree) {
		return inorder(tree, tree.getRoot(), new ArrayList<>());
	}

	public List<String> inorder(Tree<Object, Node<Object>> tree, Node<Object> node, List<String> nodes) {

		if (node.hasLeftNode()) {
			inorder(tree, node.getLeftNode(), nodes);
		}

		if (node != null) {
			nodes.add(tree.toString(node));
		}

		if (node.hasRightNode()) {
			inorder(tree, node.getRightNode(), nodes);
		}

		return nodes;
	}
	
	@Override
	public String getShortName() {
		return "DFS w/ Inorder";
	}

}
