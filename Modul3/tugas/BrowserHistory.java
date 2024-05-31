package StrukturData.Modul3.tugas;

import java.util.Scanner;

public class BrowserHistory
{
    private Node top;
    private Node previousTop;
    private String currentUrl;
    private Node currentNode;

    public static void main(String[] args)
    {
        BrowserHistory history = new BrowserHistory();
        Scanner scanner = new Scanner(System.in);
        String input;

        do
        {
            System.out.println("Browser History");
            System.out.println("1. Visit URL");
            System.out.println("2. Back");
            System.out.println("3. Forward");
            System.out.println("4. Tampilkan Current URl");
            System.out.println("5. Exit");
            System.out.print("Masukkan pilihan anda: ");
            input = scanner.nextLine();

            switch (input)
            {
                case "1":
                    System.out.print("Masukkan URL: ");
                    input = scanner.nextLine();
                    history.visitURL(input);
                    break;
                case "2":
                    history.back();
                    break;
                case "3":
                    history.forward();
                    break;
                case "4":
                    history.getCurrentURL();
                    break;
                case "5":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (!input.equals("5"));

        scanner.close();
    }

    public void visitURL(String url)
    {
        Node newNode = new Node(url);
        if (top == null) {
            top = newNode;
        } else {
            newNode.previous = top;
            top.next = newNode;
            top = newNode;
        }
        currentNode = top;
        currentUrl = top.getUrl();
    }

    public void back()
    {
        if (top == null)
        {
            System.out.println("Cannot go back. No previous URL.");
            return;
        }
        previousTop = top;
        top = top.getPrevious();
        if (top != null)
        {
            currentNode = top;
            currentUrl = top.getUrl();
        }
        else
        {
            currentUrl = null;
        }
    }

    public void forward()
    {
        if (top == null || top == previousTop)
        {
            System.out.println("Cannot go forward. No next URL.");
            return;
        }
        currentNode = top.getNext();
        currentUrl = currentNode.getUrl();
    }

    public void getCurrentURL()
    {
        if (currentNode != null) {
            System.out.println("Current URL: " + currentNode.getUrl());
        } else {
            System.out.println("Current URL: None");
        }
    }

    private static class Node
    {
        private Node previous;
        private Node next;
        private String url;

        public Node(String url)
        {
            this.url = url;
        }

        public Node getPrevious()
        {
            return previous;
        }

        public Node getNext()
        {
            return next;
        }

        public void setPrevious(Node previous)
        {
            this.previous = previous;
        }

        public void setNext(Node next)
        {
            this.next = next;
        }

        public String getUrl()
        {
            return url;
        }

    }
}



