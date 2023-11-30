package boj.PrefixSum

fun main() {
    val (n, s) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }
    val dp = Array(n + 1) { 0 }
    dp[1] = list[0]
    for (i in 1 until n) {
        dp[i + 1] += dp[i] + list[i]
    }

    val result = solve(n, s, dp)
    println(result)
}

fun solve(n: Int, s: Int, dp: Array<Int>): Int {
    var left = 0
    var right = 1
    var minLength = n + 2

    while (right < n + 1) {
        val diff = dp[right] - dp[left]
        if (diff < s) {
            right += 1
            if (right >= n + 1) return if (minLength > n + 1) 0 else minLength
        } else {
            val d = right - left
            if (minLength > d) {
                minLength = d
            }
            left += 1
            if (left == right) return 1
        }
    }

    return 0
}