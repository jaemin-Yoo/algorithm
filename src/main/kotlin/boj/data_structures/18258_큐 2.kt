package boj.data_structures

/**
 * 문제 번호: (18258)
 * 문제 이름: (큐 2)
 * 소요 시간(분): (10)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val q = ArrayDeque<Int>()
    val sb = StringBuilder()
    repeat(n) {
        val cmd = br.readLine().split(' ')
        when (cmd[0]) {
            "push" -> q.add(cmd[1].toInt())
            "pop" -> {
                val data = if (q.isEmpty()) {
                    -1
                } else {
                    q.removeFirst()
                }
                sb.appendLine(data)
            }
            "size" -> sb.appendLine(q.size)
            "empty" -> {
                val data = if (q.isEmpty()) {
                    1
                } else {
                    0
                }
                sb.appendLine(data)
            }
            "front" -> {
                val data = if (q.isEmpty()) {
                    -1
                } else {
                    q.first()
                }
                sb.appendLine(data)
            }
            "back" -> {
                val data = if (q.isEmpty()) {
                    -1
                } else {
                    q.last()
                }
                sb.appendLine(data)
            }
            else -> throw NoSuchElementException()
        }
    }
    print(sb)
}