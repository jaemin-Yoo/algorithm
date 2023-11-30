package boj.PrefixSum

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val a = br.readLine().split(" ").map { it.toInt() }
    val sa = Array(n + 1) { 0 }

    for (i in 1 until n + 1) {
        sa[i] = sa[i - 1] + a[i - 1]
    }

    val m = br.readLine().toInt()
    repeat(m) {
        val (i, j) = br.readLine().split(" ").map { it.toInt() }
        println(sa[j] - sa[i - 1])
    }
}