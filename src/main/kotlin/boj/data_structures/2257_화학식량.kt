package boj.data_structures

/**
 * 문제 번호: (2257)
 * 문제 이름: (화학식량)
 * 소요 시간(분): (15)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val s = br.readLine()
    val stack = ArrayDeque<Int>()
    s.forEach { c ->
        when (c) {
            '(' -> stack.add(-1)
            ')' -> {
                var sum = 0
                while (true) {
                    val v = stack.removeLast()
                    if (v == -1) break

                    sum += v
                }
                stack.add(sum)
            }
            'H' -> stack.add(1)
            'C' -> stack.add(12)
            'O' -> stack.add(16)
            else -> {
                val m = stack.removeLast()
                stack.add(m * c.digitToInt())
            }
        }
    }
    println(stack.sum())
}