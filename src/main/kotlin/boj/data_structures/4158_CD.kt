package boj.data_structures

/**
 * 문제 번호: (4158)
 * 문제 이름: (CD)
 * 소요 시간(분): (8)
 */

fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        val (n, m) = readLine().split(" ").map { it.toInt() }
        if (n == 0 && m == 0) {
            break
        }
        val visited = HashMap<String, Boolean>()
        repeat(n) {
            val a = readLine()
            visited[a] = true
        }
        var cnt = 0
        repeat(m) {
            val a = readLine()
            if (visited.containsKey(a)) {
                cnt++
            }
        }
        println(cnt)
    }

    close()
}