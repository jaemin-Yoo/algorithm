package boj.PrefixSum

fun main() {
    val (n, h) = readln().split(" ").map { it.toInt() }
    val arr = MutableList(h + 1) { 0 }
    repeat(n) {
        val i = readln().toInt()
        if (it % 2 == 0) {
            arr[0] += 1
            arr[i] -= 1
        } else {
            arr[h - i] += 1
            arr[h] -= 1
        }
    }

    for (i in 1 until h + 1) {
        arr[i] += arr[i - 1]
    }
    arr.removeLast()

    val m = arr.minOf { it }
    val c = arr.count { it == m }
    println("$m $c")
}