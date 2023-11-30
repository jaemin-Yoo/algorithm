package boj.Greedy

fun main() {
    val n = readln().toInt()
    var cnt = 0

    if (n >= 5) {
        var v = n / 5
        while (v >= 0) {
            val m = n - v * 5
            if (m % 2 == 0) {
                cnt += m / 2
                break
            }
            v -= 1
        }
        cnt += v
        println(cnt)
    } else if (n % 2 == 0) {
        println(n / 2)
    } else {
        println(-1)
    }
}