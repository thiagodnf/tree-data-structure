import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import thiagodnf.tds.gui.Visualize;
import thiagodnf.tds.search.BFSSearch;
import thiagodnf.tds.search.DFSWithInorderSearch;
import thiagodnf.tds.search.DFSWithPostOrderSearch;
import thiagodnf.tds.search.DFSWithPreOrderSearch;
import thiagodnf.tds.tree.Tree;
import thiagodnf.tds.tree.bst.BinarySearchTree;

public class MainClass {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MainClass.class);
	
	public static void main(String[] args) {
		
		Tree<Integer> tree = new BinarySearchTree<>();

//		tree.add(Arrays.asList(8, 3, 10, 1, 6, 4, 7, 14, 13));
		tree.add(Arrays.asList(60, 20, 70, 10, 40, 30, 50));
		
		LOGGER.info("---------Information---------------");
		
		LOGGER.info(String.format("%-12s %s", "Depth: ", tree.getDepth()));
		LOGGER.info(String.format("%-12s %s", "# of Nodes: ", tree.getNumberOfNodes()));
		LOGGER.info(String.format("%-12s %s", "Leaves: ", tree.getNumberOfLeaves()));
		
		LOGGER.info("--------------Search----------------");
		
		LOGGER.info(String.format("%-20s %s", "DFS w/ Pre-Order: ", new DFSWithPreOrderSearch<Integer>(tree).execute()));
		LOGGER.info(String.format("%-20s %s", "DFS w/ Inorder: ", new DFSWithInorderSearch<Integer>(tree).execute()));
		LOGGER.info(String.format("%-20s %s", "DFS w/ Post-Order: ", new DFSWithPostOrderSearch<Integer>(tree).execute()));
		LOGGER.info(String.format("%-20s %s", "BFS: ", new BFSSearch<Integer>(tree).execute()));
		
		Visualize.show(tree);
	}
}
