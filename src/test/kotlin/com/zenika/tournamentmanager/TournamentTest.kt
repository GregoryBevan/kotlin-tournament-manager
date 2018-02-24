package com.zenika.tournamentmanager

import org.junit.Assert
import org.junit.Test

class TournamentTest {

    @Test
    fun should_create_tournament() {
        Tournament("test tournament", 4)
    }

    @Test
    fun check_number_of_players_in_boundaries() {
        Assert.assertTrue(checkNumberOfPlayers(PLAYERS_MIN_NUMBER))
        Assert.assertFalse(checkNumberOfPlayers(PLAYERS_MIN_NUMBER - 1))
        Assert.assertTrue(checkNumberOfPlayers(PLAYERS_MAX_NUMBER))
        Assert.assertFalse(checkNumberOfPlayers(PLAYERS_MAX_NUMBER + 1))
    }

    @Test
    fun check_number_of_players_power_of_2() {
        Assert.assertFalse(checkNumberOfPlayers(3) || checkNumberOfPlayers(6))
        Assert.assertTrue(checkNumberOfPlayers(4) && checkNumberOfPlayers(16))
    }
}
