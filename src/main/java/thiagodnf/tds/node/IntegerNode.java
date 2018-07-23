package thiagodnf.tds.node;

public class IntegerNode extends Node<Integer> {

	public IntegerNode(int value) {
		super(value);
	}

	@Override
	public int compareTo(Integer value) {

		double diff = ((Integer) getValue()) - value;

		if (diff < 0) {
			return -1;
		} else if (diff > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return String.valueOf(getValue());
	}
}
