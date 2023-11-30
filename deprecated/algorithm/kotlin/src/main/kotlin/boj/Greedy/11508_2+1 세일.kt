package boj.Greedy

fun main() {
    val n = readln().toInt()
    val arr = mutableListOf<Int>()
    repeat(n) {
        arr.add(readln().toInt())
    }
    arr.sortDescending()

    var result = 0
    for (i in arr.indices) {
        if (i % 3 != 2) {
            result += arr[i]
        }
    }
    println(result)
}