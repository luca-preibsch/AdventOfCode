package aoc23.day1

fun main() {
    var sum = 0
    generateSequence(::readLine)
        .forEach {
            val firstDigit = it.find(Char::isDigit)
            val lastDigit = it.findLast(Char::isDigit)
            sum += "$firstDigit$lastDigit".toInt()
        }
    println(sum)
}