package util

import java.io.File

fun readInput(day: Int): List<String> = File("inputs/${day}.txt")
    .readLines()
    .map { it.trim() }
    .filter { it.isNotEmpty() }

fun readInputIgnoreEmpty(day: Int): List<String> = File("inputs/${day}.txt")
    .readLines()
    .map { it.trim() }
