package boj.hashing

/**
 * 문제 번호: (22233)
 * 문제 이름: (가희와 키워드)
 * 소요 시간(분): (7)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val map = HashMap<String, Boolean>()
    repeat(n) {
        val keyword = readLine()
        map[keyword] = true
    }
    repeat(m) {
        val keywords = readLine().split(",")
        keywords.forEach { keyword ->
            if (map.containsKey(keyword)) {
                map.remove(keyword)
            }
        }
        println(map.size)
    }
    close()
}