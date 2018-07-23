# Tree Data Structure
Trees as Abstract Data Type in Java

## Tress

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


The output will be:

```sh
2018-07-23 11:05:49,496 INFO  (main) [Runner(run:25)] -------Tree Data Structure---------
2018-07-23 11:05:49,507 INFO  (main) [Runner(run:27)] Type:  Recursive Descent Tree
2018-07-23 11:05:49,508 INFO  (main) [Runner(run:28)] Input:  [[->,[V,p,[-,p]],[&,r,q]]]
2018-07-23 11:05:49,508 INFO  (main) [Runner(run:30)] ---------Information---------------
2018-07-23 11:05:49,511 INFO  (main) [Runner(run:32)] Depth       : 4
2018-07-23 11:05:49,512 INFO  (main) [Runner(run:33)] # of Nodes  : 8
2018-07-23 11:05:49,512 INFO  (main) [Runner(run:34)] # of Leaves : 4
2018-07-23 11:05:49,512 INFO  (main) [Runner(run:36)] --------------Search----------------
2018-07-23 11:05:49,516 INFO  (main) [Runner(run:43)] Subformulas         : [p, -p, (p V -p), r, q, (r & q), ((p V -p) -> (r & q))]
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
      Default: []
    -t, --type
      The type of the tree
      Default: BST
    -gui
      Show the visualization
      Default: false
```

## Example

```sh
java -jar -i 15,10,20,8,12,16,25 -gui
```

8, 3, 10, 1, 6, 4, 7, 14, 13

## Screenshot

### Gui

<img src="https://raw.githubusercontent.com/thiagodnf/tree-data-structure/master/src/main/resources/screenshot.png" />


### Console

```sh 
2018-07-22 20:55:15,434 INFO  (main) [MainClass(run:57)] ---------Information---------------
2018-07-22 20:55:15,449 INFO  (main) [MainClass(run:59)] Depth:       3
2018-07-22 20:55:15,449 INFO  (main) [MainClass(run:60)] # of Nodes:  7
2018-07-22 20:55:15,449 INFO  (main) [MainClass(run:61)] Leaves:      4
2018-07-22 20:55:15,449 INFO  (main) [MainClass(run:63)] --------------Search----------------
2018-07-22 20:55:15,453 INFO  (main) [MainClass(run:65)] DFS w/ Pre-Order:    [15, 10, 8, 12, 20, 16, 25]
2018-07-22 20:55:15,457 INFO  (main) [MainClass(run:66)] DFS w/ Inorder:      [8, 10, 12, 15, 16, 20, 25]
2018-07-22 20:55:15,459 INFO  (main) [MainClass(run:67)] DFS w/ Post-Order:   [8, 12, 10, 16, 25, 20, 15]
2018-07-22 20:55:15,461 INFO  (main) [MainClass(run:68)] BFS:                 [15, 10, 20, 8, 12, 16, 25]
```




