package thiagodnf.tds.tree.rdt;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import thiagodnf.tds.node.Node;
import thiagodnf.tds.node.StringNode;
import thiagodnf.tds.tree.Tree;

/**
 * Recursive Descent Parser for a very simple tree grammar. To use this
 * class, it is necessary use a parse tree generated from
 * http://logictools.org/index.html for building the parse tree. For example, if
 * the formula is (p ∨ ¬q) → (r ∧ q), then logictools website returns
 * [->,[V,p,[-,q]],[&,r,q]] as parse tree.
 * 
 * @author Thiago Ferreira
 * @since 2018-07-23
 * @version 1.0.0
 *
 */
public class RecursiveDescentTree extends Tree<String, Node<String>> {

	protected Pattern patternThreeForBoth = Pattern.compile("\\[(V|&|->),\\[(.*)\\],\\[(.*)\\]\\]");
	protected Pattern patternThreeForFirst = Pattern.compile("\\[(V|&|->),\\[(.*)\\],(.*)\\]");
	protected Pattern patternThreeForSecond = Pattern.compile("\\[(V|&|->),(.*),\\[(.*)\\]\\]");
	protected Pattern patternThreeForNone = Pattern.compile("\\[(V|&|->),(.*),(.*)\\]");
	
	protected Pattern patternTwoForFirst = Pattern.compile("\\[(-),\\[(.*)\\]\\]");
	protected Pattern patternTwoForNone = Pattern.compile("\\[(-),(.*)\\]");
	
	@Override
	public Node<String> add(Node<String> node, String value) {

		List<String> parsed = parseStr(value);

		if (node == null) {
			node = new StringNode(parsed.get(0));
		}

		if (Arrays.asList("V", "&", "->").contains(parsed.get(0))) {
			node.setLeftNode(add(node.getLeftNode(), parsed.get(1)));
			node.setRightNode(add(node.getRightNode(), parsed.get(2)));
		} else if (Arrays.asList("-").contains(parsed.get(0))) {
			node.setLeftNode(add(node.getLeftNode(), parsed.get(1)));
		}

		return node;
	}
	
	protected List<String> parseStr(String value) {

		if (!shouldExpand(value)) {
			return Arrays.asList(value);
		}

		String operation = value.substring(0, 3);

		if (Arrays.asList("[-,").contains(operation)) {
			return parseForTwo(value);
		} else if (Arrays.asList("[V,", "[&,", "[->").contains(operation)) {
			return parseForThree(value);
		}

		return Arrays.asList(value);
	}
	
	protected List<String> parseForTwo(String value) {

		Matcher m = patternTwoForFirst.matcher(value);

		if (m.find()) {
			return Arrays.asList(m.group(1), "[" + m.group(2) + "]");
		} else {
			m = patternTwoForNone.matcher(value);
			if (m.find()) {
				return Arrays.asList(m.group(1), m.group(2));
			} else {
				return Arrays.asList(value);
			}
		}
	}
	
	protected List<String> parseForThree(String value) {

		Matcher m = patternThreeForBoth.matcher(value);

		if (m.find()) {
			return Arrays.asList(m.group(1), "[" + m.group(2) + "]", "[" + m.group(3) + "]");
		} else {
			m = patternThreeForFirst.matcher(value);
			if (m.find()) {
				return Arrays.asList(m.group(1), "[" + m.group(2) + "]", m.group(3));
			} else {
				m = patternThreeForSecond.matcher(value);
				if (m.find()) {
					return Arrays.asList(m.group(1), m.group(2), "[" + m.group(3) + "]");
				} else {
					m = patternThreeForNone.matcher(value);
					if (m.find()) {
						return Arrays.asList(m.group(1), m.group(2), m.group(3));
					} else {
						return Arrays.asList(value);
					}
				}
			}
		}
	}
	
	protected boolean shouldExpand(String value) {
		return value.startsWith("[") && value.endsWith("]");
	}

	@Override
	public String getName() {
		return "Recursive Descent Tree";
	}	
}
