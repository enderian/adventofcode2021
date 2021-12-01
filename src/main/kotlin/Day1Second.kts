import java.io.File

val depths = File("../../../inputs/01.txt").readLines()
    .map { it.trim() }
    .filter { it.isNotEmpty() }
    .map { it.toInt() }

print(
    (1..(depths.size - 3)).fold(
        Pair(0, depths[0] + depths[1] + depths[2])
    ) { (total, prev), i ->
        val s = prev + depths[i + 2] - depths[i - 1]
        Pair(total + if (s > prev) 1 else 0, s)
    }.first
)
