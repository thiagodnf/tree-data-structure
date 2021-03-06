package thiagodnf.tds.tree;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import thiagodnf.tds.gui.theme.Theme;
import thiagodnf.tds.node.Node;
import thiagodnf.tds.node.StringNode;

/**
 * A logical parse tree is an ordered, rooted tree that represents the syntactic
 * structure of a string according to some context-free grammar specific for
 * propositional logic. The implementation of this class was based on [2,3]
 * 
 * <p>
 * For conventional formula syntax:
 * </p>
 * 
 * <ul>
 * <li>negation symbols are -, ~</li>
 * <li>conjunction symbols are &, and</li>
 * <li>disjunction symbols are |, v, V, or</li>
 * <li>implication symbols are ->, =></li>
 * </ul>
 * 
 * <p>
 * Example of input:
 * </p>
 * 
 * <ul>
 * <li>(a -> b) & a & ~b</li>
 * <li>(~((~p)->~1))&(r->~(A->(~q)))</li>
 * </ul>
 * 
 * <p>
 * Obs.: There is no operator precedence;
 * </p>
 * 
 * <p>
 * References
 * </p>
 * <ul>
 * <li>[1] https://en.wikipedia.org/wiki/Parse_tree References:</li>
 * <li>[2] http://logictools.org/index.html</li>
 * <li>[3] https://www.geeksforgeeks.org/convert-infix-prefix-notation/</li>
 * </ul>
 * 
 * @author Thiago Ferreira
 * @since 2018-07-23
 * @version 1.0.0
 *
 */
public class LogicalParseTree extends ParseTree {

	public LogicalParseTree(Theme colorTheme) {
		super(colorTheme);
	}
	
	public LogicalParseTree() {
		super();
	}
	
	@Override
	public Node<String> add(Node<String> node, Object value) {

		String val = String.valueOf(value);
		
		//Format the formula before parse it
		
		val = val.replaceAll("->", "@");
		val = val.replaceAll("=>", "@");
		val = val.replaceAll("~", "-");
		val = val.replaceAll("and", "&");
		val = val.replaceAll("or", "%");
		val = val.replaceAll("\\|", "%");
		val = val.replaceAll("v", "%");
		val = val.replaceAll("V", "%");
		
		val = val.replaceAll("\\s+", "");
		
		val = String.format("(%s)", val);
		
		List<String> elements = Arrays.asList(val.split(""));
		
		Stack<StringNode> operators = new Stack<>();
		Stack<StringNode> operands = new Stack<>();

		for (String c : elements) {

			if (isOperand(c)) {
				operands.push(new StringNode(c));
			} else if (Arrays.asList("(").contains(c)) {
				operators.push(new StringNode("("));
			} else if (Arrays.asList(")").contains(c)) {

				while (operators.peek().compareTo("(") != 0) {

					String top = operators.peek().getValue();

					StringNode operator = operators.pop();

					if (isBinaryOperator(top)) {
						operator.setRightNode(operands.pop());
						operator.setLeftNode(operands.pop());
					}

					if (isUnaryOperator(top)) {
						operator.setLeftNode(operands.pop());
					}

					operands.push(operator);
				}

				// Remove '(' symbol
				operators.pop();
			} else if (isOperator(c)) {
				operators.push(new StringNode(c));
			} else {
				throw new IllegalArgumentException("Invalid character");
			}
		}
		
		return operands.pop();
	}
	
	protected boolean isTrueOrFalse(String c) {
		return Arrays.asList("0", "1").contains(c);
	}
	
	protected boolean isUnaryOperator(String c) {
		return Arrays.asList("-").contains(c);
	}

	protected boolean isBinaryOperator(String c) {
		return Arrays.asList("&", "%", "@").contains(c);
	}
	
	@Override
	protected boolean isOperand(String c) {
		return isVariable(c) || isTrueOrFalse(c);
	}

	@Override
	protected boolean isOperator(String c) {
		return isUnaryOperator(c) || isBinaryOperator(c);
	}
	
	@Override
	public String getName() {
		return "Logical Parse Tree";
	}
	
	@Override
	public String toString(Node<String> node) {
		if (node.getValue().compareTo("@") == 0) {
			return "\u2192";
		} else if (node.getValue().compareTo("&") == 0) {
			return "\u2227";
		} else if (node.getValue().compareTo("%") == 0) {
			return "\u2228";
		} else if (node.getValue().compareTo("-") == 0) {
			return "\u00AC";
		}

		return node.getValue();
	}
}
