package thiagodnf.tds.runner;

import java.util.Arrays;
import java.util.List;

import thiagodnf.tds.node.Node;
import thiagodnf.tds.search.Search;
import thiagodnf.tds.search.SubformulasSearch;
import thiagodnf.tds.tree.Tree;
import thiagodnf.tds.tree.rdt.RecursiveDescentTree;

public class RDTRunner extends Runner<String, Node<String>> {
	
	@Override
	public List<String> parseInput(String input) {
		return Arrays.asList(input);
	}

	@Override
	public void appendSearchs(List<Search<String, Node<String>>> searchs) {
		searchs.add(new SubformulasSearch());
	}

	@Override
	public Tree<String, Node<String>> getTree() {
		return new RecursiveDescentTree();
	}
}
