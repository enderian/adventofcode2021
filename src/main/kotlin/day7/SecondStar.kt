package day7

import util.readInput
import kotlin.math.abs

val fuelCache = mutableMapOf<Int, Int>()

fun fuel(positions: Int): Int = fuelCache[positions] ?: run {
    (0 until positions).sumOf { it + 1 }
}.also {
    fuelCache[positions] = it
}

fun main() {
    val input = readInput(7).first().split(",").map { it.toInt() }
    val min = input.minOf { it }
    val max = input.maxOf { it }

    println((min..max).fold(Int.MAX_VALUE) { cMin, target ->
        val sum = input.sumOf { fuel(abs(target - it)) }
        when {
            sum < cMin -> sum
            else -> cMin
        }
    })
}
