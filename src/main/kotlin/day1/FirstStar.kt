package day1

import util.readInput

fun main() {
    val input = readInput(1).map { it.toInt() }
    println(
        input.windowed(2).count { (a, b) -> b > a }
    )
}
