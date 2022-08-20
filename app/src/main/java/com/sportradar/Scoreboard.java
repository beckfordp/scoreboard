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

    public Match startGame(Match aMatch) {
        this.matches.add(aMatch);
        return aMatch;
    }

    public void finishGame(Match aGame) {
        this.matches.remove(aGame);
    }

    public Match findGame(Match aMatch) {
        Optional<Match> found = matches.stream().filter(m -> m.equals(aMatch)).findAny();
        return found.get();
    }
}
