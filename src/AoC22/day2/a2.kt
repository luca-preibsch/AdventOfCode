package aoc22.day2

fun main() {
    val shapes = mapOf("A" to 1, "B" to 2, "C" to 3)
    var score = 0

    generateSequence(::readLine).forEach {
        val (a, b) = it.split(" ")
        score += when (b) {
            "X" -> when (a) {
                "A" -> shapes["C"]!!
                "B" -> shapes["A"]!!
                else -> shapes["B"]!!
            }
            "Y" -> 3 + shapes[a]!!
            else -> when (a) {
                "A" -> shapes["B"]!!
                "B" -> shapes["C"]!!
                else -> shapes["A"]!!
            } + 6
        }
    }

    println(score)
}
