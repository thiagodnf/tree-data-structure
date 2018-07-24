package thiagodnf.tds.runner;

import java.util.List;

import thiagodnf.tds.node.Node;
import thiagodnf.tds.search.Search;
import thiagodnf.tds.search.SubformulasSearch;
import thiagodnf.tds.tree.LogicalParseTree;
import thiagodnf.tds.tree.Tree;

public class LPTRunner extends PTRunner {
	
	@Override
	public void appendSearchs(List<Search<Object, Node<Object>>> searchs) {
		super.appendSearchs(searchs);
		
		searchs.add(new SubformulasSearch());
	}

	@Override
	public Tree<String, Node<String>> getTree() {
		return new LogicalParseTree();
	}
}
