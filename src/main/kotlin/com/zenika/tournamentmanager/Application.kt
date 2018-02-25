package com.zenika.tournamentmanager

import com.zenika.tournamentmanager.menu.MainMenuDisplayer
import com.zenika.tournamentmanager.service.TournamentInitializer

const val TITLE = """
        === Zen Tournament Manager ===

        """

const val SELECTION_ERROR_MESSAGE = "Choice must be a number between 0 or 1"

var exit = false

class Application(private val tournamentInitializer: TournamentInitializer = TournamentInitializer()) {

    fun handleUserSelection() {
        val selection = readLine()?.toIntOrNull()
        when (selection) {
            0 -> exit = true
            1 -> tournamentInitializer.initialize()
            else -> System.err.print(SELECTION_ERROR_MESSAGE)
        }
    }
}

fun main(args: Array<String>) {
    val application = Application()
    println(TITLE)
    while (!exit) {
        MainMenuDisplayer.displayMenuSelection()
        application.handleUserSelection()
    }
}