package boj.PrefixSum

fun main() = with(System.`in`.bufferedReader()) {
    val n = readln().toInt()
    val input = mutableListOf<Pair<Int, Int>>()
    val time = sortedSetOf<Int>()
    repeat(n) {
        val (te, tx) = readLine().split(" ").map { it.toInt() }
        input.add(te to tx - 1)
        time.add(te)
        time.add(tx - 1)
        time.add(tx)
    }

    val map = mutableMapOf<Int, Int>()
    time.forEachIndexed { i, v ->
        map[v] = i
    }

    val temp = Array(time.size) { 0 }
    input.forEach { (e, x) ->
        temp[map[e]!!] += 1
        temp[map[x + 1]!!] += -1
    }
    println(time.joinToString(" "))

    val ps = Array(time.size + 1) { 0 }
    for (i in 0 until time.size) {
        ps[i + 1] = temp[i] + ps[i]
    }
    println(ps.contentToString())
    val mx = ps.maxOf { it }

    var start = 0
    ps.forEachIndexed { i, v ->
        if (mx == i) {

        }
    }

    close()
}