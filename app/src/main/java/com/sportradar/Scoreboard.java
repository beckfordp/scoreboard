package com.sportradar;

import java.util.*;
import java.util.stream.Collectors;

public class Scoreboard {
    protected List<Match> matches;

    public Scoreboard() {
        this.matches = new ArrayList<>();
    }

    public Scoreboard(List<Match> matches) {
        this.matches = matches;
    }

    public Match startMatch(Match aMatch) {
        if (matches.contains(aMatch)) throw new MatchInProgressException();
        matches.add(aMatch);
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
        List<Match> sortedList = this.matches.stream().sorted().collect(Collectors.toList());
        Collections.reverse(sortedList);
        return sortedList;
    }
}
