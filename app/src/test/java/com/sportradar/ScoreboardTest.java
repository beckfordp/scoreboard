package com.sportradar;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


// TODO T: new Game score 0-0
// TODO R: Game or Match, which is it?
// TODO R: Teams as strings, introduce Type

class ScoreboardTest {
    @Test
    void newScoreBoardHasNoMatchesByDefault() {
        Scoreboard sb = new Scoreboard();
        assertEquals(0, sb.matches.size());
    }

    @Test
    void canStartAGame() {
        List<Match> matches = new ArrayList<>();
        Scoreboard sb = new Scoreboard(matches);

        sb.startGame(new Match("Mexico", "Canada"));
        assertEquals(1, sb.matches.size());
    }

    @Test
    void newGameHasScoreOfNilNil() {
        Scoreboard sb = new Scoreboard();
        Match aGame =  sb.startGame(new Match("Mexico", "Canada"));
        assertEquals(new ArrayList<>(Arrays.asList(0, 0)), aGame.score());
    }
}