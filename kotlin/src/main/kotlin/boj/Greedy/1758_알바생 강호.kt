package boj.Greedy

fun main() {
    val n = readln().toInt()
    val list = mutableListOf<Int>()
    repeat(n) {
        list.add(readln().toInt())
    }
    list.sortDescending()

    var rank = 1
    var result = 0L
    list.forEach {
        val money = it - (rank - 1)
        result += if (money > 0) {
            money
        } else {
            0
        }
        rank += 1
    }
    println(result)
}