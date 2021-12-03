package day3

import util.readInput
import kotlin.math.pow

fun List<Int>.binaryToInt() = reversed().mapIndexed { i, n -> n * 2.0.pow(i).toInt() }.sum()
fun List<Int>.binaryInverse() = map { if (it == 0) 1 else 0 }

fun main() {
    val input = readInput(3).map { it.toCharArray().map { c -> c.digitToInt() } }
    val mostCommonBits = (0 until input.first().size)
        .map { i -> input.groupBy { x -> x[i] }.maxByOrNull { x -> x.value.size }?.key ?: 0 }

    val leastCommonBits = mostCommonBits.binaryInverse()
    val gamma = mostCommonBits.binaryToInt()
    val epsilon = leastCommonBits.binaryToInt()

    println(gamma * epsilon)
}
