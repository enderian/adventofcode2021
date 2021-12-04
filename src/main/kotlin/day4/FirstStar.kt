package day4

fun main() {
    var (boards, selected) = readInput4()
    selected.forEach { select ->
        boards = boards.map { it.withMarked(select) }
        boards
            .firstOrNull { it.winning() }
            ?.let { println(it.score()); return }
    }
}
