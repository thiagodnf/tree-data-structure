package thiagodnf.tds.search;

import java.util.List;

import thiagodnf.tds.node.Node;
import thiagodnf.tds.tree.Tree;

public abstract class Search<S, T extends Node<S>> {

	public abstract List<String> execute(Tree<S, Node<S>> tree);

	public abstract String getShortName();
}
