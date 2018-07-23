package thiagodnf.tds.search;

import java.util.List;

import thiagodnf.tds.tree.Tree;

public abstract class Search<T> {

	protected Tree<T> tree;

	public Search(Tree<T> tree) {
		this.tree = tree;
	}

	public abstract List<String> execute();
}
