package boj.Greedy

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val (d, r) = readLine().split(" ").map{ it.toInt() }
        list.add(d to r)
    }
    list.sortWith(compareBy<Pair<Int, Int>> { it.first }.thenByDescending { it.second } )

    var day = 1
    var result = 0
    for ((d, r) in list) {
        if (d >= day) {
            println("$d $r")
            result += r
            day += 1
        }
    }
    println(result)
    close()
}