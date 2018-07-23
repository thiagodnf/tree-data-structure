package thiagodnf.tds.runner;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import thiagodnf.tds.gui.Visualize;
import thiagodnf.tds.node.Node;
import thiagodnf.tds.search.Search;
import thiagodnf.tds.tree.Tree;

public abstract class Runner<S, T extends Node<S>> {
	
	private static final Logger LOGGER = Logger.getLogger(Runner.class);
	
	public void run(String input, boolean gui) {
		
		Tree tree = getTree();
		
		List<S> inputs = parseInput(input);
		
		tree.add(inputs);
		
		LOGGER.info("-------Tree Data Structure---------");
		
		LOGGER.info(String.format("%-5s %s", "Type: ", tree.getName()));
		LOGGER.info(String.format("%-5s %s", "Input: ", inputs));
		
		LOGGER.info("---------Information---------------");
		
		LOGGER.info(String.format("%-12s: %s", "Depth", tree.getDepth()));
		LOGGER.info(String.format("%-12s: %s", "# of Nodes", tree.getNumberOfNodes()));
		LOGGER.info(String.format("%-12s: %s", "# of Leaves", tree.getNumberOfLeaves()));
		
		LOGGER.info("--------------Search----------------");
		
		List<Search<Object,Node<Object>>> searchs = new ArrayList<>();
		
		appendSearchs(searchs);
		
		for(Search<Object,Node<Object>> search : searchs) {
			LOGGER.info(String.format("%-20s: %s", search.getShortName(), search.execute(tree)));
		}
		
		if (gui) {
			Visualize.show(tree);
		}
	}
	
	public abstract Tree<S,T> getTree();
	
	public abstract List<S> parseInput(String input);
	
	public abstract void appendSearchs(List<Search<Object,Node<Object>>> searchs);

}
