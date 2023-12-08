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
 * Complete the 'climbingLeaderboard' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY ranked
 *  2. INTEGER_ARRAY player
 */

fun climbingLeaderboard(ranked: Array<Int>, player: Array<Int>): Array<Int> {
    val rankArr = ranked.distinct()
    val playerRanked = player.map { score ->
        getRank(score, rankArr)
    }.toTypedArray()
    return playerRanked
}

private fun getRank(score: Int, rankArr: List<Int>): Int {
    var start = 0
    var end = rankArr.size
    var result = rankArr.size

    while (start <= end) {
        val mid = (start + end) / 2

        if (mid >= rankArr.size) break

        if (rankArr[mid] > score) {
            start = mid + 1
        } else {
            result = mid
            end = mid - 1
        }
    }

    return result + 1
}

fun main(args: Array<String>) {
    val rankedCount = readLine()!!.trim().toInt()

    val ranked = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val playerCount = readLine()!!.trim().toInt()

    val player = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val result = climbingLeaderboard(ranked, player)

    println(result.joinToString("\n"))
}
