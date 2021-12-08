package day8

fun main() {
    val input = readInput8()

    println(input.sumOf {
        it.outputs.sumOf { o ->
            when (o.size) {
                2, 3, 4, 7 -> 1L
                else -> 0L
            }
        }
    })
}

