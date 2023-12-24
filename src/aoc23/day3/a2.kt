package aoc23.day3

fun main() {
    val input = generateSequence(::readLine).toList()

    data class GearEntry(var counter: Int, var value: Long)
    val gearMap = HashMap<Pair<Int, Int>, GearEntry>()

    fun Char.isGear() = this == '*'

    fun addToGear(xStart: Int, xEnd: Int, row: Int, number: Long) {
        for (i in (row-1 .. row+1)) {
            val line = input.getOrNull(i)
            if (line != null)
                for (j in xStart-1..xEnd+1) {
                    val char = line.getOrNull(j)
                    if (char != null && char.isGear()) {
                        val key = Pair(i, j)
                        val entry = gearMap.putIfAbsent(key, GearEntry(1, number))
                        if (entry != null) {
                            entry.counter++
                            entry.value *= number
                            gearMap[key] = entry
                        }
                    }
                }
        }
    }

    input.forEachIndexed { lineIndex, line ->
        var index = 0
        while (index < line.length) {
            val char = line[index]
            if (char.isDigit()) {
                val partNumber = line
                    .substring(index)
                    .takeWhile(Char::isDigit)
                addToGear(index, index+partNumber.length-1, lineIndex, partNumber.toLong())
                index += partNumber.length
            } else {
                index++
            }
        }
    }

    val sum = gearMap.values
        .filter { it.counter == 2 }
        .sumOf { it.value }

    println(sum)
}