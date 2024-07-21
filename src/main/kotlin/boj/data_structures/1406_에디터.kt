package boj.data_structures

/**
 * 문제 번호: (1406)
 * 문제 이름: (에디터)
 * 소요 시간(분): (17)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val s = br.readLine()
    val n = br.readLine().toInt()
    val s1 = ArrayDeque<Char>()
    val s2 = ArrayDeque<Char>()
    s.forEach { s2.add(it) }
    repeat(n) {
        val row = br.readLine().split(' ').map { it[0] }
        when (row[0]) {
            'L' -> if (s2.isNotEmpty()) {
                s1.add(s2.removeLast())
            }
            'D' -> if (s1.isNotEmpty()) {
                s2.add(s1.removeLast())
            }
            'B' -> if (s2.isNotEmpty()) {
                s2.removeLast()
            }
            'P' -> s2.add(row[1])
        }
    }
    while (s1.isNotEmpty()) {
        s2.add(s1.removeLast())
    }

    print(s2.joinToString(""))
}