package day6

import util.readInput

val cache = mutableMapOf<Pair<Int, Int>, Long>()
const val endDay = 256

fun main() {
    val input = readInput(6).first().split(",").map { it.toInt() }
    println(input.sumOf { resultingFish(it, 0) })
}

fun resultingFish(initial: Int, startDay: Int): Long {
    return cache[Pair(initial, startDay)] ?: run {
        var state = initial
        (startDay until endDay).fold(1L) { sum, day ->
            when (state) {
                0 -> {
                    state = 6
                    sum + resultingFish(8, day + 1)
                }
                else -> {
                    state--
                    sum
                }
            }
        }
    }.also {
        cache[Pair(initial, startDay)] = it
    }
}
