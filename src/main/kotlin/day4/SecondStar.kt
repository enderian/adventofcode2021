package day4

fun main() {
    var (boards, selected) = readInput4()
    var winning = listOf<BingoBoard>()

    selected.forEach { select ->
        boards = boards.map { it.withMarked(select) }
        val w = boards.filter { it.winning() }
        winning = winning + w
        boards -= w
    }

    println(winning.last().score())
}
