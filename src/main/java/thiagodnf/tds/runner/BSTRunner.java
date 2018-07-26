package thiagodnf.tds.runner;

import java.util.List;

import thiagodnf.tds.gui.theme.custom.BlueTheme;
import thiagodnf.tds.node.Node;
import thiagodnf.tds.search.BFSSearch;
import thiagodnf.tds.search.DFSWithInorderSearch;
import thiagodnf.tds.search.DFSWithPostOrderSearch;
import thiagodnf.tds.search.DFSWithPreOrderSearch;
import thiagodnf.tds.search.Search;
import thiagodnf.tds.tree.BinarySearchTree;
import thiagodnf.tds.tree.Tree;

public class BSTRunner extends Runner<Integer, Node<Integer>> {

	@Override
	public void appendSearchs(List<Search<Object, Node<Object>>> searchs) {
		searchs.add(new DFSWithPreOrderSearch());
		searchs.add(new DFSWithInorderSearch());
		searchs.add(new DFSWithPostOrderSearch());
		searchs.add(new BFSSearch());
	}

	@Override
	public Tree<Integer, Node<Integer>> getTree() {
		return new BinarySearchTree(new BlueTheme());
	}
}
