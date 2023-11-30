package boj.Greedy

fun main() {
    val n = readln().toInt()
    val list = mutableListOf<Int>()
    var dasom = readln().toInt()
    repeat(n - 1) {
        list.add(readln().toInt())
    }

    var result = 0
    var max = list.maxOrNull() ?: -1
    while (max >= dasom) {
        result += 1
        val idx = list.indexOf(max)
        list[idx] -= 1
        dasom += 1
        max = list.maxOrNull()!!
    }

    println(result)
}