package StrukturData.Modul4.tugas.K2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import StrukturData.Modul4.tugas.K1.OnlineVotingSystem;

public class DataPemilih {
    private Map<String, ArrayList<String>> userDetails;
    private Map<String, String> users;
    private boolean loggedIn;
    private OnlineVotingSystem votingSystem;

    public DataPemilih() {
        this.userDetails = new HashMap<>();
        this.users = new HashMap<>();
        this.loggedIn = false;
        this.votingSystem = new OnlineVotingSystem();
        // Contoh penambahan kandidat
        this.votingSystem.addCandidate("Kandidat A");
        this.votingSystem.addCandidate("Kandidat B");
        this.votingSystem.addCandidate("Kandidat C");
    }

    public void register(String email, String password, String nama, String nik) {
        if (isValidEmail(email) && !users.containsKey(email) && !userDetails.containsKey(email)) {
            users.put(email, password);
            ArrayList<String> userData = new ArrayList<>();
            userData.add(nama);
            userData.add(nik);
            userDetails.put(email, userData);
            System.out.println("Berhasil Mendaftar");
        } else {
            System.out.println("Gagal Mendaftar");
        }
    }

    public void login(String email, String password) {
        if (users.containsKey(email) && users.get(email).equals(password) && isValidEmail(email)) {
            System.out.println("Login Berhasil");
            loggedIn = true;
        } else {
            System.out.println("Gagal Login");
        }
    }

    public void vote(String candidateName) {
        if (!loggedIn) {
            System.out.println("Silakan login terlebih dahulu.");
            return;
        }
        votingSystem.voteForCandidate(candidateName);
    }

    public void displayCandidates() {
        votingSystem.displayCandidates();
    }

    private boolean isValidEmail(String email) {
        return email.endsWith("@gmail.com");
    }

    public static void main(String[] args) {
        DataPemilih dataPemilih = new DataPemilih();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Login");
            System.out.println("2. Daftar");
            System.out.println("3. Hasil Vote");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    dataPemilih.login(email, password);
                    break;
                case 2:
                    System.out.print("Email: ");
                    email = scanner.nextLine();
                    System.out.print("Password: ");
                    password = scanner.nextLine();
                    System.out.print("Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("NIK: ");
                    String nik = scanner.nextLine();
                    dataPemilih.register(email, password, nama, nik);
                    break;
                case 3:
                    dataPemilih.displayCandidates();
                    System.out.print("Masukkan nama kandidat yang Anda ingin pilih: ");
                    String candidateName = scanner.nextLine();
                    dataPemilih.vote(candidateName);
                    break;
                case 4:
                    System.out.println("Keluar dari program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid");
            }
        }
    }
}

