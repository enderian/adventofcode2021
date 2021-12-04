package day4

import util.readInputIgnoreEmpty

data class BingoBoard(
    val board: List<Int>,
    val width: Int,
    val height: Int = board.size / width,
    val marked: List<Int> = listOf()
) {

    operator fun get(x: Int, y: Int) = board[x + y * width]
    fun withMarked(num: Int) = copy(marked = marked + num)

    fun winning(): Boolean =
        (0 until width).firstNotNullOfOrNull { x ->
            (0 until height).all { y -> marked.contains(this[x, y]) }.takeIf { it }
        } ?: (0 until height).firstNotNullOfOrNull { y ->
            (0 until width).all { x -> marked.contains(this[x, y]) }.takeIf { it }
        } ?: false

    fun score() = board.filterNot { marked.contains(it) }.sum() * marked.last()

    override fun toString(): String = board
        .chunked(width)
        .joinToString("\n") {
            it.joinToString("\t") { n -> "$n${if (marked.contains(n)) "*" else ""}" }
        }
}

fun readInput4(): Pair<List<BingoBoard>, List<Int>> {
    var input = readInputIgnoreEmpty(4)
    val selected = input.first().split(",").map { it.toInt() }
    input = input.drop(2)

    var boards = listOf<BingoBoard>()
    while (input.isNotEmpty()) {
        val lines = input.takeWhile { it.isNotEmpty() }
        input = input.drop(lines.size + 1)
        boards = boards + BingoBoard(
            lines.flatMap { it.split(Regex("\\s+")).map { n -> n.toInt() } },
            lines.first().split(Regex("\\s+")).size
        )
    }
    return Pair(boards, selected)
}
