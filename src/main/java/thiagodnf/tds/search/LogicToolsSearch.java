package thiagodnf.tds.search;

import java.util.Arrays;
import java.util.List;

import thiagodnf.tds.node.Node;
import thiagodnf.tds.tree.Tree;

public class LogicToolsSearch extends Search<Object, Node<Object>>{

	@Override
	public List<String> execute(Tree<Object, Node<Object>> tree) {
		return Arrays.asList(append(tree, tree.getRoot()));
	}

	public String append(Tree<Object, Node<Object>> tree, Node<Object> node) {

		if (node == null) {
			return "";
		}

		if (node.isLeaf()) {
			return tree.toString(node);
		}

		StringBuffer buffer = new StringBuffer();

		buffer.append("[");
		buffer.append(tree.toString(node));

		if (node.hasLeftNode()) {
			buffer.append(",").append(append(tree, node.getLeftNode()));
		}

		if (node.hasRightNode()) {
			buffer.append(",").append(append(tree, node.getRightNode()));
		}

		buffer.append("]");

		return buffer.toString();
	}

	@Override
	public String getShortName() {
		return "LogicTools";
	}
}
