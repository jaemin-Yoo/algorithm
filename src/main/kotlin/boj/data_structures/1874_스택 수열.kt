package boj.data_structures

/**
 * 문제 번호: (1874)
 * 문제 이름: (스택 수열)
 * 소요 시간(분): (15)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val stack = ArrayDeque<Int>()
    val sb = StringBuilder()
    var num = 1
    var no = false
    repeat(n) {
        val a = br.readLine().toInt()
        if (no) { return@repeat }

        while (stack.isEmpty() || stack.last() < a) {
            stack.add(num++)
            sb.appendLine('+')
        }

        if (stack.last() == a) {
            stack.removeLast()
            sb.appendLine('-')
        } else {
            sb.clear()
            sb.append("NO")
            no = true
        }
    }
    print(sb)
}