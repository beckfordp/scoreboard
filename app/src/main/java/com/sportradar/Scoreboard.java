package com.sportradar;

import java.util.*;

public class Scoreboard {
    protected List<Match> matches;

    public Scoreboard(List<Match> matches) {
        this.matches = matches;
    }

    public Scoreboard() {
        this.matches = new ArrayList<>();
    }

    public Match startMatch(Match aMatch) {
        this.matches.add(aMatch);
        return aMatch;
    }

    public void finishMatch(Match aMatch) {
        Match finishedMatch = findMatch(aMatch);
        matches.remove(finishedMatch);
    }

    public Match findMatch(Match aMatch) {
        Optional<Match> found = matches.stream().filter(m -> m.equals(aMatch)).findAny();
        if (found.isPresent()) { return found.get(); } else { throw new MatchMissingException(); }
    }

    public List<Match> summary() {
        return matches;
    }
}
