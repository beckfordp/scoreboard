package com.sportradar;

import java.util.*;

public class Match {
    private final Team homeTeam;
    private final Team awayTeam;
    private Score score = new Score(0, 0);

    public Match(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    public Score score() {
        return score;
    }

    public void updateScore(int homeScore, int awayScore) {
        score =  new Score(homeScore, awayScore);
    }
}
