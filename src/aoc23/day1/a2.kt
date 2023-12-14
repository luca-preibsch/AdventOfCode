package aoc23.day1

fun main() {
    var sum = 0
    generateSequence(::readLine)
        .forEach { line ->
            val digitMap = mapOf(
                "zero" to 0,
                "one" to 1,
                "two" to 2,
                "three" to 3,
                "four" to 4,
                "five" to 5,
                "six" to 6,
                "seven" to 7,
                "eight" to 8,
                "nine" to 9
            )
            var digits = String()
            line.forEachIndexed { index, c ->
                var foundDigit = String()
                digits += when {
                    c.isDigit() -> c
                    digitMap.keys.any {
                        foundDigit = it
                        return@any line.substring(index).startsWith(it)
                    } -> digitMap[foundDigit]
                    else -> ""
                }
            }
            sum += "${digits.first()}${digits.last()}".toInt()
        }
    println(sum)
}