package interview;

import java.util.Scanner;

public class HeightBinaryTree {

    public static int height(Node root) {

        // base case
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        // else there is no where to go on the right so recurse on left node
        else if (root.left != null && root.right == null) {
            return 1 + height(root.left);
        }
        // else is no where to go on the left so recurse on right node
        else if (root.left == null && root.right != null) {
            return 1 + height(root.right);
        }
        // else the height of a tree is max of h(l) and h(r)
        else {
            return 1 + Math.max(height(root.right), height(root.left));
        }

    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

