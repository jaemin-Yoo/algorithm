package boj.string

/**
 * 문제 번호: (20310)
 * 문제 이름: (타노스)
 * 소요 시간(분): (13)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val s = br.readLine()
    var removeZeroCount = s.count { it == '0' } / 2
    var removeOneCount = s.count { it == '1' } / 2
    val sb = StringBuilder()
    s.forEach { c ->
        if ((removeZeroCount > 0 && c == '0') || (removeOneCount == 0 && c == '1')) {
            sb.append(c)
        }

        if (removeZeroCount > 0 && c == '0') {
            removeZeroCount--
        } else if (removeOneCount > 0 && c == '1') {
            removeOneCount--
        }
    }
    print(sb)
}