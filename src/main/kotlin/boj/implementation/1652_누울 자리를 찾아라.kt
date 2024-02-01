package boj.implementation

/**
 * 문제 번호: (1652)
 * 문제 이름: (누울 자리를 찾아라)
 * 소요 시간(분): (15)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val graph = mutableListOf<String>()
    repeat(n) {
        val row = readLine()
        graph.add(row)
    }
    var wCnt = 0
    for (i in 0 until n) {
        var isLying = false
        for (j in 1 until n) {
            if (graph[i][j] == '.' && isLying) {
                continue
            } else if (graph[i][j] == 'X' && isLying) {
                isLying = false
            }

            if (graph[i][j] == '.' && graph[i][j - 1] == '.') {
                isLying = true
                wCnt++
            }
        }
    }

    var hCnt = 0
    for (j in 0 until n) {
        var isLying = false
        for (i in 1 until n) {
            if (graph[i][j] == '.' && isLying) {
                continue
            } else if (graph[i][j] == 'X' && isLying) {
                isLying = false
            }

            if (graph[i][j] == '.' && graph[i - 1][j] == '.') {
                isLying = true
                hCnt++
            }
        }
    }
    println("$wCnt $hCnt")
    close()
}