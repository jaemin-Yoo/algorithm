package boj.Greedy

fun main() {
    val n = readln().toInt()
    val change = listOf(500, 100, 50, 10, 5, 1)
    var price = 1000 - n
    var result = 0
    for (i in change) {
        result += price / i
        price %= i
    }
    println(result)
}