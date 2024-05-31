package StrukturData.Modul4.tugas.K2;

import java.util.HashMap;
import java.util.Map;

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
}


