package StrukturData.Modul2.tugas;

import java.util.Scanner;

class Contact {
    String name;
    String phoneNumber;
    Contact next;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.next = null;
    }
}

class ContactManager {
    Contact head;

    public ContactManager() {
        this.head = null;
    }

    public void addContact(String name, String phoneNumber) {
        Contact newContact = new Contact(name, phoneNumber);
        if (head == null) {
            head = newContact;
        } else {
            Contact temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newContact;
        }
        System.out.println("Kontak berhasil ditambahkan: " + name);
    }

    public void displayContacts() {
        if (head == null) {
            System.out.println("Daftar kontak kosong.");
        } else {
            System.out.println("Daftar Kontak:");
            Contact temp = head;
            while (temp != null) {
                System.out.println("Nama: " + temp.name + "\nNomor Telepon: " + temp.phoneNumber);
                temp = temp.next;
            }
        }
    }

    public void searchContact(String name) {
        boolean found = false;
        Contact temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("Kontak ditemukan - Nama: " + temp.name + "\nNomor Telepon: " + temp.phoneNumber);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Kontak dengan nama '" + name + "' tidak ditemukan.");
        }
    }
}

public class tugas2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactManager contactManager = new ContactManager();

        while (true) {
            System.out.println("\nSelamat Datang di Manajemen Kontak!!!");
            System.out.println("1. Tambah Kontak");
            System.out.println("2. Tampilkan Daftar Kontak");
            System.out.println("3. Cari Kontak berdasarkan Nama");
            System.out.println("4. Keluar");
            System.out.print  ("Pilih opsi : ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan Nama: ");
                    String name = scanner.nextLine();
                    System.out.print("Masukkan Nomor Telepon: ");
                    String phoneNumber = scanner.nextLine();
                    contactManager.addContact(name, phoneNumber);
                    break;
                case 2:
                    contactManager.displayContacts();
                    break;
                case 3:
                    System.out.print("Masukkan Nama yang ingin dicari: ");
                    String searchName = scanner.nextLine();
                    contactManager.searchContact(searchName);
                    break;
                case 4:
                    System.out.println("Program berakhir.");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
    }
}

