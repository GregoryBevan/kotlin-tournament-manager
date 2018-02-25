package com.zenika.tournamentmanager

import com.zenika.tournamentmanager.TournamentType.KNOCKOUT

const val DEFAULT_TOURNAMENT_NAME = "Your tournament"
val DEFAULT_TOURNAMENT_TYPE = KNOCKOUT
const val DEFAULT_NUMBER_OF_PLAYERS = 2

data class Tournament(
    val name: String = DEFAULT_TOURNAMENT_NAME,
    val tournamentType: TournamentType = DEFAULT_TOURNAMENT_TYPE,
    val numberOfPlayers: Int = DEFAULT_NUMBER_OF_PLAYERS,
    val players: List<Player>
)

enum class TournamentType(private val menuPosition: Int) {
    KNOCKOUT(1), LEAGUE(2);

    companion object {
        infix fun from(menuPosition: Int): TournamentType? = when (menuPosition) {
            1 -> KNOCKOUT
            2 -> LEAGUE
            else -> null
        }
    }
}