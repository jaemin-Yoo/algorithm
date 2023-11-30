package boj.Greedy

fun main() {
    val n = readln().toInt()
    val straws = mutableListOf<Int>()
    repeat(n) {
        val straw = readln().toInt()
        straws.add(straw)
    }
    straws.sortDescending()

    var result = -1
    for (i in 0..n - 3) {
        if (straws[i] < straws[i + 1] + straws[i + 2]) {
            result = straws[i] + straws[i + 1] + straws[i + 2]
            break
        }
    }
    println(result)
}