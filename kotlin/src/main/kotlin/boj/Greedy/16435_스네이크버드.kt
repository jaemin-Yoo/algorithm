package boj.Greedy

fun main() {
    val (_, l) = readln().split(' ').map { it.toInt() }
    val arr = readln().split(' ').map { it.toInt() }.sorted()

    var result = l
    for (i in arr) {
        if (result >= i) {
            result += 1
        }
    }
    println(result)
}