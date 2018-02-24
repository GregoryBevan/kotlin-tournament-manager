package com.zenika.tournamentmanager

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class ApplicationTest {

    private lateinit var outStream: ByteArrayOutputStream
    private lateinit var errorStream: ByteArrayOutputStream

    @Before
    fun setup() {
        outStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outStream))
        errorStream = ByteArrayOutputStream()
        System.setErr(PrintStream(errorStream))
    }

    @Test
    fun menu_should_be_displayed() {
        displayMenu()
        assertEquals(MAIN_MENU, outStream.toString())
    }

    @Test
    fun selection_should_not_be_null() {
        handleMenuSelection(null)
        assertEquals(SELECTION_ERROR_MESSAGE, errorStream.toString())
    }

    @Test
    fun selection_should_not_be_an_int() {
        handleMenuSelection("Zenika")
        assertEquals(SELECTION_ERROR_MESSAGE, errorStream.toString())
    }

    @Test
    fun selection_should_be_an_int_between_0_and_1() {
        handleMenuSelection("-1")
        assertEquals(SELECTION_ERROR_MESSAGE, errorStream.toString())
    }

    @Test
    fun should_exit_if_selection_0() {
        handleMenuSelection("0")
        assertTrue(exit)
    }

    @Test
    fun should_start_new_tournament_if_selection_0() {
        handleMenuSelection("1")
        assertEquals("""
$TOURNAMENT_TITLE

$TOURNAMENT_NAME_MESSAGE
        """.trimMargin(), outStream.toString())
    }
}