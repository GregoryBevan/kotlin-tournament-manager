package com.zenika.tournamentmanager.menu

import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class MainMenuDisplayerTest {

    private lateinit var outStream: ByteArrayOutputStream

    @BeforeTest
    fun setup() {
        outStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outStream))
    }

    @Test
    fun should_display_menu_items() {
        MainMenuDisplayer.displayMenuSelection()
        assertEquals(MAIN_MENU, outStream.toString())
    }
}