package boj.Greedy

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val k = readLine().toInt()
    if (n == 1 || k >= n) {
        readLine()
        println(0)
    } else {
        val list = readLine().split(" ").map { it.toInt() }.sorted()

        val dist = mutableListOf<Int>()
        for (i in 1 until n) {
            dist.add(list[i] - list[i - 1])
        }
        dist.sort()
        repeat(k - 1) {
            dist.removeLast()
        }

        println(dist.sum())
    }

    close()
}