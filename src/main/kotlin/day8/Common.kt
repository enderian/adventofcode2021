package day8

import util.readInput

/*
  0:      1:      2:      3:      4:
 aaaa    ....    aaaa    aaaa    ....
b    c  .    c  .    c  .    c  b    c
b    c  .    c  .    c  .    c  b    c
 ....    ....    dddd    dddd    dddd
e    f  .    f  e    .  .    f  .    f
e    f  .    f  e    .  .    f  .    f
 gggg    ....    gggg    gggg    ....

  5:      6:      7:      8:      9:
 aaaa    aaaa    aaaa    aaaa    aaaa
b    .  b    .  .    c  b    c  b    c
b    .  b    .  .    c  b    c  b    c
 dddd    dddd    ....    dddd    dddd
.    f  e    f  .    f  e    f  .    f
.    f  e    f  .    f  e    f  .    f
 gggg    gggg    ....    gggg    gggg
 */

val segments = "abcdefg".toSet()
val numbers = mapOf(
    0 to "abcefg",
    1 to "cf",
    2 to "acdeg",
    3 to "acdfg",
    4 to "bcdf",
    5 to "abdfg",
    6 to "abdefg",
    7 to "acf",
    8 to "abcdefg",
    9 to "abcdfg",
).mapValues {
    it.value.toSet()
}

val digitsToNumber = numbers.map { it.value to it.key }.toMap()

data class Digit(val inputs: List<Set<Char>>, val outputs: List<Set<Char>>) {

    private val possibilities = segments.associateWith { segments.toMutableSet() }

    fun inferMappings() {
        inputs.forEach { input ->
            val allPossibleNumbers = numbers.filterValues { it.size == input.size }

            segments.forEach { s ->
                val possible = possibilities.getValue(s)
                if (s in input) {
                    // Since this segment is part of the input, eliminate all the non-possible
                    // input segments
                    val distinct = allPossibleNumbers.map { it.value }.flatten().toSet()
                    possible.retainAll(distinct)
                } else {
                    // Since this segment isn't part of this input, none of the common segments
                    // can be a possible replacement
                    val same = allPossibleNumbers.map { it.value }.reduce { acc, it -> acc.intersect(it) }
                    possible.removeAll(same)
                }
            }

            // Eliminate any characters that we already have found.
            possibilities.filterValues { it.size == 1 }.forEach { (k, possible) ->
                possibilities
                    .filterKeys { c -> c != k }
                    .forEach { (c, _) -> possibilities.getValue(c).removeAll(possible) }
            }
        }
    }

    fun calculateOutput() = outputs
        .map { it.map { c -> possibilities.getValue(c).single() } }
        .joinToString("") { digitsToNumber.getValue(it.toSet()).toString() }
        .toInt()
}


fun readInput8() = readInput(8).map { entry ->
    val (inputs, outputs) = entry.split(" | ")
    Digit(
        inputs.split(" ").map { it.toSet() },
        outputs.split(" ").map { it.toSet() }
    )
}