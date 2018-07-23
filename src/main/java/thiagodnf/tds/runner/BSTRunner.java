package thiagodnf.tds.runner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
	public List<Integer> parseInput(String input) {
		return Arrays.asList(input.split(","))
			.stream()
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}

	@Override
	public void appendSearchs(List<Search<Object, Node<Object>>> searchs) {
		searchs.add(new DFSWithPreOrderSearch());
		searchs.add(new DFSWithInorderSearch());
		searchs.add(new DFSWithPostOrderSearch());
		searchs.add(new BFSSearch());
	}

	@Override
	public Tree<Integer, Node<Integer>> getTree() {
		return new BinarySearchTree();
	}
}
