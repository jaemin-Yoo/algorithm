package boj.PrefixSum

fun main() = with(System.`in`.bufferedReader()){
    val (n, _, _, m) = readLine().split(" ").map { it.toInt() }
    val sleep = readLine().split(" ").map { it.toInt() }
    val start = readLine().split(" ").map { it.toInt() }

    val slp = Array(n + 3) { false }
    sleep.forEach {
        slp[it] = true
    }

    val check = Array(n + 3) { 1 }.also {
        repeat(3) { i -> it[i] = 0 }
    }
    start.forEach {
        var i = it
        var cnt = 2
        if (slp[it]) {
            return@forEach
        }

        while (i <= n + 2) {
            if (slp[i].not()) {
                check[i] = 0
            }
            i = it * cnt
            cnt += 1
        }
    }

    val prefixSum = Array(n + 3) { 0 }
    for (i in 1..n + 2) {
        prefixSum[i] = prefixSum[i - 1] + check[i]
    }

    val result = mutableListOf<Int>()
    repeat(m) {
        val (s, e) = readLine().split(" ").map { it.toInt() }
        result.add(prefixSum[e] - prefixSum[s - 1])
    }

    result.forEach {
        println(it)
    }

    close()
}