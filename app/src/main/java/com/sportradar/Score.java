package com.sportradar;

import java.util.*;

public class Score {
    private final int homeScore;
    private final int awayScore;
    
    public Score(int homeScore, int awayScore) {
        this.homeScore = homeScore;
        this.awayScore =awayScore;
    }

    public Integer totalScore() { return homeScore + awayScore; }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Score)) {
            return false;
        }
        Score score = (Score) o;
        return homeScore == score.homeScore && awayScore == score.awayScore;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(homeScore, awayScore);
    }
}
