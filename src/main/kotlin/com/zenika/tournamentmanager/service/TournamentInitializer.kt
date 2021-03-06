package com.zenika.tournamentmanager.service

import com.zenika.tournamentmanager.model.DEFAULT_TOURNAMENT_NAME
import com.zenika.tournamentmanager.model.Player
import com.zenika.tournamentmanager.model.Tournament
import com.zenika.tournamentmanager.model.TournamentType

const val TOURNAMENT_TITLE = """
        === NEW TOURNAMENT ==="""

const val TOURNAMENT_NAME_MESSAGE = "Enter the tournament name (Your tournament) : "
const val TOURNAMENT_TYPE_MESSAGE = "Enter the tournament type (1. Knockout, 2. League) : "
const val NUMBER_OF_PLAYERS_MESSAGE = "Enter the number of players (2, 4, 8, 16, 32) : "
const val PLAYERS_TITLE = """
        === PLAYERS ==="""
const val ADD_PLAYER_MESSAGE = "Enter player %d pseudo : "

const val PLAYERS_MIN_NUMBER = 2
const val PLAYERS_MAX_NUMBER = 32

class TournamentInitializer {

    fun initialize(): Tournament {
        println(TOURNAMENT_TITLE)

        val tournamentName = selectTournamentName()
        val tournamentType = selectTournamentType()
        val numberOfPlayers = selectNumberOfPlayers()
        val players = addPlayers(numberOfPlayers)

        return Tournament(tournamentName, tournamentType, numberOfPlayers, players)
    }

    private fun selectTournamentName(): String {
        print(TOURNAMENT_NAME_MESSAGE)
        return readLine()?.takeIf { it.isNotEmpty() } ?: DEFAULT_TOURNAMENT_NAME
    }

    private fun selectTournamentType(): TournamentType {
        print(TOURNAMENT_TYPE_MESSAGE)
        var tournamentType: TournamentType? = null
        while (tournamentType === null) {
            tournamentType = readLine()?.toIntOrNull()?.let { TournamentType.from(it) } ?: selectTournamentType()
        }
        return tournamentType
    }

    private fun selectNumberOfPlayers(): Int {
        var numberOfPlayers: Int? = null
        while (numberOfPlayers === null) {
            print(NUMBER_OF_PLAYERS_MESSAGE)
            numberOfPlayers = readLine()?.toIntOrNull()?.takeIf { checkNumberOfPlayers(it) } ?:
                    selectNumberOfPlayers()
        }
        return numberOfPlayers
    }

    private fun addPlayers(numberOfPlayers: Int): List<Player> {
        println(PLAYERS_TITLE)
        return (1..numberOfPlayers).map { addPlayer(it) }
    }

    private fun addPlayer(number: Int): Player {
        var pseudo: String? = null
        while (pseudo === null) {
            print(ADD_PLAYER_MESSAGE.format(number))
            pseudo = readLine()?.takeIf { it.isNotEmpty() }
        }
        return Player(pseudo)
    }

    fun checkNumberOfPlayers(number: Int): Boolean {
        return number in 2..32 && (number and number - 1 == 0)
    }

}