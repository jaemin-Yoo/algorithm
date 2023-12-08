package hackerrank.implementation

import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'extraLongFactorials' function below.
 *
 * The function accepts INTEGER n as parameter.
 */

fun extraLongFactorials(n: Int): Unit {
    val result = factorial(n.toBigInteger())
    println(result)
}

private fun factorial(n: BigInteger): BigInteger {
    val one = 1.toBigInteger()
    return if (n.compareTo(one) == 0) {
        one
    } else {
        factorial(n.minus(one)) * n
    }
}

private fun Int.toBigInteger() = BigInteger(this.toString())

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()

    extraLongFactorials(n)
}
