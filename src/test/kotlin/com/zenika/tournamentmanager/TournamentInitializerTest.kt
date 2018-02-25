package com.zenika.tournamentmanager

import com.zenika.tournamentmanager.model.Player
import com.zenika.tournamentmanager.model.Tournament
import com.zenika.tournamentmanager.model.TournamentType
import com.zenika.tournamentmanager.service.PLAYERS_MAX_NUMBER
import com.zenika.tournamentmanager.service.PLAYERS_MIN_NUMBER
import com.zenika.tournamentmanager.service.TournamentInitializer
import kotlin.test.*


class TournamentInitializerTest {

    lateinit var tournamentInitializer: TournamentInitializer

    @BeforeTest
    fun setup() {
        tournamentInitializer = TournamentInitializer()
    }

    @Test
    fun should_create_tournament() {
        Tournament(
            "test tournament", TournamentType.KNOCKOUT, 4, listOf(
                Player("John"), Player("Jane")
            )
        )
    }

    @Test
    fun check_number_of_players_in_boundaries() {
        assertTrue(tournamentInitializer.checkNumberOfPlayers(PLAYERS_MIN_NUMBER))
        assertFalse(tournamentInitializer.checkNumberOfPlayers(PLAYERS_MIN_NUMBER - 1))
        assertTrue(tournamentInitializer.checkNumberOfPlayers(PLAYERS_MAX_NUMBER))
        assertFalse(tournamentInitializer.checkNumberOfPlayers(PLAYERS_MAX_NUMBER + 1))
    }

    @Test
    fun check_number_of_players_power_of_2() {
        assertFalse(tournamentInitializer.checkNumberOfPlayers(3) || tournamentInitializer.checkNumberOfPlayers(6))
        assertTrue(tournamentInitializer.checkNumberOfPlayers(4) && tournamentInitializer.checkNumberOfPlayers(16))
    }
}
