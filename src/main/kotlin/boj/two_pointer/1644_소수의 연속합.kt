package boj.two_pointer

/**
 * 문제 번호: (1644)
 * 문제 이름: (소수의 연속합)
 * 소요 시간(분): (47)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = getPrimeList(n)
    if (list.isEmpty()) {
        println(0)
        return
    }

    val result = twoPointer(n, list)
    println(result)

    close()
}

private fun twoPointer(n: Int, list: List<Int>): Int {
    var (start, end, sum, count) = arrayOf(0, 0, 2, 0)

    while (end < list.size) {
        when {
            sum < n -> {
                end += 1
                if (end < list.size) {
                    sum += list[end]
                }
            }
            sum > n -> {
                sum -= list[start]
                start += 1
            }
            else -> {
                count += 1
                end += 1
                if (end < list.size) {
                    sum += list[end]
                }
            }
        }
    }

    return count
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