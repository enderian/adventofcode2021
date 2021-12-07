package day7

import util.readInput
import kotlin.math.abs

fun main() {
    val input = readInput(7).first().split(",").map { it.toInt() }
    val min = input.minOf { it }
    val max = input.maxOf { it }

    println((min..max).fold(abs(max - min) * input.size) { cMin, target ->
        val sum = input.sumOf { abs(target - it) }
        when {
            sum < cMin -> sum
            else -> cMin
        }
    })
}
