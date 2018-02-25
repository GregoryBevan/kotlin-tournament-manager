package com.zenika.tournamentmanager.util

import java.io.ByteArrayInputStream

internal fun prepareSelection(selection: String) {
    val inputStream = ByteArrayInputStream(selection.toByteArray())
    System.setIn(inputStream)
}