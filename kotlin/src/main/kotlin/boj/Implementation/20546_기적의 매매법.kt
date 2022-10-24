package boj.Implementation

fun main() {
    val n = readln().toInt()
    val stocks = readln().split(" ").map { it.toInt() }.toMutableList()

    var jN = n
    var sN = n
    var jStock = 0
    var sStock = 0
    var prevStock = stocks[0]
    var count = 0
    var isUp = false
    stocks.forEach { stock ->
        if (jN / stock > 0) {
            jStock += jN / stock
            jN %= stock
        }

        if (prevStock < stock) {
            if (isUp.not()) {
                count = 0
                isUp = true
            }
            count += 1
        } else if (prevStock > stock) {
            if (isUp) {
                count = 0
                isUp = false
            }
            count -= 1
        }

        prevStock = stock

        if (count > 2) {
            if (sStock > 0) {
                sN = sStock * stock
                sStock = 0
            }
        } else if (count < -2) {
            if (sN / stock > 0) {
                sStock += sN / stock
                sN %= stock
            }
        }
    }

    val jun = stocks[stocks.lastIndex] * jStock + jN
    val sung = stocks[stocks.lastIndex] * sStock + sN

    println(if (jun > sung) "BNP" else if (jun == sung) "SAMESAME" else "TIMING")
}