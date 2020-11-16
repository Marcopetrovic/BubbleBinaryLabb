package com.company;

public class Main {

    public static void main(String[] args) {
	BubbleSort bubbleSort = new BubbleSort();
	int[] bubble ={3, 6, 65, 11, 5, 1};
        System.out.println("\nBubblesort");
        bubbleSort.printSortedNumbers(bubble);

        BinarySearchTree theTree = new BinarySearchTree();

        theTree.addNode(50,"A");
        theTree.addNode(25,"B");
        theTree.addNode(15,"C");
        theTree.addNode(30,"D");
        theTree.addNode(75,"E");
        theTree.addNode(85,"F");

        System.out.println("\nPrint In Order");
        theTree.inOrderTraverseTree(theTree.root);
        System.out.println("\nPrint Pre Order");
        theTree.preOrderTraverseTree(theTree.root);
        System.out.println("\nPrint Post Order");
        theTree.postOrderTraverseTree(theTree.root);

        System.out.println("\nPrint Reverse Order");
        theTree.reverseOrderTraverseTree(theTree.root);

        System.out.println("\nRemove Key 25");
        theTree.delete(25);
        theTree.preOrderTraverseTree(theTree.root);
    }
}
