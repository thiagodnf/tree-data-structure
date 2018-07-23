package thiagodnf.tds.runner;

import java.util.Arrays;
import java.util.List;

import thiagodnf.tds.node.Node;
import thiagodnf.tds.search.BFSSearch;
import thiagodnf.tds.search.DFSWithInorderSearch;
import thiagodnf.tds.search.DFSWithPostOrderSearch;
import thiagodnf.tds.search.DFSWithPreOrderSearch;
import thiagodnf.tds.search.Search;
import thiagodnf.tds.search.SubformulasSearch;
import thiagodnf.tds.tree.RecursiveDescentTree;
import thiagodnf.tds.tree.Tree;

public class RDTRunner extends Runner<String, Node<String>> {
	
	@Override
	public List<String> parseInput(String input) {
		return Arrays.asList(input);
	}

	@Override
	public void appendSearchs(List<Search<Object, Node<Object>>> searchs) {
		searchs.add(new DFSWithPreOrderSearch());
		searchs.add(new DFSWithInorderSearch());
		searchs.add(new DFSWithPostOrderSearch());
		searchs.add(new BFSSearch());
		searchs.add(new SubformulasSearch());
	}

	@Override
	public Tree<String, Node<String>> getTree() {
		return new RecursiveDescentTree();
	}
}
