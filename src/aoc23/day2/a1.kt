package aoc23.day2

fun main() {
    val cubeCounts = mapOf(
        "red" to 12,
        "green" to 13,
        "blue" to 14
    )

    var sum = 0
    generateSequence(::readLine).forEach gameLoop@{ game ->
        val (gameHead, gameContent) = game.split(':')
        val gameNumber = gameHead.split(' ').last().toInt()
        gameContent.split(';').forEach { round ->
            round.split(',').forEach {
                val (count, color) = it.trim(' ').split(' ')
                if (count.toInt() > cubeCounts[color]!!)
                    return@gameLoop
            }
        }
        sum += gameNumber
    }
    println(sum)
}