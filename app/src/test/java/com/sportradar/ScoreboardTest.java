package com.sportradar;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

//TODO delete gradle template generated code
//TODO T: can start a game

class ScoreboardTest {

    @Test
    void canStartAGame() {
        List<Match> matches = new ArrayList<>();
        Scoreboard sb = new Scoreboard(matches);

        sb.startGame(new Match("Mexico", "Canada"));
        assertEquals(1, sb.matches.size());
    }

}