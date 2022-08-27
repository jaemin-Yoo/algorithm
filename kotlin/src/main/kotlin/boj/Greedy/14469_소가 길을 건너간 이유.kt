package boj.Greedy

fun main() {
    val n = readln().toInt()
    val arr = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val (s, e) = readln().split(' ').map { it.toInt() }
        arr.add(s to e)
    }
    arr.sortBy { it.first }

    var time = 0
    for (t in arr) {
        if (time < t.first) {
            time = t.first
        }
        time += t.second
    }
    println(time)
}