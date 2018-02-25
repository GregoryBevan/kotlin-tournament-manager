package com.zenika.tournamentmanager.service

import com.zenika.tournamentmanager.model.Player
import com.zenika.tournamentmanager.model.Tournament
import com.zenika.tournamentmanager.model.TournamentType
import com.zenika.tournamentmanager.util.prepareSelection
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.*


class TournamentInitializerTest {

    lateinit var tournamentInitializer: TournamentInitializer

    private lateinit var outStream: ByteArrayOutputStream

    @BeforeTest
    fun setup() {
        tournamentInitializer = TournamentInitializer()
        outStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outStream))
    }

    @Test
    fun should_create_tournament() {
        prepareSelection("Zen Tournament\n1\n2\nGreg\nLeony\n")
        assertEquals(
            Tournament("My", TournamentType.KNOCKOUT, 2, listOf(Player("Greg"), Player("Leony"))),
            tournamentInitializer.initialize()
        )
    }

    @Test
    fun should_create_tournament_with_default_name() {
        prepareSelection("\n\n1\n2\nGreg\nLeony\n")
        assertEquals(
            Tournament("Your tournament", TournamentType.KNOCKOUT, 2, listOf(Player("Greg"), Player("Leony"))),
            tournamentInitializer.initialize()
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
