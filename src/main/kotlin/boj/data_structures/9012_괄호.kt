package boj.data_structures

/**
 * 문제 번호: (9012)
 * 문제 이름: (괄호)
 * 소요 시간(분): (13)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    repeat(n) {
        val s = br.readLine()
        val stack = ArrayDeque<Char>()
        var result = "YES"
        s.forEach {
            if (it == '(') {
                stack.add(it)
            } else {
                if (stack.isEmpty()) {
                    result = "NO"
                    return@forEach
                }
                stack.removeLast()
            }
        }

        if (stack.isNotEmpty()) {
            result = "NO"
        }
        println(result)
    }
}