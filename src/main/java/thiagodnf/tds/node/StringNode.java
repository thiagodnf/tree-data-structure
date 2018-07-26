package thiagodnf.tds.node;

public class StringNode extends Node<String> {

	public StringNode(String value) {
		super(value);
	}
	
	public StringNode(Character value) {
		super(String.valueOf(value));
	}

	@Override
	public int compareTo(String value) {
		return getValue().compareTo(value);
	}

	@Override
	public String toString() {
		return getValue();
	}
}
