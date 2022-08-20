package com.sportradar;

import java.util.*;

public class Scoreboard {
    protected List<Match> matches;

    public Scoreboard(List<Match> matches) {
        this.matches = matches;
    }

    public void startGame(Match aMatch) {
        this.matches.add(aMatch);
    }
}
