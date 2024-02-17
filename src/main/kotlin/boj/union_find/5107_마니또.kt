package boj.union_find

/**
 * 문제 번호: (5107)
 * 문제 이름: (마니또)
 * 소요 시간(분): (22)
 */

fun main() = with(System.`in`.bufferedReader()) {
    var i = 1
    while (true) {
        val n = readLine().toInt()
        if (n == 0) break
        val map = HashMap<String, String>()
        var cnt = 0
        repeat(n) {
            val (a, b) = readLine().split(" ")
            if (isSameParent(map, a, b)) {
                cnt++
                return@repeat
            }
            unionParent(map, a, b)
        }
        println("$i $cnt")
        i++
    }
    close()
}

private fun getParent(map: HashMap<String, String>, x: String): String {
    if (!map.containsKey(x) || map[x]!! == x) {
        return x
    }

    return getParent(map, map[x]!!)
}

private fun unionParent(map: HashMap<String, String>, a: String, b: String) {
    val x = getParent(map, a)
    val y = getParent(map, b)
    if (x > y) {
        map[a] = y
        map[b] = y
    } else {
        map[a] = x
        map[b] = x
    }
}

private fun isSameParent(map: HashMap<String, String>, a: String, b: String): Boolean {
    val x = getParent(map, a)
    val y = getParent(map, b)
    return x == y
}