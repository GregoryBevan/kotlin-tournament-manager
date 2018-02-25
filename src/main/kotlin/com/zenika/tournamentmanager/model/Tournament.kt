package com.zenika.tournamentmanager.model

const val DEFAULT_TOURNAMENT_NAME = "Your tournament"

data class Tournament(
    val name: String = DEFAULT_TOURNAMENT_NAME,
    val tournamentType: TournamentType,
    val numberOfPlayers: Int,
    val players: List<Player>
)

enum class TournamentType {
    KNOCKOUT, LEAGUE;

    companion object {
        infix fun from(menuPosition: Int): TournamentType? = when (menuPosition) {
            1 -> KNOCKOUT
            2 -> LEAGUE
            else -> null
        }
    }
}