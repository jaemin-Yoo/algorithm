package boj.greedy

/**
 * 문제 번호: (1141)
 * 문제 이름: (접두사)
 * 소요 시간(분): (30)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val t = br.readLine().toInt()
    val ss = mutableSetOf<String>()
    repeat(t) {
        val s = br.readLine()
        ss.add(s)
    }
    val sList = ss.toList()
    val n = sList.size
    var cnt = 0
    for (i in 0 until n) {
        var add = 1
        for (j in 0 until n) {
            if (i != j) {
                if (sList[j].startsWith(sList[i])) {
                    add = 0
                    break
                }
            }
        }
        cnt += add
    }
    println(cnt)
}