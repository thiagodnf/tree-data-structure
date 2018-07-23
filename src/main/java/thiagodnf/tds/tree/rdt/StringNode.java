package thiagodnf.tds.tree.rdt;

import thiagodnf.tds.node.Node;

public class StringNode extends Node<String> {

	public StringNode(String value) {
		super(value);
	}

	@Override
	public int compareTo(String value) {
		return 0;
	}

	@Override
	public String toString() {
		return String.valueOf(getValue());
	}
}
