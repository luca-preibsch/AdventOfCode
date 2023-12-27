package aoc23.day4


fun main() {
    var sum = 0
    generateSequence(::readLine)
        // drop every char before the colon and the colon itself
        .map { card -> card.dropWhile { it != ':' }.drop(1) }
        .forEach { card ->
            val (winningNumbers, ownNumbers) = card
                .split("|")
                .map(String::trim)
                .map { it.split(Regex("\\s+")) }
                .map { it.map(String::toInt) }

            val wins = winningNumbers.filter { ownNumbers.contains(it) }.size
            sum += 0b1 shl wins shr 1
        }
    println(sum)
}