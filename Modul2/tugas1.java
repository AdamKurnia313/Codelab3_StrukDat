package StrukturData.Modul2;

import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    //A1
    private String name;
    //A2
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

class ContactManager {
    //M
    private ArrayList<Contact> contacts;

    public ContactManager() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);//Aturan kedua
        System.out.println("Kontak berhasil ditambahkan: " + contact.getName());
    }

    public void displayContacts() {         //Aturan Kedua
        if (contacts.isEmpty()) {
            System.out.println("Daftar kontak kosong.");
        } else {
            System.out.println("Daftar Kontak:");
            for (Contact contact : contacts) {
                System.out.println("Nama: " + contact.getName() + "\nNomor Telepon: " + contact.getPhoneNumber());
            }
        }
    }

    public void searchContact(String name) {    //Aturan Kedua
        boolean found = false;
        for (Contact contact : contacts) {
            //Pesan yang jelas diberikan ketika kontak ditemukan atau tidak ditemukan saat melakukan pencarian kontak. (Aturan ke 4).
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("Kontak ditemukan - Nama : " + contact.getName() + "\nNomor Telepon : " + contact.getPhoneNumber());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Kontak dengan nama '" + name + "' tidak ditemukan.");
        }
    }
}

public class tugas1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactManager contactManager = new ContactManager();

        //Program harus dapat berjalan secara berulang sehingga pengguna dapat terus mengeksekusi perintah hingga memilih untuk keluar. (Aturan ke 3).
        while (true) {
            System.out.println("\nSelamat datang di Manajemen Kontak!");
            System.out.println("1. Tambah Kontak");
            System.out.println("2. Tampilkan Daftar Kontak");
            System.out.println("3. Cari Kontak");
            System.out.println("4. Keluar");
            System.out.print  ("Pilih Menu : ");
            //Pastikan untuk menangani input pengguna dengan baik dan memberikan pesan yang jelas ketika kontak ditemukan atau tidak ditemukan. (Aturan ke 4).
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan Nama Kontak: ");
                    String name = scanner.nextLine();
                    System.out.print("Masukkan Nomor Telepon: ");
                    String phoneNumber = scanner.nextLine();
                    contactManager.addContact(new Contact(name, phoneNumber));
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

