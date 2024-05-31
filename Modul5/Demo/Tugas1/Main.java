package StrukturData.Modul5.Demo.Tugas1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Scanner input = new Scanner(System.in);


        System.out.print("Berapa banyak key yang ingin anda masukkan?: ");
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Masukkan Key : ");
            int key = input.nextInt();
            bt.addNote(new Node(key));
        }

        System.out.println("\nPre Order: ");
        bt.preOrder(bt.root);
        System.out.println("\nIn Order: ");
        bt.inOrder(bt.root);
        System.out.println("\nPost Order: ");
        bt.postOrder(bt.root);
    }
}
