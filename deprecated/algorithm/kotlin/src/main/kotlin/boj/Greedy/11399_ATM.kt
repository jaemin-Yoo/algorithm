package boj.Greedy

fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map{ it.toInt() }.sorted()
    var result = 0
    var sum = 0
    for (i in 0 until n) {
        sum += list[i]
        result += sum
    }
    println(result)
}