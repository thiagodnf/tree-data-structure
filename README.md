# Tree Data Structure
Trees as Abstract Data Type in Java

[![Build Status](https://travis-ci.org/thiagodnf/tree-data-structure.svg?branch=master)](https://travis-ci.org/thiagodnf/tree-data-structure)
[![codecov](https://codecov.io/gh/thiagodnf/tree-data-structure/branch/master/graph/badge.svg)](https://codecov.io/gh/thiagodnf/tree-data-structure)


## Available Trees

This project implements the following trees:

- [Binary Search Tree (BST)](#binary-search-tree)
- [Parse Tree (PT)](#parse-tree) 
- [Logical Parse Tree (LPT)](#logical-parse-tree) 

## Binary Search Tree

Binary search trees (BST), sometimes called ordered or sorted binary trees, are a particular data structure that store integer number in memory, keeping their keys in sorted order. This one states that the key in each node must be greater than or equal to any key stored in the left sub-tree, and less than or equal to any key stored in the right sub-tree

### How to use it

If you want to visualize the set [10,8,9,12,14,13] as a BST, you can use it

```sh
$java -jar tree-data-structure -t BST --gui -i 10,8,9,12,14,13
```

The output will be:

```sh
2018-07-24 21:55:13,614 INFO  (main) [Runner(run:26)] -------Tree Data Structure---------
2018-07-24 21:55:13,616 INFO  (main) [Runner(run:28)] Tree Type: : Binary Search Tree
2018-07-24 21:55:13,617 INFO  (main) [Runner(run:29)] Input:     : [10, 8, 9, 12, 14, 13]
2018-07-24 21:55:13,617 INFO  (main) [Runner(run:31)] ---------Information---------------
2018-07-24 21:55:13,619 INFO  (main) [Runner(run:33)] Depth       : 4
2018-07-24 21:55:13,619 INFO  (main) [Runner(run:34)] # of Nodes  : 6
2018-07-24 21:55:13,620 INFO  (main) [Runner(run:35)] # of Leaves : 2
2018-07-24 21:55:13,620 INFO  (main) [Runner(run:37)] --------------Search----------------
2018-07-24 21:55:13,629 INFO  (main) [Runner(run:44)] DFS w/ Pre-Order    : [10, 8, 9, 12, 14, 13]
2018-07-24 21:55:13,630 INFO  (main) [Runner(run:44)] DFS w/ Inorder      : [8, 9, 10, 12, 13, 14]
2018-07-24 21:55:13,630 INFO  (main) [Runner(run:44)] DFS w/ Post-Order   : [9, 8, 13, 14, 12, 10]
2018-07-24 21:55:13,631 INFO  (main) [Runner(run:44)] BFS                 : [10, 8, 12, 9, 14, 13]
```

And the GUI:

<img src="https://raw.githubusercontent.com/thiagodnf/tree-data-structure/master/src/main/resources/screenshot-bst.png" />

## Parse Tree

A parse tree is an ordered, rooted tree that represents the syntactic structure of a string according to some context-free grammar.


### How to use it

If you want to visualize the set (A+B)*(C+D) as a PT, you can use it

```sh
$java -jar tree-data-structure -t PT --gui -i  (A+B)*(C+D)
```


The output will be:

```sh
2018-07-24 22:03:56,478 INFO  (main) [Runner(run:26)] -------Tree Data Structure---------
2018-07-24 22:03:56,481 INFO  (main) [Runner(run:28)] Tree Type: : Parse Tree
2018-07-24 22:03:56,482 INFO  (main) [Runner(run:29)] Input:     : [(A+B)*(C+D)]
2018-07-24 22:03:56,482 INFO  (main) [Runner(run:31)] ---------Information---------------
2018-07-24 22:03:56,485 INFO  (main) [Runner(run:33)] Depth       : 3
2018-07-24 22:03:56,485 INFO  (main) [Runner(run:34)] # of Nodes  : 7
2018-07-24 22:03:56,485 INFO  (main) [Runner(run:35)] # of Leaves : 4
2018-07-24 22:03:56,486 INFO  (main) [Runner(run:37)] --------------Search----------------
2018-07-24 22:03:56,496 INFO  (main) [Runner(run:44)] DFS w/ Pre-Order    : [*, +, A, B, +, C, D]
2018-07-24 22:03:56,497 INFO  (main) [Runner(run:44)] DFS w/ Inorder      : [A, +, B, *, C, +, D]
2018-07-24 22:03:56,497 INFO  (main) [Runner(run:44)] DFS w/ Post-Order   : [A, B, +, C, D, +, *]
2018-07-24 22:03:56,497 INFO  (main) [Runner(run:44)] BFS                 : [*, +, +, A, B, C, D]
```

And the GUI:

<img src="https://raw.githubusercontent.com/thiagodnf/tree-data-structure/master/src/main/resources/screenshot-pt.png" />


## Logical Parse Tree

A logical parse tree is an ordered, rooted tree that represents the syntactic structure of a string according to some context-free grammar specific for propositional logic. 
 
### How to use it

If you want to visualize the set (p->(qVr))->(p&~p) as a LPT, you can use it

```sh
$java -jar tree-data-structure -t LPT --gui -i (p->(qVr))->(p&~p)
```

The output will be:

```sh
2018-07-24 21:58:36,621 INFO  (main) [Runner(run:26)] -------Tree Data Structure---------
2018-07-24 21:58:36,624 INFO  (main) [Runner(run:28)] Tree Type: : Logical Parse Tree
2018-07-24 21:58:36,624 INFO  (main) [Runner(run:29)] Input:     : [(p->(qVr))->(p&~p)]
2018-07-24 21:58:36,625 INFO  (main) [Runner(run:31)] ---------Information---------------
2018-07-24 21:58:36,627 INFO  (main) [Runner(run:33)] Depth       : 4
2018-07-24 21:58:36,627 INFO  (main) [Runner(run:34)] # of Nodes  : 10
2018-07-24 21:58:36,627 INFO  (main) [Runner(run:35)] # of Leaves : 5
2018-07-24 21:58:36,627 INFO  (main) [Runner(run:37)] --------------Search----------------
2018-07-24 21:58:36,640 INFO  (main) [Runner(run:44)] DFS w/ Pre-Order    : [→, →, p, ∨, q, r, ∧, p, ¬, p]
2018-07-24 21:58:36,640 INFO  (main) [Runner(run:44)] DFS w/ Inorder      : [p, →, q, ∨, r, →, p, ∧, p, ¬]
2018-07-24 21:58:36,640 INFO  (main) [Runner(run:44)] DFS w/ Post-Order   : [p, q, r, ∨, →, p, p, ¬, ∧, →]
2018-07-24 21:58:36,641 INFO  (main) [Runner(run:44)] BFS                 : [→, →, ∧, p, ∨, p, ¬, q, r, p]
2018-07-24 21:58:36,641 INFO  (main) [Runner(run:44)] Subformulas         : [p, q, r, (q ∨ r), (p → (q ∨ r)), ¬p, (p ∧ ¬p), ((p → (q ∨ r)) → (p ∧ ¬p))]
2018-07-24 21:58:36,641 INFO  (main) [Runner(run:44)] LogicTools          : [[→,[→,p,[∨,q,r]],[∧,p,[¬,p]]]]
```

And the GUI:

<img src="https://raw.githubusercontent.com/thiagodnf/tree-data-structure/master/src/main/resources/screenshot-lpt.png" />

## Generic Usage

```sh
Usage: MainClass [options]
  Options:
    -g, --gui
      Show the tree visualization
      Default: false
    -h, --help

  * -i, --input
      The input
    -t, --type
      The type of the tree. The options are [BST | PT | LPT]
      Default: BST
```

## Search Mechanism

This project implements the following search mechanism:

| Search                           | Class                     | Tree | Reference|
|----------------------------------|---------------------------|------|-|
| Depth-first Search w/ Pre-Order  | DFSWithPreOrderSearch     | All  | |
| Depth-first Search w/ Inorder    | DFSWithInorderOrderSearch | All  | |
| Depth-first Search w/ Post-Order | DFSWithPostOrderSearch    | All  | |
| Breadth-first Search             | BFSSearch                 | All  | |
| Subformulas                      | SubformulasSearch         | LPT  | [1] |
| LogicTools                       | LogicToolsSearch          | LPT  | [2] |

## References
[1]: https://www7.in.tum.de/um/courses/logic/SS11/folien/basics-4.pdf
[2]: http://logictools.org/index.html

