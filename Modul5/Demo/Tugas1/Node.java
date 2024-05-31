package StrukturData.Modul5.Demo.Tugas1;

public class Node {
    private final int value;
    public Node leftChild;
    public Node rightChild;

    Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
