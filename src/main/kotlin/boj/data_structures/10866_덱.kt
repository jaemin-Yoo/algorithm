package boj.data_structures

/**
 * 문제 번호: (10866)
 * 문제 이름: (덱)
 * 소요 시간(분): (5)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val deque = ArrayDeque<Int>()
    val sb = StringBuilder()
    repeat(n) {
        val cmd = br.readLine().split(' ')
        when (cmd[0]) {
            "push_front" -> deque.addFirst(cmd[1].toInt())
            "push_back" -> deque.add(cmd[1].toInt())
            "pop_front" -> {
                val data = if (deque.isNotEmpty()) {
                    deque.removeFirst()
                } else {
                    -1
                }
                sb.appendLine(data)
            }
            "pop_back" -> {
                val data = if (deque.isNotEmpty()) {
                    deque.removeLast()
                } else {
                    -1
                }
                sb.appendLine(data)
            }
            "size" -> sb.appendLine(deque.size)
            "empty" -> {
                val data = if (deque.isNotEmpty()) {
                    0
                } else {
                    1
                }
                sb.appendLine(data)
            }
            "front" -> {
                val data = if (deque.isNotEmpty()) {
                    deque.first()
                } else {
                    -1
                }
                sb.appendLine(data)
            }
            "back" -> {
                val data = if (deque.isNotEmpty()) {
                    deque.last()
                } else {
                    -1
                }
                sb.appendLine(data)
            }
        }
    }
    print(sb)
}