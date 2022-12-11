package aoc22.day2

fun main() {
    val shapes = mapOf("A" to 1, "B" to 2, "C" to 3,
                        "X" to 1, "Y" to 2, "Z" to 3)
    var score = 0

    generateSequence(::readLine).forEach {
        val (a, b) = it.split(" ")
        score += when (a) {
            "A" -> when (b) {
                "X" -> 3
                "Y" -> 6
                else -> 0
            } + shapes[b]!!
            "B" -> when (b) {
                "Y" -> 3
                "Z" -> 6
                else -> 0
            } + shapes[b]!!
            else -> when (b) {
                "Z" -> 3
                "X" -> 6
                else -> 0
            } + shapes[b]!!
        }
    }

    println(score)
}
