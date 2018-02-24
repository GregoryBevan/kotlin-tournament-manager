package com.zenika.tournamentmanager

const val TOURNAMENT_TITLE = """
        === YOUR TOURNAMENT ==="""

const val TOURNAMENT_NAME_MESSAGE = "Enter the tournament name : "
const val NUMBER_OF_PLAYERS_MESSAGE = "Enter the number of players (2, 4, 8, 16, 32) : "
const val PLAYERS_TITLE = """
        === PLAYERS ==="""
const val ADD_PLAYER_MESSAGE = "Enter player pseudo : "

const val PLAYERS_MIN_NUMBER = 2
const val PLAYERS_MAX_NUMBER = 32

class TournamentInitializer {

    fun initializeTournament() {
        println(TOURNAMENT_TITLE)

        val tournamentName = selectTournamentName()
        val numberOfPlayers = selectNumberOfPlayers()
        val players = addPlayers(numberOfPlayers)

        val tournament = Tournament(tournamentName, numberOfPlayers)

        println(tournament)

    }

    fun selectTournamentName(): String {
        var tournamentName: String? = null
        while (tournamentName === null) {
            print(TOURNAMENT_NAME_MESSAGE)
            tournamentName = readLine()
        }
        return tournamentName
    }

    fun selectNumberOfPlayers(): Int {
        var numberOfPlayers: Int? = null
        while(numberOfPlayers === null) {
            print(NUMBER_OF_PLAYERS_MESSAGE)
            numberOfPlayers = readLine()?.toIntOrNull()?.takeIf { checkNumberOfPlayers(it) }
        }
        return numberOfPlayers
    }

    fun addPlayers(numberOfPlayers: Int): List<String> {
        return (0..numberOfPlayers).map { addPlayer() }
    }

    fun addPlayer(): String {
        println(PLAYERS_TITLE)
        var pseudo: String? = null
        while(pseudo === null) {
            print(ADD_PLAYER_MESSAGE)
            pseudo = readLine()
        }
        return pseudo
    }

    fun checkNumberOfPlayers(number: Int): Boolean {
        return number in 2..32 && (number and number - 1 == 0)
    }

}