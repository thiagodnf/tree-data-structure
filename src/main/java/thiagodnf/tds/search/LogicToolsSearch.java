package thiagodnf.tds.search;

import java.util.Arrays;
import java.util.List;

import thiagodnf.tds.node.Node;
import thiagodnf.tds.tree.Tree;

public class LogicToolsSearch extends Search<Object, Node<Object>>{

	@Override
	public List<String> execute(Tree<Object, Node<Object>> tree) {
		return Arrays.asList(append(tree.getRoot()));
	}

	public String append(Node<Object> node) {

		if (node == null) {
			return "";
		}

		if (node.isLeaf()) {
			return String.valueOf(node.getValue());
		}

		StringBuffer buffer = new StringBuffer();

		buffer.append("[");
		buffer.append(node.getValue());

		if (node.hasLeftNode()) {
			buffer.append(",").append(append(node.getLeftNode()));
		}

		if (node.hasRightNode()) {
			buffer.append(",").append(append(node.getRightNode()));
		}

		buffer.append("]");

		return buffer.toString();
	}

	@Override
	public String getShortName() {
		return "LogicTools";
	}
}
