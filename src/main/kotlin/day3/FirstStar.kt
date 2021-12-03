package day3

import util.readInput
import kotlin.math.pow

fun List<Int>.binaryToInt() = reversed().mapIndexed { i, n -> n * 2.0.pow(i).toInt() }.sum()
fun List<Int>.binaryInverse() = map { if (it == 0) 1 else 0 }
fun List<Boolean>.toBinaryList() = map { if (it) 1 else 0 }

fun main() {
    val input = readInput(3).map { it.toCharArray().map { c -> c.digitToInt() } }

    val mostCommonBits = input.drop(1).fold(input.first()) { sum, row ->
        sum.zip(row) { x, y -> x + y }
    }.map {
        it > input.size / 2
    }.toBinaryList()

    val leastCommonBits = mostCommonBits.binaryInverse()
    val gamma = mostCommonBits.binaryToInt()
    val epsilon = leastCommonBits.binaryToInt()

    println(gamma * epsilon)
}
