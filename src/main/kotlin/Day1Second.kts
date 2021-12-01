import java.io.File

val depths = File("../../../inputs/01.txt").readLines()
    .map { it.trim() }
    .filter { it.isNotEmpty() }
    .map { it.toInt() }

fun sumAt(p: Int): Int =  depths[p] + depths[p + 1] + depths[p + 2]

print((1..(depths.size - 3)).fold(Pair(0, sumAt(0))) { (total, prev), i ->
    val s = sumAt(i)
    Pair(total + if (s > prev) 1 else 0, s)
}.second)
