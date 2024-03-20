package boj.binary_search

/**
 * 문제 번호: (13706)
 * 문제 이름: (제곱근)
 * 소요 시간(분): (x)
 */

import java.math.BigInteger

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toBigInteger()
    var start = BigInteger("1")
    var end = n
    var mid = (start + end) / BigInteger("2")
    while (start <= end) {
        mid = ((start + end) / BigInteger("2"))
        if ((mid * mid) < n) {
            start = mid + BigInteger("1")
        } else if ((mid * mid) > n){
            end = mid - BigInteger("1")
        } else {
            break
        }
    }
    println(mid)
    close()
}