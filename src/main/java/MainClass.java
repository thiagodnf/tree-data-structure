import java.util.Arrays;

import thiagodnf.tds.gui.Visualize;
import thiagodnf.tds.search.BFSSearch;
import thiagodnf.tds.search.DFSWithInorderSearch;
import thiagodnf.tds.search.DFSWithPostOrderSearch;
import thiagodnf.tds.search.DFSWithPreOrderSearch;
import thiagodnf.tds.tree.Tree;
import thiagodnf.tds.tree.bst.BinarySearchTree;

public class MainClass {
	
	public static void main(String[] args) {
		
	
		Tree<Integer> tree = new BinarySearchTree<>();

//		tree.add(Arrays.asList(8, 3, 10, 1, 6, 4, 7, 14, 13));
		tree.add(Arrays.asList(60, 20, 70, 10, 40, 30, 50));
		
		System.out.println("---------Information---------------");
		
		System.out.printf("%-12s %s\n", "Depth: ", tree.getDepth());
		System.out.printf("%-12s %s\n", "# of Nodes: ", tree.getNumberOfNodes());
		System.out.printf("%-12s %s\n", "Leaves: ", tree.getNumberOfLeaves());
		
		System.out.println("--------------Search----------------");
		
		System.out.printf("%-20s %s\n", "DFS w/ Pre-Order: ", new DFSWithPreOrderSearch<Integer>(tree).execute());
		System.out.printf("%-20s %s\n", "DFS w/ Inorder: ", new DFSWithInorderSearch<Integer>(tree).execute());
		System.out.printf("%-20s %s\n", "DFS w/ Post-Order: ", new DFSWithPostOrderSearch<Integer>(tree).execute());
		System.out.printf("%-20s %s\n", "BFS: ", new BFSSearch<Integer>(tree).execute());
		
		Visualize.show(tree);
	}

}
