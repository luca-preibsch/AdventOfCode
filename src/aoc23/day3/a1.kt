package aoc23.day3

fun main() {
    val input = generateSequence(::readLine).toList()
    val rows = input.size
    val columns = input.first().length

    fun Char.isSymbol() = this != '.' && !this.isDigit()

//   fun isPartNumber(startIndex: Int, endIndex: Int, lineIndex: Int) : Boolean {
//        for (i in maxOf(0, lineIndex-1) .. minOf(rows-1, lineIndex+1))
//            for (j in maxOf(0, startIndex-1) .. minOf(columns-1, endIndex+1)) {
//                val char = input[i][j]
//                if (char.isSymbol())
//                    return true
//            }
//        return false
//    }

    fun isPartNumber(xStart: Int, xEnd: Int, row: Int) : Boolean {
        for (i in (row-1 .. row+1)) {
            val line = input.getOrNull(i)
            if (line != null)
                for (j in xStart-1..xEnd+1) {
                    val char = line.getOrNull(j)
                    if (char != null && char.isSymbol())
                        return true
                }
        }
        return false
    }

    var sum = 0
    input.forEachIndexed { lineIndex, line ->
        var index = 0
        while (index < line.length) {
            val char = line[index]
            if (char.isDigit()) {
                val partNumber = line
                    .substring(index)
                    .takeWhile(Char::isDigit)
                if (isPartNumber(index, index+partNumber.length-1, lineIndex))
                    sum += partNumber.toInt()
                index += partNumber.length
            } else {
                index++
            }
        }
    }
    println(sum)
}