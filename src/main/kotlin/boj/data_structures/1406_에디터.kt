package boj.data_structures

/**
 * 문제 번호: (1406)
 * 문제 이름: (에디터)
 * 소요 시간(분): (x)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val s = readLine()
    val m = readLine().toInt()
    val s1 = ArrayDeque<Char>()
    val s2 = ArrayDeque<Char>()
    for (c in s) {
        s1.add(c)
    }
    repeat(m) {
        val row = readLine().split(" ")
        when (row[0][0]) {
            'L' -> if (s1.isNotEmpty()) {
                val c = s1.removeLast()
                s2.add(c)
            }
            'D' -> if (s2.isNotEmpty()) {
                val c = s2.removeLast()
                s1.add(c)
            }
            'B' -> if (s1.isNotEmpty()) {
                s1.removeLast()
            }
            'P' -> s1.add(row[1][0])
        }
    }
    while (s1.isNotEmpty()) {
        val c = s1.removeLast()
        s2.add(c)
    }
    val result = StringBuilder()
    while (s2.isNotEmpty()) {
        val c = s2.removeLast()
        result.append(c)
    }
    println(result)
    close()
}