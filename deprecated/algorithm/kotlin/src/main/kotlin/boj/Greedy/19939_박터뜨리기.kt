package boj.Greedy

fun main() {
    val (n, k) = readln().split(" ").map{ it.toInt() }
    val list = MutableList(k) { i -> i + 1}

    val a = n - list.sum()
    if (a < 0) {
        println(-1)
    } else {
        val result = if (a % k > 0) {
            list[k - 1] - list[0] + 1
        } else {
            list[k - 1] - list[0]
        }
        println(result)
    }
}