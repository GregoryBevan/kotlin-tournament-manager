package com.zenika.tournamentmanager

import com.nhaarman.mockito_kotlin.doNothing
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.zenika.tournamentmanager.service.TournamentInitializer
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import java.io.ByteArrayInputStream

class ApplicationTest {

    private lateinit var errorStream: ByteArrayOutputStream

    @BeforeTest
    fun setup() {
        errorStream = ByteArrayOutputStream()
        System.setErr(PrintStream(errorStream))
    }

    @Test
    fun selection_should_not_be_an_int() {
        prepareSelection("zero")
        Application().handleUserSelection()
        assertEquals(SELECTION_ERROR_MESSAGE, errorStream.toString())
    }

    @Test
    fun selection_should_be_an_int_between_0_and_1() {
        prepareSelection("2")
        Application().handleUserSelection()
        assertEquals(SELECTION_ERROR_MESSAGE, errorStream.toString())
    }

    @Test
    fun should_exit_if_selection_0() {
        prepareSelection("0")
        Application().handleUserSelection()
        assertTrue(exit)
    }

    @Test
    fun should_start_new_tournament_if_selection_1() {
        prepareSelection("1")
        val tournamentInitializer = mock<TournamentInitializer>()
        doNothing().whenever(tournamentInitializer).initialize()

        Application(tournamentInitializer).handleUserSelection()

        verify(tournamentInitializer).initialize()
    }

    private fun prepareSelection(selection: String) {
        val inputStream = ByteArrayInputStream(selection.toByteArray())
        System.setIn(inputStream)
    }
}