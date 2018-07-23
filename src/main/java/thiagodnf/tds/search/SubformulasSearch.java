package thiagodnf.tds.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import thiagodnf.tds.tree.Node;
import thiagodnf.tds.tree.Tree;

/**
 * 
 * The subformulas of a formula are the formulas corresponding to the subtrees of its syntax tree.
 * 
 */
public class SubformulasSearch<T> extends Search<T>{

	public SubformulasSearch(Tree<T> tree) {
		super(tree);
	}
	
	@Override
	public List<Node<T>> execute() {
		
		List<String> formulas = new ArrayList<>();
		
		inorder(tree.getRoot(), new ArrayList<>(), formulas);
		
		System.out.println(formulas);
		return null;
	}

	public String inorder(Node<T> node, List<Node<T>> nodes, List<String> formulas) {

		if (node == null) {
			return "";
		}

		StringBuffer buffer = new StringBuffer();

		if (Arrays.asList("-").contains(node.toString())) {
			buffer.append(node.toString());

			if (node.hasLeftNode()) {
				buffer.append(inorder(node.getLeftNode(), nodes, formulas));
			}
		} else if (Arrays.asList("V", "&", "->").contains(node.toString())) {

			buffer.append("(");

			if (node.hasLeftNode()) {
				buffer.append(inorder(node.getLeftNode(), nodes, formulas));
			}

			buffer.append(" ").append(node.toString()).append(" ");

			if (node.hasRightNode()) {
				buffer.append(inorder(node.getRightNode(), nodes, formulas));
			}

			buffer.append(")");
		} else {
			buffer.append(node.toString());
		}

		String formula = buffer.toString();

		if (!formulas.contains(formula)) {
			formulas.add(formula);
		}

		return formula;
	}
}
