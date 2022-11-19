package boj.PrefixSum

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readln().toInt()
    val input = mutableListOf<Pair<Int, Int>>()
    val time = sortedSetOf<Int>()
    repeat(n) {
        val (te, tx) = readLine().split(" ").map { it.toInt() }
        input.add(te to tx)
        time.add(te)
        time.add(tx)
    }

    val list = ArrayList(time)
    val sum = IntArray(list.size)
    for (i in 0 until n) {
        val x = Collections.binarySearch(list, input[i].first) // indexOf
        val y = Collections.binarySearch(list, input[i].second) // indexOf
        for (j in x until y) sum[j]++
    }

    val max = sum.maxOf { it }
    val startIdx = sum.indexOfFirst { it == max }
    var endIdx = startIdx
    for (i in startIdx + 1 until sum.size) {
        if (sum[i] == max) {
            endIdx = i
        } else {
            break
        }
    }
    println(max)
    println("${list[startIdx]} ${list[endIdx + 1]}")

    close()
}