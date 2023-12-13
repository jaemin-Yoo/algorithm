package boj.string

/**
 * 문제 번호: (5052)
 * 문제 이름: (전화번호 목록)
 * 소요 시간(분): (x)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    repeat(t) {
        val n = readLine().toInt()
        val list = mutableListOf<String>()
        repeat(n) {
            val number = readLine()
            list.add(number)
        }
        list.sort()

        val result = if (consistency(n, list)) {
            "YES"
        } else {
            "NO"
        }
        println(result)
    }
    close()
}

private fun consistency(n: Int, list: MutableList<String>): Boolean {
    for (i in 0 until n - 1) {
        val a = list[i]
        val b = list[i + 1]
        if (a.length > b.length) {
            if (a.substring(b.indices) == b) {
                return false
            }
        } else {
            if (b.substring(a.indices) == a) {
                return false
            }
        }
    }

    return true
}