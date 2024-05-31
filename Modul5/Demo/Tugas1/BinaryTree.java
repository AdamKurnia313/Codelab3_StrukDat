package StrukturData.Modul5.Demo.Tugas1;

public class BinaryTree {
    public Node root;

    public void addNote(Node node) {
        if (root == null) {
            root = node;
        } else {
            insertNode(root, node);
        }
    }

    public void insertNode(Node parent, Node node) {
        if (parent.getValue() > node.getValue()) {
            if (parent.leftChild == null) {
                parent.leftChild = node;
            } else {
                insertNode(parent.leftChild, node);
            }
        } else {
            if (parent.rightChild == null) {
                parent.rightChild = node;
            } else {
                insertNode(parent.rightChild, node);
            }
        }
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.leftChild);
            System.out.print(node.getValue() + " ");
            inOrder(node.rightChild);
        }
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.leftChild);
            postOrder(node.rightChild);
            System.out.print(node.getValue() + " ");
        }
    }
}
