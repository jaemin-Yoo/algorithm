package boj.Greedy.소트1083

import kotlin.math.min

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val a = readLine().split(" ").map { it.toInt() }.toMutableList()
    var s = readLine().toInt()

    for (i in 0 until n - 1) {
        if (s == 0) {
            break
        }

        val tempList = a.slice(i + 1..min(i + s, n - 1))
        val mx = tempList.maxOf { it }
        if (mx <= a[i]) continue
        val idx = a.indexOf(mx)
        a.removeAt(idx)
        a.add(i, mx)
        s -= idx - i
    }
    println(a.joinToString(" "))
    close()
}