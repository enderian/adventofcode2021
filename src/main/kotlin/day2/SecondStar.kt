package day2

import util.readInput

data class Coords(val hor: Int, var depth: Int, var aim: Int)

fun main() {
    val input = readInput(2)
        .map { it.split(" ") }
        .map { (dir, amount) -> Pair(dir, amount.toInt()) }

    println(
        input.fold(Coords(0, 0, 0)) { cords, (dir, x) ->
            val (hor, depth, aim) = cords
            when (dir) {
                "forward" -> cords.copy(hor = hor + x, depth = depth + (x * aim))
                "up" -> cords.copy(aim = aim - x)
                "down" -> cords.copy(aim = aim + x)
                else -> cords
            }
        }.let {
            it.depth * it.hor
        }
    )
}
