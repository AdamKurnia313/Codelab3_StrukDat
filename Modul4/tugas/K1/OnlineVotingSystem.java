package StrukturData.Modul4.tugas.K1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OnlineVotingSystem {
    private Map<String, Integer> candidates;

    public OnlineVotingSystem() {
        this.candidates = new HashMap<>();
    }

    public void addCandidate(String name) {
        candidates.put(name, 0); // Set jumlah voting awal ke 0
    }

    public void voteForCandidate(String name) {
        if (candidates.containsKey(name)) {
            int currentVotes = candidates.get(name);
            candidates.put(name, currentVotes + 1);
            System.out.println("Suara Anda telah direkam untuk " + name);
        } else {
            System.out.println("Kandidat dengan nama tersebut tidak terdaftar.");
        }
    }

    public void displayCandidates() {
        System.out.println("Daftar Kandidat:");
        for (String name : candidates.keySet()) {
            System.out.println(name);
        }
    }
    public void tampilkanHasil() {
        System.out.println("Hasil Voting:");
        for (String kandidat : candidates.keySet()) {
            System.out.println("- " + kandidat + ": " + candidates.get(kandidat) + " suara");
        }
    }

        public static void main (String[]args){
            OnlineVotingSystem votingSystem = new OnlineVotingSystem();
            Scanner scanner = new Scanner(System.in);

            // Contoh penambahan kandidat
            votingSystem.addCandidate("Kandidat A");
            votingSystem.addCandidate("Kandidat B");
            votingSystem.addCandidate("Kandidat C");

            votingSystem.displayCandidates();

            boolean votingFinished = false;

            while (!votingFinished) {
                System.out.println("Silakan masukkan nama kandidat yang Anda ingin pilih atau ketik 'selesai' untuk mengakhiri:");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("selesai")) {
                    System.out.println("Terima kasih telah menggunakan sistem voting online.");
                    votingFinished = true;
                } else {
                    votingSystem.voteForCandidate(input);
                }
            }

            votingSystem.tampilkanHasil();
            scanner.close();


        }
    }


