package com.zenika.tournamentmanager

data class Match(val homePlayer: Player, val awayPlayer: Player, var homePlayerScore: Int = 0, var awayPlayerScore: Int = 0)