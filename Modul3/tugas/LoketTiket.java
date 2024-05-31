package StrukturData.Modul3.tugas;

import java.util.Scanner;

class Ticket {
    private static int count = 1;
    private int ticketNumber;
    private String name;
    private int quantity;

    public Ticket(String name, int quantity) {
        this.ticketNumber = count++;
        this.name = name;
        this.quantity = quantity;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Ticket Number: " + ticketNumber + ", Name: " + name + ", Quantity: " + quantity;
    }
}

class Queue {
    private Ticket[] tickets;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        this.tickets = new Ticket[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(Ticket ticket) {
        if (isFull()) {
            System.out.println("Queue penuh. tidak bisa menambah tickets.");
        } else {
            rear = (rear + 1) % capacity;
            tickets[rear] = ticket;
            size++;
            System.out.println("Ticket sukses ditambahkan: " + ticket);
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue kosong. Tidak bisa menghapus ticket.");
        } else {
            Ticket removedTicket = tickets[front];
            front = (front + 1) % capacity;
            size--;
            System.out.println("Ticket sukses dihapus: " + removedTicket);
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue kosong.");
        } else {
            System.out.println("Jumlah Tiket sekarang di Queue:");
            for (int i = 0; i < size; i++) {
                int index = (front + i) % capacity;
                System.out.println(tickets[index]);
            }
        }
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

public class LoketTiket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue ticketQueue = new Queue(5);

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nTicket Queue Menu:");
            System.out.println("1. Tambah Ticket");
            System.out.println("2. Display Tickets");
            System.out.println("3. Hapus Ticket");
            System.out.println("4. Exit");
            System.out.print("Pilih Tiket: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Masukkan Nama: ");
                    scanner.nextLine(); // Consume newline
                    String name = scanner.nextLine();
                    System.out.print("Masukkan quantity: ");
                    int quantity = scanner.nextInt();
                    Ticket ticket = new Ticket(name, quantity);
                    ticketQueue.enqueue(ticket);
                    break;
                case 2:
                    ticketQueue.display();
                    break;
                case 3:
                    ticketQueue.dequeue();
                    break;
                case 4:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Opsi Invalid.");
            }
        }

        scanner.close();
        System.out.println("Program selesai.");
    }
}
