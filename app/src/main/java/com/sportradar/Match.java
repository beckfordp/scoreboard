package com.sportradar;

import java.util.*;

public class Match {
    private final String homeTeam;
    private final String awayTeam;
    List<Integer> score = new ArrayList<>(Arrays.asList(0, 0));

    public Match(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public List<Integer> score() {
        return score;
    }
}
