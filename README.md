# Tree Data Structure
Trees as Abstract Data Type in Java

## Available Trees

This project implements the following trees:

- [Binary Search Tree (BST)](#binary-search-tree)
- [Recursive Descent Tree (RDT)](#recursive-descent-tree) 

## Binary Search Tree

Binary search trees (BST), sometimes called ordered or sorted binary trees, are a particular data structure that store integer number in memory, keeping their keys in sorted order. This one states that the key in each node must be greater than or equal to any key stored in the left sub-tree, and less than or equal to any key stored in the right sub-tree

### How to use it

If you want to visualize the set [15, 10, 20, 8, 12, 16, 25] as a BST, you can use it

```sh
$java -jar tree-data-structure -t BST -i 15,10,20,8,12,16,25 -gui
```

The output will be:

```sh
2018-07-23 11:01:39,893 INFO  (main) [Runner(run:25)] -------Tree Data Structure---------
2018-07-23 11:01:39,896 INFO  (main) [Runner(run:27)] Type:  Binary Search Tree
2018-07-23 11:01:39,897 INFO  (main) [Runner(run:28)] Input:  [15, 10, 20, 8, 12, 16, 25]
2018-07-23 11:01:39,897 INFO  (main) [Runner(run:30)] ---------Information---------------
2018-07-23 11:01:39,900 INFO  (main) [Runner(run:32)] Depth       : 3
2018-07-23 11:01:39,900 INFO  (main) [Runner(run:33)] # of Nodes  : 7
2018-07-23 11:01:39,900 INFO  (main) [Runner(run:34)] # of Leaves : 4
2018-07-23 11:01:39,901 INFO  (main) [Runner(run:36)] --------------Search----------------
2018-07-23 11:01:39,910 INFO  (main) [Runner(run:43)] DFS w/ Pre-Order    : [15, 10, 8, 12, 20, 16, 25]
2018-07-23 11:01:39,910 INFO  (main) [Runner(run:43)] DFS w/ Inorder      : [8, 10, 12, 15, 16, 20, 25]
2018-07-23 11:01:39,910 INFO  (main) [Runner(run:43)] DFS w/ Post-Order   : [8, 12, 10, 16, 25, 20, 15]
2018-07-23 11:01:39,911 INFO  (main) [Runner(run:43)] BFS:                : [15, 10, 20, 8, 12, 16, 25]
```

And the GUI:

<img src="https://raw.githubusercontent.com/thiagodnf/tree-data-structure/master/src/main/resources/screenshot-bst.png" />

## Recursive Descent Tree
Recursive Descent Parser for a very simple tree grammar. To use this tree, it is necessary use a parse tree generated from http://logictools.org/index.html for building the parse tree. 

For example, if the formula is (p ∨ ¬q) → (r ∧ q),
then logictools website returns [->,[V,p,[-,q]],[&,r,q]] as parse tree.

The output will be:

```sh
2018-07-23 11:26:44,939 INFO  (main) [Runner(run:25)] -------Tree Data Structure---------
2018-07-23 11:26:44,948 INFO  (main) [Runner(run:27)] Type:  Recursive Descent Tree
2018-07-23 11:26:44,948 INFO  (main) [Runner(run:28)] Input:  [[->,[V,p,[-,p]],[&,r,q]]]
2018-07-23 11:26:44,948 INFO  (main) [Runner(run:30)] ---------Information---------------
2018-07-23 11:26:44,950 INFO  (main) [Runner(run:32)] Depth       : 4
2018-07-23 11:26:44,951 INFO  (main) [Runner(run:33)] # of Nodes  : 8
2018-07-23 11:26:44,951 INFO  (main) [Runner(run:34)] # of Leaves : 4
2018-07-23 11:26:44,951 INFO  (main) [Runner(run:36)] --------------Search----------------
2018-07-23 11:26:44,957 INFO  (main) [Runner(run:43)] DFS w/ Pre-Order    : [->, V, p, -, p, &, r, q]
2018-07-23 11:26:44,957 INFO  (main) [Runner(run:43)] DFS w/ Inorder      : [p, V, p, -, ->, r, &, q]
2018-07-23 11:26:44,957 INFO  (main) [Runner(run:43)] DFS w/ Post-Order   : [p, p, -, V, r, q, &, ->]
2018-07-23 11:26:44,958 INFO  (main) [Runner(run:43)] BFS:                : [->, V, &, p, -, r, q, p]
2018-07-23 11:26:44,958 INFO  (main) [Runner(run:43)] Subformulas         : [p, -p, (p V -p), r, q, (r & q), ((p V -p) -> (r & q))]
```

And the GUI:

<img src="https://raw.githubusercontent.com/thiagodnf/tree-data-structure/master/src/main/resources/screenshot-rdt.png" />

## Generic Usage

```sh
Usage: MainClass [options]
  Options:
    -h, --help

  * -i, --input
      The input
    -t, --type
      The type of the tree. The options are [BST | RDT]
      Default: BST
    -gui
      Show the visualization
      Default: false

```

## Search Mechanism

This project implements the following search mechanism:

| Search                           | Class                     | Tree | Reference|
|----------------------------------|---------------------------|------|-|
| Depth-first Search w/ Pre-Order  | DFSWithPreOrderSearch     | All  | |
| Depth-first Search w/ Inorder    | DFSWithInorderOrderSearch | All  | |
| Depth-first Search w/ Post-Order | DFSWithPostOrderSearch    | All  | |
| Breadth-first Search             | BFSSearch                 | All  | |
| Subformulas                      | SubformulasSearch         | RDT  | [1] |

## References
[1]: https://www7.in.tum.de/um/courses/logic/SS11/folien/basics-4.pdf

