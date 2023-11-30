package boj.Greedy

fun main() = with(System.`in`.bufferedReader()) {
    val (n, c) = readLine().split(" ").map { it.toInt() }
    val m = readLine().toInt()

    val list = mutableListOf<Node>()
    repeat(m) {
        val (t, r, s) = readLine().split(" ").map { it.toInt() }
        list.add(Node(t, r, s))
    }
    list.sortWith(compareBy<Node> { it.r }.thenByDescending { it.t })

    var result = 0
    val truck = MutableList(n + 1) { c }
    list.forEach { (t, r, s) ->
        val mn = truck.subList(t, r).minOf { it }
        if (mn == 0) return@forEach

        if (mn > s) {
            result += s
            for (i in t until r) {
                truck[i] -= s
            }
        } else {
            result += mn
            for (i in t until r) {
                truck[i] -= mn
            }
        }
    }
    println(result)

    close()
}

data class Node(
    val t: Int,
    val r: Int,
    val s: Int
)