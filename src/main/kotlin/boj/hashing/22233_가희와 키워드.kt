package boj.hashing

/**
 * 문제 번호: (22233)
 * 문제 이름: (가희와 키워드)
 * 소요 시간(분): (8)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val map = HashMap<String, Boolean>()
    repeat(n) {
        val s = br.readLine()
        map[s] = true
    }
    val sb = StringBuilder()
    repeat(m) {
        val arr = br.readLine().split(',')
        arr.forEach { s ->
            if (map.containsKey(s)) {
                map.remove(s)
            }
        }
        sb.appendLine(map.size)
    }
    print(sb)
}