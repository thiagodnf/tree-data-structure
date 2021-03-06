package thiagodnf.tds.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import thiagodnf.tds.node.Node;
import thiagodnf.tds.tree.Tree;

/**
 * 
 * The subformulas of a formula are the formulas corresponding to the subtrees
 * of its syntax tree. This is specific for propositional logic
 * 
 * @author Thiago Ferreira
 * @since 2018-07-23
 * @version 1.0.0
 */
public class SubformulasSearch extends Search<Object, Node<Object>>{

	@Override
	public List<String> execute(Tree<Object, Node<Object>> tree) {
		
		List<String> formulas = new ArrayList<>();
		
		parse(tree, tree.getRoot(), new ArrayList<>(), formulas);
		
		return formulas;
	}

	public String parse(Tree<Object, Node<Object>> tree, Node<Object> node, List<Node<Object>> nodes, List<String> formulas) {

		if (node == null) {
			return "";
		}

		StringBuffer buffer = new StringBuffer();

		if (Arrays.asList("\u00AC").contains(tree.toString(node))) {
			
			buffer.append(tree.toString(node));

			if (node.hasLeftNode()) {
				buffer.append(parse(tree, node.getLeftNode(), nodes, formulas));
			}
		} else if (Arrays.asList("\u2227", "\u2192", "\u2228").contains(tree.toString(node))) {

			buffer.append("(");

			if (node.hasLeftNode()) {
				buffer.append(parse(tree, node.getLeftNode(), nodes, formulas));
			}

			buffer.append(" ").append(tree.toString(node)).append(" ");

			if (node.hasRightNode()) {
				buffer.append(parse(tree, node.getRightNode(), nodes, formulas));
			}

			buffer.append(")");
		} else {
			buffer.append(tree.toString(node));
		}

		String formula = buffer.toString();

		if (!formulas.contains(formula)) {
			formulas.add(formula);
		}

		return formula;
	}

	@Override
	public String getShortName() {
		return "Subformulas";
	}
}
