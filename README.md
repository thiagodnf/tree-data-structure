# Tree Data Structure
Trees as Abstract Data Type in Java

## Usage

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
```sh




