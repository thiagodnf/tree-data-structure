import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import thiagodnf.tds.gui.Visualize;
import thiagodnf.tds.search.BFSSearch;
import thiagodnf.tds.search.DFSWithInorderSearch;
import thiagodnf.tds.search.DFSWithPostOrderSearch;
import thiagodnf.tds.search.DFSWithPreOrderSearch;
import thiagodnf.tds.search.SubformulasSearch;
import thiagodnf.tds.tree.Tree;
import thiagodnf.tds.tree.bst.BinarySearchTree;
import thiagodnf.tds.tree.rdt.RecursiveDescentTree;

public class MainClass {
	
	private static final Logger LOGGER = Logger.getLogger(MainClass.class);
	
	@Parameter(names = { "-t", "--type" }, description = "The type of the tree")
	private String type = "BST";

	@Parameter(names = { "-i", "--input" }, description = "The input", required = true)
	private List<Integer> inputs = new ArrayList<>();

	@Parameter(names = "-gui", description = "Show the visualization")
	private boolean gui = false;

	@Parameter(names = { "-h", "--help" }, help = true)
	private boolean help;
	
	public static void main(String[] args) {
		
		MainClass main = new MainClass();
       
		JCommander jc = JCommander.newBuilder()
            .addObject(main)
            .programName(MainClass.class.getSimpleName())
            .build();
		
		jc.parse(args);

		if (main.help) {
			jc.usage();
		} else {
			main.run();
		}
	}
	
	public void run() {
		
		String input = "[->,[V,p,[-,p]],[&,r,q]]";
		
		Tree<String> tree = new RecursiveDescentTree();
		
		
		tree.add(input);
		
		
		
		
//		
//		Tree<Integer> tree = new BinarySearchTree<Integer>();
//
//		tree.add(inputs);
//		
//		LOGGER.info("---------Information---------------");
//		
//		LOGGER.info(String.format("%-12s %s", "Depth: ", tree.getDepth()));
//		LOGGER.info(String.format("%-12s %s", "# of Nodes: ", tree.getNumberOfNodes()));
//		LOGGER.info(String.format("%-12s %s", "Leaves: ", tree.getNumberOfLeaves()));
//		
//		LOGGER.info("--------------Search----------------");
//		
//		LOGGER.info(String.format("%-20s %s", "DFS w/ Pre-Order: ", new DFSWithPreOrderSearch<Integer>(tree).execute()));
//		LOGGER.info(String.format("%-20s %s", "DFS w/ Inorder: ", new DFSWithInorderSearch<Integer>(tree).execute()));
//		LOGGER.info(String.format("%-20s %s", "DFS w/ Post-Order: ", new DFSWithPostOrderSearch<Integer>(tree).execute()));
//		LOGGER.info(String.format("%-20s %s", "BFS: ", new BFSSearch<Integer>(tree).execute()));
//		
//		if (gui) {
			Visualize.show(tree);
//		}
			
		new SubformulasSearch<>(tree).execute();
	}
}
