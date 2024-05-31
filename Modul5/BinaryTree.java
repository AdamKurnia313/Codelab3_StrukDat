package StrukturData.Modul5;

import java.util.Scanner;

class Node {
    String data;
    Node left;
    Node right;

    public Node(String data) {
        this.data = data;
    }
}

public class BinaryTree {
    public Node root;

    public BinaryTree() {
        root = null;
    }

    public void addRoot(String data) {
        root = new Node(data);
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();

        System.out.println("Input Data");

        for (int i = 1; i <= 7; i++) {
            System.out.print("Data ke " + i + ": ");
            String input = sc.next();

            if (i == 1) {
                tree.addRoot(input);
            } else if (i == 2) {
                tree.root.left = new Node(input);
            } else if (i == 3) {
                tree.root.right = new Node(input);
            } else if (i == 4) {
                tree.root.left.left = new Node(input);
            } else if (i == 5) {
                tree.root.left.right = new Node(input);
            } else if (i == 6) {
                tree.root.right.right = new Node(input);
            } else if (i == 7) {
                tree.root.left.left.right = new Node(input);
            } else if (i == 8) {
                tree.root.left.left.left = new Node(input);
            }
        }

        System.out.println("\nPre Order: ");
        tree.preOrder(tree.root);
        System.out.println("\nIn Order: ");
        tree.inOrder(tree.root);
        System.out.println("\nPost Order: ");
        tree.postOrder(tree.root);
    }
}