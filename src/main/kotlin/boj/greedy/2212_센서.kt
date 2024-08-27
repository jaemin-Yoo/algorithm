package boj.greedy

/**
 * 문제 번호: (2212)
 * 문제 이름: (센서)
 * 소요 시간(분): (x)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val k = br.readLine().toInt()
    val sensors = br.readLine().split(' ').map { it.toInt() }.sorted()
    val diff = mutableListOf<Int>()
    for (i in 1 until n) {
        diff.add(sensors[i] - sensors[i - 1])
    }
    diff.sortDescending()

    var result = 0
    for (i in k - 1 until n - 1) {
        result += diff[i]
    }
    print(result)
}