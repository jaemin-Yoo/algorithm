package boj.Greedy.흙길보수하기1911

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val (n, l) = readLine().split(" ").map { it.toInt() }
    val list = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val (s, e) = readLine().split(" ").map { it.toInt() }
        list.add(s to e)
    }
    list.sortBy { it.first }

    var cnt = 0
    var start = 0
    var mod: Int
    list.forEach { (s, e) ->
        if (e < start) {
            return@forEach
        }

        val nS = max(start, s)

        val length = e - nS
        cnt += length / l

        mod = length % l
        if (mod != 0) {
            start = l - mod + e
            cnt += 1
        }
    }

    print(cnt)

    close()
}

/*

0 1 1 0 0 1 1 0 1 0 1 1

6 - 1 + 1
6 / 3
2 - 0

5 / 3
1 - 2
3 - 2 = 1
14

1 2 3 4 5 * 7 * * * 11 12 13 14

 */