package com.zenika.tournamentmanager.menu

const val MAIN_MENU = """

1 - Start new tournament
0 - Exit
Enter your selection : """

object MainMenuDisplayer {

    fun displayMenuSelection() {
        print(MAIN_MENU)
    }

}