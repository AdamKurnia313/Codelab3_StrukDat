package StrukturData.Modul3.codlab;

import java.util.Scanner;

class Stack {
    protected String[] stackArray;
    protected int maxSize;
    protected int top;

    public Stack(int size) {
        maxSize = size;
        stackArray = new String[maxSize];
        top = -1;
    }

    public void push(String url) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push more URLs.");
        } else {
            stackArray[++top] = url;
        }
    }

    public String pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No URL to pop.");
            return null;
        } else {
            return stackArray[top--];
        }
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No URL to peek.");
            return null;
        } else {
            return stackArray[top];
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }
}

class BrowserHistory {
    private Stack backStack;
    private Stack forwardStack;

    public BrowserHistory(int capacity) {
        backStack = new Stack(capacity);
        forwardStack = new Stack(capacity);
    }

    public void visitURL(String url) {
        backStack.push(url);
        forwardStack = new Stack(backStack.maxSize); // Clear forwardStack when visiting new URL
    }

    public String back() {
        if (!backStack.isEmpty()) {
            String currentUrl = backStack.pop();
            forwardStack.push(currentUrl);
            return backStack.peek();
        } else {
            return "No previous URL";
        }
    }

    public String forward() {
        if (!forwardStack.isEmpty()) {
            String nextUrl = forwardStack.pop();
            backStack.push(nextUrl);
            return nextUrl;
        } else {
            return "No forward URL";
        }
    }

    public String getCurrentURL() {
        if (!backStack.isEmpty()) {
            return backStack.peek();
        } else {
            return "No URL currently accessed";
        }
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory(10); // Capacity of 10 URLs
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Visit URL");
            System.out.println("2. Back");
            System.out.println("3. Forward");
            System.out.println("4. Current URL");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter URL to visit: ");
                    scanner.nextLine(); // Consume newline
                    input = scanner.nextLine();
                    browserHistory.visitURL(input);
                    break;
                case 2:
                    System.out.println("Back to: " + browserHistory.back());
                    break;
                case 3:
                    System.out.println("Forward to: " + browserHistory.forward());
                    break;
                case 4:
                    System.out.println("Current URL: " + browserHistory.getCurrentURL());
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
