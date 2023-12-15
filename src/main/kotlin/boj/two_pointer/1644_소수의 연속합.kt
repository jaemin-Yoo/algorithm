package boj.two_pointer

/**
 * 문제 번호: (1644)
 * 문제 이름: (소수의 연속합)
 * 소요 시간(분): (47)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = getPrimeList(n)
    var start = 0
    var end = 0

    if (list.isEmpty()) {
        println(0)
    } else {
        var sum = list[0]
        var result = 0
        while (start <= end) {
            if (n == sum) {
                result += 1
            }

            if (n >= sum) {
                end += 1
                if (end > list.lastIndex) break

                sum += list[end]
            } else {
                sum -= list[start]
                start += 1
            }
        }
        println(result)
    }

    close()
}

private fun getPrimeList(n: Int): List<Int> {
    val list = mutableListOf<Int>()
    for (i in 1 until n + 1) {
        if (isPrimeNumber(i)) {
            list.add(i)
        }
    }

    return list.toList()
}

private fun isPrimeNumber(x: Int): Boolean {
    if (x == 1) return false

    var i = 2
    while (i * i <= x) {
        if (x % i == 0) {
            return false
        }

        i += 1
    }

    return true
}