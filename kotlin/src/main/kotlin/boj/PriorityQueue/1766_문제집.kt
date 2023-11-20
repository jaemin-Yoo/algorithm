package boj.PriorityQueue.문제집1766

import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = Array(n + 1) { mutableListOf<Int>() }
    val isDegree = IntArray(n + 1)
    repeat(m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        arr[a].add(b)
        isDegree[b] += 1
    }

    val pq = PriorityQueue<Int>()
    for (i in 1 until n + 1) {
        if (isDegree[i] == 0) {
            pq.add(i)
        }
    }

    val result = IntArray(n)
    for (i in 1 until n + 1) {
        val x = pq.poll()
        result[i - 1] = x

        for (j in arr[x]) {
            isDegree[j] -= 1
            if (isDegree[j] == 0) {
                pq.add(j)
            }
        }
    }

    println(result.joinToString(" "))
    close()
}

/*

6 7
5 6
5 2
2 4
4 3
2 1
6 1
1 3

5 2 4 6 1 3

 */