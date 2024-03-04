package boj.greedy

/**
 * 문제 번호: (12933)
 * 문제 이름: (오리)
 * 소요 시간(분): (35)
 */

private val quack = listOf('q', 'u', 'a', 'c', 'k')

fun main() = with(System.`in`.bufferedReader()) {
    val s = readLine()
    val countMap = HashMap<Char, Int>()
    quack.forEach { c ->
        countMap[c] = 0
    }
    s.forEach { c ->
        val idx = quack.indexOf(c)
        val prevC = quack[(idx + 4) % 5]
        if (countMap[prevC]!! > 0) {
            countMap[prevC] = countMap[prevC]!! - 1
            countMap[c] = countMap[c]!! + 1
        } else if (c == 'q') {
            countMap[c] = countMap[c]!! + 1
        } else {
            println(-1)
            return@with
        }
    }
    for ((k, v) in countMap) {
        if ((k != 'k' && v > 0) || (k == 'k' && v == 0)) {
            println(-1)
            return@with
        }
    }

    println(countMap['k'])
    close()
}