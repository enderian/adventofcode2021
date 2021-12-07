package day6

import util.readInput

fun List<Int>.lanternFishProgress(): List<Int> {
    var newCount = 0
    return this.map {
        when(it) {
            0 -> { newCount++; 6 }
            else -> it - 1
        }
    }.let {
        it + List(newCount) { 8 }
    }
}

fun main() {
    val input = readInput(6).first().split(",").map { it.toInt() }
    val days = 80
    val result = (0 until days).fold(input) { acc, _ -> acc.lanternFishProgress(); }
    println(result.count())
}
