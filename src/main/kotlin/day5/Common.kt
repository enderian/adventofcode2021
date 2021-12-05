package day5

import kotlin.math.abs

fun between(start: Int, end: Int) = when {
    end >= start -> (start..end).toList()
    else -> (end..start).toList().reversed()
}

fun range(start: Int, end: Int) = when {
    end >= start -> (start..end)
    else -> (end..start)
}

data class Line(val x1: Int, val y1: Int, val x2: Int, val y2: Int) {

    val points = when {
        x1 == x2 -> range(y1, y2).map { y -> Pair(x1, y) }
        y1 == y2 -> range(x1, x2).map { x -> Pair(x, y1) }
        abs(x1 - x2) != abs(y1 - y2) -> listOf()
        else -> between(x1, x2).zip(between(y1, y2))
    }

    constructor(nums: List<Int>) : this(nums[0], nums[1], nums[2], nums[3])
    constructor(parse: String) : this(parse.split(" -> ")
        .flatMap { it.split(",") }
        .map { it.trim().toInt() })

    fun horizontalVertical() = x1 == x2 || y1 == y2
}
