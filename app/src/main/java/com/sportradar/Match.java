package com.sportradar;

import java.util.*;

public class Match  implements Comparable<Match> {
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

    public Match updateScore(int homeScore, int awayScore) {
        score =  new Score(homeScore, awayScore);
        return this;
    }

    @Override
    public String toString() {
        return "" + homeTeam + " " + score.getHomeScore() + " - " + awayTeam + " " + score.getAwaySAcore();
    }

    @Override
    public int compareTo(Match other) {
        return score.totalScore().compareTo(other.score.totalScore());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Match)) {
            return false;
        }
        Match match = (Match) o;
        return homeTeam.equals(match.homeTeam) && awayTeam.equals(match.awayTeam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeam, awayTeam);
    }
}
