package aoc23.day2

import kotlin.math.max

fun main() {
    var sum = 0
    generateSequence(::readLine).forEach gameLoop@{ game ->
        val maxCubes = mutableMapOf(
            "red" to 0,
            "green" to 0,
            "blue" to 0
        )

        val (gameHead, gameContent) = game.split(':')
        val gameNumber = gameHead.split(' ').last().toInt()
        gameContent.split(';').forEach { round ->
            round.split(',').forEach {
                val (count, color) = it.trim(' ').split(' ')
                maxCubes[color] = max(maxCubes[color]!!, count.toInt())
            }
        }
        sum += maxCubes.values.reduceOrNull(Int::times) ?: 0
    }
    println(sum)
}