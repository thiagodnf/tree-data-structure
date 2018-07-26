package thiagodnf.tds.node;

public class IntegerNode extends Node<Integer> {

	public IntegerNode(int value) {
		super(value);
	}

	@Override
	public int compareTo(Integer value) {
		return Integer.compare(getValue(), value);
	}

	@Override
	public String toString() {
		return String.valueOf(getValue());
	}
}
