package boj.Implementation

fun main() {
    val n = readln().toInt()
    val arr = Array(10) { -1 }
    var cnt = 0
    repeat(n) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        if (arr[a - 1] != b && arr[a - 1] != -1) {
            cnt += 1
        }
        arr[a - 1] = b
    }
    println(cnt)
}