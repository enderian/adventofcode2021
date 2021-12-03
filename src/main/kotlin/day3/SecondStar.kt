package day3

import util.readInput

fun main() {
    val input = readInput(3).map { it.toCharArray().map { c -> c.digitToInt() } }

    println(
        common(input, true) * common(input, false)
    )
}

fun common(input: List<List<Int>>, most: Boolean) = (0 until input.first().size).fold(input) { list, i ->
    when {
        list.size < 2 -> list
        else -> {
            val mostOccurring = list
                .groupBy { it[i] }
                .maxByOrNull { (it.value.size * 10 + it.key) * if (most) 1 else -1 }?.key ?: 0

            list.filter { it[i] == mostOccurring }
        }
    }
}.single().binaryToInt()
