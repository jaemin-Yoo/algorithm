package boj.Greedy

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val n = readln().toInt()
        val arr = readln().split(' ').map { it.toInt() }
        var maxValue = 0
        var result = 0L
        for (i in arr.lastIndex downTo 0) {
            if (maxValue < arr[i]) {
                maxValue = arr[i]
            } else {
                result += maxValue - arr[i]
            }
        }
        println(result)
    }
}