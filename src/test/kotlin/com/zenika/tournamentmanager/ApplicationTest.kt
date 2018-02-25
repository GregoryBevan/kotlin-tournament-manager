package com.zenika.tournamentmanager

import com.nhaarman.mockito_kotlin.*
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue


class ApplicationTest {

    private lateinit var outStream: ByteArrayOutputStream
    private lateinit var errorStream: ByteArrayOutputStream

    @BeforeTest
    fun setup() {
        outStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outStream))
        errorStream = ByteArrayOutputStream()
        System.setErr(PrintStream(errorStream))
    }

    @Test
    fun menu_should_be_displayed() {
        Application().displayMenu()
        assertEquals(MAIN_MENU, outStream.toString())
    }

    @Test
    fun selection_should_not_be_null() {
        Application().handleMenuSelection(null)
        assertEquals(SELECTION_ERROR_MESSAGE, errorStream.toString())
    }

    @Test
    fun selection_should_not_be_an_int() {
        Application().handleMenuSelection("Zenika")
        assertEquals(SELECTION_ERROR_MESSAGE, errorStream.toString())
    }

    @Test
    fun selection_should_be_an_int_between_0_and_1() {
        Application().handleMenuSelection("-1")
        assertEquals(SELECTION_ERROR_MESSAGE, errorStream.toString())
    }

    @Test
    fun should_exit_if_selection_0() {
        Application().handleMenuSelection("0")
        assertTrue(exit)
    }

    @Test
    fun should_start_new_tournament_if_selection_0() {
        val tournamentInitializer = mock<TournamentInitializer>()
        doNothing().whenever(tournamentInitializer).initialize()

        Application(tournamentInitializer).handleMenuSelection("1")

        verify(tournamentInitializer).initialize()
    }
}