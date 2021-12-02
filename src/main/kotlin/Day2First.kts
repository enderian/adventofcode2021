import java.io.File

val instructions = File("../../../inputs/02.txt").readLines()
    .filter { it.isNotEmpty() }
    .map { it.split(" ") }
    .map { (dir, amount) -> Pair(dir, amount.toInt()) }

println(
    instructions.fold(Pair(0, 0)) { cords, (dir, x) ->
        val (hor, depth) = cords
        when(dir) {
            "forward" -> Pair(hor + x, depth)
            "up" -> Pair(hor, depth - x)
            "down" -> Pair(hor, depth + x)
            else -> cords
        }
    }.let {
        it.first * it.second
    }
)
