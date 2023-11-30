package programmers.KI2022.코딩테스트공부

// DP
import kotlin.math.min

class Solution {
    fun solution(alp: Int, cop: Int, problems: Array<IntArray>): Int {
        val temp = problems.map {
            it[0] to it[1]
        }
        val defaultProblem = arrayOf(
            intArrayOf(0, 0, 0, 1, 1),
            intArrayOf(0, 0, 1, 0, 1)
        )
        val goalAlp = temp.maxOf { it.first }
        val goalCop = temp.maxOf { it.second }
        val dp = Array(goalAlp + 1) { IntArray(goalCop + 1) { Int.MAX_VALUE} }
        val newProblems = defaultProblem + problems

        val mnAlp = min(goalAlp, alp)
        val mnCop = min(goalCop, cop)
        dp[mnAlp][mnCop] = 0

        for (i in mnAlp until goalAlp + 1) {
            for (j in mnCop until goalCop + 1) {
                newProblems.forEach { (alpReq, copReq, alpRwd, copRwd, cost) ->
                    if (i >= alpReq && j >= copReq) {
                        val newAlp = min(goalAlp, i + alpRwd)
                        val newCop = min(goalCop, j + copRwd)
                        dp[newAlp][newCop] = min(dp[newAlp][newCop], dp[i][j] + cost)
                    }
                }
            }
        }
        return dp[goalAlp][goalCop]
    }
}

/*
// 다익스트라

import java.util.Queue
import java.util.LinkedList
import kotlin.math.min

class Solution {
    fun solution(alp: Int, cop: Int, problems: Array<IntArray>): Int {
        val temp = problems.map {
            it[0] to it[1]
        }
        val defaultProblem = arrayOf(
            intArrayOf(0, 0, 0, 1, 1),
            intArrayOf(0, 0, 1, 0, 1)
        )
        val goalAlp = temp.maxOf { it.first }
        val goalCop = temp.maxOf { it.second }
        val distances = Array(goalAlp + 1) { IntArray(goalCop + 1) { Int.MAX_VALUE } }

        dijkstra(alp, cop, goalAlp, goalCop, distances, defaultProblem + problems)
        return distances[goalAlp][goalCop]
    }

    private fun dijkstra(alp: Int, cop: Int, goalAlp: Int, goalCop: Int, distances: Array<IntArray>, problems: Array<IntArray>) {
        val q: Queue<Triple<Int, Int, Int>> = LinkedList()
        q.add(Triple(min(goalAlp, alp), min(goalCop, cop), 0))

        while (q.isNotEmpty()) {
            val (a, c, d) = q.poll()

            if (distances[a][c] < d) continue

            problems.forEach { (alpReq, copReq, incAlp, incCop, dist) ->
                val newDist = dist + d
                val newAlp = min(goalAlp, a + incAlp)
                val newCop = min(goalCop, c + incCop)
                if (a >= alpReq && c >= copReq && distances[newAlp][newCop] > newDist) {
                    distances[newAlp][newCop] = newDist
                    q.add(Triple(newAlp, newCop, newDist))
                }
            }
        }
    }
}
*/