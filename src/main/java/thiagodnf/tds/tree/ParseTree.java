package thiagodnf.tds.tree;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import thiagodnf.tds.gui.theme.Theme;
import thiagodnf.tds.node.Node;
import thiagodnf.tds.node.StringNode;

/**
 * A parse tree is an ordered, rooted tree that represents the syntactic
 * structure of a string according to some context-free grammar[1]. The
 * implementation of this class was based on [2,3]
 * 
 * <ul>
 * <li>[1] https://en.wikipedia.org/wiki/Parse_tree References:</li>
 * <li>[2] http://interactivepython.org/runestone/static/pythonds/BasicDS/InfixPrefixandPostfixExpressions.html</li>
 * <li>[3] https://www.geeksforgeeks.org/convert-infix-prefix-notation/</li>
 * </ul>
 * 
 * @author Thiago Ferreira
 * @since 2018-07-23
 * @version 1.0.0
 *
 */
public class ParseTree extends Tree<String, Node<String>> {

	public ParseTree(Theme colorTheme) {
		super(colorTheme);
	}
	
	public ParseTree() {
		super();
	}
	
	@Override
	public Node<String> add(Node<String> node, Object value) {
		
		String val = String.valueOf(value);

		val = String.format("(%s)", val);
		
		List<String> elements = Arrays.asList(val.split("\\s*"));
		
		Stack<StringNode> operators = new Stack<>();
		Stack<StringNode> operands = new Stack<>();

		for (String c : elements) {

			if (isOperand(c)) {
				operands.push(new StringNode(c));
			} else if (Arrays.asList("(").contains(c)) {
				operators.push(new StringNode("("));
			} else if (Arrays.asList(")").contains(c)) {

				while (operators.peek().compareTo("(") != 0) {

					StringNode operator = operators.pop();

					operator.setRightNode(operands.pop());
					operator.setLeftNode(operands.pop());
			
					operands.push(operator);
				}

				// Remove '(' symbol
				operators.pop();
			} else if (isOperator(c)) {
				
				if (getPriority(c) <= getPriority(operators.peek().getValue())) {
					StringNode operator = operators.pop();
					operators.push(new StringNode(c));
					operators.push(operator);
				} else {
					operators.push(new StringNode(c));
				}
				
			} else {
				throw new IllegalArgumentException("Invalid character");
			}
		}
		
		return operands.pop();
	}
	
	protected boolean isOperand(String c) {
		return isVariable(c) || isNumber(c);
	}
	
	protected boolean isNumber(String c) {
		
		Pattern pattern = Pattern.compile("^\\d*$");

        Matcher matcher = pattern.matcher(c);
        
        return matcher.matches();
	}
	
	protected boolean isVariable(String c) {
		
		Pattern pattern = Pattern.compile("^[a-zA-Z]+\\w*$");

        Matcher matcher = pattern.matcher(c);
        
        return matcher.matches();
	}
	
	protected boolean isOperator(String c) {
		return Arrays.asList("+", "-", "*", "/").contains(c);
	}
	
	protected int getPriority(String c) {
		if (Arrays.asList("-", "+").contains(c)) {
			return 1;
		} else if (Arrays.asList("*", "/").contains(c)) {
			return 2;
		} else {
			return 0;
		}
	}
	
	@Override
	public String getName() {
		return "Parse Tree";
	}

	@Override
	public List<Object> parseInput(String input) {
		return Arrays.asList(input);
	}	
	
	@Override
	public String toString(Node<String> node) {
		return node.getValue();
	}
}
