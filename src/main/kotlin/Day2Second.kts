import java.io.File

val instructions = File("../../../inputs/02.txt").readLines()
    .filter { it.isNotEmpty() }
    .map { it.split(" ") }
    .map { (dir, amount) -> Pair(dir, amount.toInt()) }

data class Coords(val hor: Int, var depth: Int, var aim: Int)

println(
    instructions.fold(Coords(0, 0, 0)) { cords, (dir, x) ->
        val (hor, depth, aim) = cords
        when(dir) {
            "forward" -> cords.copy(hor = hor + x, depth = depth + (x * aim))
            "up" -> cords.copy(aim = aim - x)
            "down" -> cords.copy(aim = aim + x)
            else -> cords
        }
    }.let {
        it.depth * it.hor
    }
)
