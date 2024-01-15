package boj.two_pointer

/**
 * 문제 번호: (1253)
 * 문제 이름: (좋다)
 * 소요 시간(분): (32)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }
    val map = HashMap<Int, MutableList<Pair<Int, Int>>>()
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            val x = arr[i] + arr[j]
            if (map.containsKey(x)) {
                map[x]!!.add(i to j)
            } else {
                map[x] = mutableListOf(i to j)
            }
        }
    }

    var cnt = 0
    for (i in 0 until n) {
        val x = arr[i]
        if (map.containsKey(x)) {
            for ((a, b) in map[x]!!) {
                if (a != i && b != i) {
                    cnt++
                    break
                }
            }
        }
    }
    println(cnt)

    close()
}