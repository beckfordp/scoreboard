package com.sportradar;

import java.util.*;

public class Score {
    private final int homeScore;
    private final int awayScore;
    
    public Score(int hoemScore, int awayScore) {
        this.homeScore = hoemScore;
        this.awayScore =awayScore;
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
