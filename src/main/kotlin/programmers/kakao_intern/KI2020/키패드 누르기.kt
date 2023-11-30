package programmers.KI2020.키패드누르기

// 40분

import kotlin.math.abs

private const val STAR = 10
private const val HASH = 11

class Solution {

    val n = 4
    val m = 3

    fun solution(numbers: IntArray, hand: String): String {
        val keypadPosition = Array(12) { 0 to 0 }
        setKeypadPosition(keypadPosition)

        var leftFinger = STAR
        var rightFinger = HASH
        val result = CharArray(numbers.size)

        numbers.forEachIndexed { i, number ->
            when (number) {
                1, 4, 7 -> {
                    leftFinger = number
                    result[i] = 'L'
                }
                3, 6, 9 -> {
                    rightFinger = number
                    result[i] = 'R'
                }
                else -> {
                    val leftDist = getDistance(leftFinger, number, keypadPosition)
                    val rightDist = getDistance(rightFinger, number, keypadPosition)
                    result[i] = if (isLeftFinger(leftDist, rightDist, hand)) {
                        leftFinger = number
                        'L'
                    } else {
                        rightFinger = number
                        'R'
                    }
                }
            }
        }

        return result.joinToString("")
    }

    private fun setKeypadPosition(keypadPosition: Array<Pair<Int, Int>>) {
        var number = 0
        keypadPosition[number] = 3 to 1

        for (i in 0 until n - 1) {
            for (j in 0 until m) {
                number += 1
                keypadPosition[number] = i to j
            }
        }

        keypadPosition[STAR] = 3 to 0
        keypadPosition[HASH] = 3 to 2
    }

    private fun getDistance(start: Int, end: Int, keypadPosition: Array<Pair<Int, Int>>): Int {
        val (x, y) = keypadPosition[start]
        val (a, b) = keypadPosition[end]

        return abs(x - a) + abs(y - b)
    }

    private fun isLeftFinger(leftDist: Int, rightDist: Int, hand: String): Boolean {
        return if (leftDist < rightDist) {
            true
        } else if (leftDist > rightDist) {
            false
        } else {
            hand == "left"
        }
    }
}