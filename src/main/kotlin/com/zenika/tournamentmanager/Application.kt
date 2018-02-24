package com.zenika.tournamentmanager

const val TITLE = """
        === Zen Tournament Manager ==="""

const val MAIN_MENU = """

1 - Start new tournament
0 - Exit
Enter your selection : """

const val SELECTION_ERROR_MESSAGE = "Choice must be a number between 0 or 1"

var exit = false

fun displayMenu() {
    print(MAIN_MENU)
}

fun handleMenuSelection(input: String?) {
    val selection = input?.toIntOrNull()
    when (selection) {
        0 -> exit = true
        1 -> initializeTournament()
        else -> System.err.print(SELECTION_ERROR_MESSAGE)
    }
}

fun main(args: Array<String>) {
    println(TITLE)
    while (!exit) {
        displayMenu()
        val input = readLine()
        handleMenuSelection(input)
    }
}