package com.sportradar;

import org.junit.jupiter.api.Test;

import java.util.*;

import static com.sportradar.Team.*;
import static org.junit.jupiter.api.Assertions.*;


// TODO: T display summary

class ScoreboardTest {
    
    @Test
    void newScoreBoardHasNoMatchesByDefault() {
        Scoreboard sb = new Scoreboard();
        assertEquals(0, sb.matches.size());
    }

    @Test
    void canStartAMatch() {
        List<Match> matches = new ArrayList<>();
        Scoreboard sb = new Scoreboard(matches);

        sb.startMatch(new Match(Mexico, Canada));
        assertEquals(1, sb.matches.size());
    }

    @Test
    void newMatchHasScoreOfNilNil() {
        Scoreboard sb = new Scoreboard();
        Match aMatch =  sb.startMatch(new Match(Mexico, Canada));
        assertEquals(new Score(0, 0), aMatch.score());
    }

    @Test
    void canFindMatchInProgress() {
        Scoreboard sb = new Scoreboard();
        Match expected = sb.startMatch(new Match(Mexico, Canada));
        assertEquals(expected, sb.findMatch(expected));
    }

    @Test
    void willThrowExceptionIfMatchMissing() {
        Scoreboard sb = new Scoreboard();
        assertThrows(MatchMissingException.class, () -> sb.findMatch(new Match(Mexico, Canada)));
    }

    @Test
    void canUpdateScore() {
        Scoreboard sb = new Scoreboard();
        Match aMatch =  sb.startMatch(new Match(Mexico, Canada));
        sb.findMatch(aMatch).updateScore(0, 5);
        assertEquals(new Score(0, 5), aMatch.score());
    }

    @Test
    void canFinishMatchInProgress() {
        Scoreboard sb = new Scoreboard();
        Match aMatch =  sb.startMatch(new Match(Mexico, Canada));
        assertEquals(1, sb.matches.size());
        sb.finishMatch(aMatch);
        assertEquals(0, sb.matches.size());
    }

    @Test
    void willThrowExceptionOnAtemptToFinishMissingMatch() {
        Scoreboard sb = new Scoreboard();
        assertThrows(MatchMissingException.class,
                     () -> sb.finishMatch(new Match(Mexico, Canada)));
    }

    @Test // @Disabled  // for debugging
    void CanDisplaySummary() {
        Scoreboard sb = new Scoreboard(new ArrayList<>(Arrays.asList(
            new Match(Mexico, Canada).updateScore(0, 5),
            new Match(Spain, Brazil).updateScore(10, 2),
            new Match(Germany, France).updateScore(2, 2),
            new Match(Uruguay, Italy).updateScore(6, 6),
            new Match(Argentina, Australia).updateScore(3, 1))));

        sb.summary().forEach(m -> System.out.println(m));
    }
}