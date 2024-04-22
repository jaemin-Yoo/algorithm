package boj.data_structures

/**
 * 문제 번호: (10828)
 * 문제 이름: (스택)
 * 소요 시간(분): (8)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val stack = ArrayDeque<Int>()
    val sb = StringBuilder()
    repeat(n) {
        val cmd = br.readLine().split(' ')
        when(cmd[0]) {
            "push" -> stack.add(cmd[1].toInt())
            "pop" -> {
                val res = if (stack.isNotEmpty()) {
                    stack.removeLast()
                } else {
                    -1
                }
                sb.appendLine(res)
            }
            "size" -> sb.appendLine(stack.size)
            "empty" -> {
                val res = if (stack.isEmpty()) {
                    1
                } else {
                    0
                }
                sb.appendLine(res)
            }
            "top" -> {
                val res = if (stack.isNotEmpty()) {
                    stack.last()
                } else {
                    -1
                }
                sb.appendLine(res)
            }
        }
    }
    println(sb)
}