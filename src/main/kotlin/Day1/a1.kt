package Day1

fun main() {
    val elves = linkedSetOf<Int>()
    var calories = 0
    generateSequence(::readLine).forEach {
        if (it.isBlank()) {
            elves.add(calories)
            calories = 0
            return@forEach
        }
        calories += it.toInt()
    }
    elves.add(calories)

    println(elves.max())
}
