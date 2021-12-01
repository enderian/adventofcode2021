import java.io.File

val depths = File("../../../inputs/01.txt").readLines()
    .map { it.trim() }
    .filter { it.isNotEmpty() }
    .map { it.toInt() }

var increases = 0
var prev = depths.first()
depths.forEach { depth ->
    if (depth > prev) increases++
    prev = depth
}

println(increases)
