package boj.Implementation

fun main() {
    val arr = Array(30) { 0 }
    repeat(28) {
        val n = readln().toInt()
        arr[n - 1] = 1
    }
    for (i in arr.indices) {
        if (arr[i] == 0) {
            println(i + 1)
        }
    }
}