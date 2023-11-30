package boj.Greedy

fun main() {
    val n = readln().toInt()
    val arr = readln().split(' ').map { it.toInt() }
    var token = 0
    var cnt = 0
    arr.forEach {
        if (it == token) {
            token = (token + 1) % 3
            cnt += 1
        }
    }
    println(cnt)
}