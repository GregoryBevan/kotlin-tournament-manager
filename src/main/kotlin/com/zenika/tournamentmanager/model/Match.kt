package com.zenika.tournamentmanager.model

data class Match(val homePlayer: Player, val awayPlayer: Player, var homePlayerScore: Int = 0, var awayPlayerScore: Int = 0)