package day8

fun main() {
    val input = readInput8()
    println(input.sumOf { it.inferMappings(); it.calculateOutput() })
}
