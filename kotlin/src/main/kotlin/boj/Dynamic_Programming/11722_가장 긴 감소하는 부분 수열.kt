package boj.Dynamic_Programming.가장긴감소하는부분수열11722

fun main() {
    val n = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    val dp = IntArray(n) { 1 }

    for (i in 0 until n) {
        for (j in i + 1 until n) {
            if (list[i] > list[j]) {
                if (dp[j] < dp[i] + 1) {
                    dp[j] = dp[i] + 1
                }
            }
        }
    }

    print(dp.maxOf { it })
}
/*

10 30 10 20 20 10

1  1  1  1  1  1
1  1  2  2  2  2
1  1  2  2  2  2
1  1  2  2  2  3
1  1  2  2  2  4

*/
