package boj.hashing

/**
 * 문제 번호: (4848)
 * 문제 이름: (집합 숫자 표기법)
 * 소요 시간(분): (22)
 */

private const val MAX_NUM = 15

fun main() = System.`in`.bufferedReader().use { br ->
    val ss = Array(MAX_NUM + 1) { "" }
    val map = HashMap<String, Int>()
    ss[0] = "{}"
    ss[1] = "{{}}"
    val sb = StringBuilder("{{}}")
    for (i in 2 until MAX_NUM + 1) {
        sb.insert(sb.lastIndex, ",${ss[i - 1]}")
        ss[i] = sb.toString()
    }
    for (i in 0 until MAX_NUM + 1) {
        map[ss[i]] = i
    }

    val t = br.readLine().toInt()
    repeat(t) {
        val a = br.readLine()
        val b = br.readLine()
        val num = map[a]!! + map[b]!!
        println(ss[num])
    }
}