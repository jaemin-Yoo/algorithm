package boj.주사위조합3

private const val DICE_SIZE = 6

class Solution {
    fun solution(dice: Array<IntArray>): IntArray {
        val n = dice.size
        val diceCombinations = getDiceCombinations(n)
        var maxProb = 0.0
        var answer = intArrayOf()
        diceCombinations.forEach { aDice ->
            val totalProb = getTotalProbability(n, aDice, dice)
            if (maxProb < totalProb) {
                maxProb = totalProb
                answer = aDice
            }
        }
        return answer
    }

    private fun getTotalProbability(n: Int, aDice: IntArray, dice: Array<IntArray>): Double {
        var prob = 0.0
        val bDice = (1..n).filter { it !in aDice}
        for (d1 in aDice) {
            for (d2 in bDice) {
                prob += getWinProbability(dice[d1 - 1], dice[d2 - 1])
            }
        }
        return prob
    }

    private fun getWinProbability(dice1: IntArray, dice2: IntArray): Double {
        var cnt = 0
        for (d1 in dice1) {
            for (d2 in dice2) {
                if (d1 > d2) {
                    cnt += 1
                }
            }
        }
        return cnt.toDouble() / (DICE_SIZE * DICE_SIZE)
    }

    private fun getDiceCombinations(n: Int): List<IntArray> {
        val combinations = mutableListOf<IntArray>()
        combine(1, n, mutableListOf(), combinations)
        return combinations
    }

    private fun combine(start: Int, n: Int, temp: MutableList<Int>, combinations: MutableList<IntArray>) {
        if (temp.size == n / 2) {
            combinations.add(temp.toIntArray())
            return
        }

        for (i in start..n) {
            temp.add(i)
            combine(i + 1, n, temp, combinations)
            temp.removeLast()
        }
    }
}