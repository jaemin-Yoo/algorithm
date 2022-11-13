package boj.PrefixSum

fun main() = with(System.`in`.bufferedReader()) {
    val n = readln().toInt()
    val input = mutableListOf<Pair<Int, Int>>()
    val time = sortedSetOf<Int>()
    repeat(n) {
        val (te, tx) = readLine().split(" ").map { it.toInt() }
        input.add(te to tx - 1)
        time.add(te)
        time.add(tx - 1)
        time.add(tx)
    }

    close()
}