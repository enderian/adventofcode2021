package day5

import util.readInput
import kotlin.math.max

fun main() {
    val input = readInput(5)
    val lines = input.map { Line(it) }.filter { it.horizontalVertical() }
    val maxX = lines.maxOf { max(it.x1, it.x2) }
    val maxY = lines.maxOf { max(it.y1, it.y2) }
    val cells = Array(maxY + 1) { Array(maxX + 1) { 0 } }

    lines.forEach { line ->
        line.points.forEach { (x, y) ->
            cells[y][x] += 1
        }
    }
    println(cells.sumOf { it.count { x -> x > 1 } })
}
