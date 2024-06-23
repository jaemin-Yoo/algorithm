package boj.brute_forcing

/**
 * 문제 번호: (5671)
 * 문제 이름: (호텔 방 번호)
 * 소요 시간(분): (10)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    while (true) {
        val input = br.readLine() ?: break
        val (n, m) = input.split(' ').map { it.toInt() }

        var cnt = 0
        for (i in n until m + 1) {
            if (!isRepeatNumber(i)) {
                cnt++
            }
        }
        println(cnt)
    }
}

private fun isRepeatNumber(num: Int): Boolean {
    val str = num.toString()
    val temp = mutableListOf<Char>()
    str.forEach {
        if (temp.contains(it)) {
            return true
        }
        temp.add(it)
    }
    return false
}