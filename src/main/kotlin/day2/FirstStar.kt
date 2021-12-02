package day2

import util.readInput

fun main() {
    val input = readInput(2)
        .map { it.split(" ") }
        .map { (dir, amount) -> Pair(dir, amount.toInt()) }

    println(
        input.fold(Pair(0, 0)) { cords, (dir, x) ->
            val (hor, depth) = cords
            when (dir) {
                "forward" -> Pair(hor + x, depth)
                "up" -> Pair(hor, depth - x)
                "down" -> Pair(hor, depth + x)
                else -> cords
            }
        }.let {
            it.first * it.second
        }
    )
}
