package com.sportradar;

import java.util.*;

public class Match {
    private final String homeTeam;
    private final String awayTeam;
    private Score score = new Score(0, 0);

    public Match(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public Score score() {
        return score;
    }
}
