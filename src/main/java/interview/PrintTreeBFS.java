package interview;

import java.util.LinkedList;

public class PrintTreeBFS {

    public static void main(final String[] args) {
        // Create a Binary Search Tree
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert('A');
        bst.insert('B');
        bst.insert('C');
        bst.insert('D');
        bst.insert('E');
        bst.insert('F');
        bst.insert('G');
        bst.printBFS(bst.root);
        bst.vals.forEach(System.out::println);
    }

    static class Node {
        int key;
        Node left;
        Node right;
        Node parent;

        Node(char val) {
            this.key = val;
            left = null;
            right = null;
            parent = null;
        }
    }

    static class BinarySearchTree {

        Node root;
        final LinkedList<Integer> vals = new LinkedList<>();

        /**
         * Assuming you have a binary tree data structure where each node contains character, like this
         *
         *                 A
         *               /   \
         *             B       C
         *           /   \    /  \
         *          D     E  F    G
         *         .
         *         .
         *         .
         *
         * Write a Java program that will print the node values like this:
         *
         * A
         * BC
         * DEFG
         * ...
         */
        void printBFS(final Node root) {
            if (root == null) {
                System.out.println("End");
            }
            vals.addLast(root.key); // put root at head
            if (root.left != null) {
                printBFS(root.left);
            }
            if (root.right != null) {
                printBFS(root.right);
            }
        }

        //  inserts a new node with the given number in the
        //  correct place in the tree
        void insert(char key) {

            // 1) If the tree is empty, create the root
            if (this.root == null) {
                this.root = new Node(key);
                return;
            }

            // 2) Otherwise, create a node with the key
            //    and traverse down the tree to find where to
            //    to insert the new node
            Node currentNode = this.root;
            Node newNode = new Node(key);

            while (currentNode != null) {
                if (key < currentNode.key) {
                    if (currentNode.left == null) {
                        currentNode.left = newNode;
                        newNode.parent = currentNode;
                        break;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else {
                    if (currentNode.right == null) {
                        currentNode.right = newNode;
                        newNode.parent = currentNode;
                        break;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
        }
    }


}
