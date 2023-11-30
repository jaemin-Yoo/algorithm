package boj.카톡선물기능1

import kotlin.math.max

class Solution {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        val n = friends.size
        val indexMap = getIndexMap(friends)
        val graph = getGiftGraph(n, indexMap, gifts)
        val giftCount = getGiftCount(n, graph)

        var answer = 0
        for (i in 0 until n) {
            var cnt = 0
            for (j in 0 until n) {
                if (i != j) {
                    // 자기 자신을 제외하고 선물을 더 많이 주었거나, 선물 지수가 높은 경우
                    if (graph[i][j] > graph[j][i] || (graph[i][j] == graph[j][i] && giftCount[i] > giftCount[j])) {
                        cnt += 1
                    }
                }
            }
            answer = max(answer, cnt)
        }

        return answer
    }

    private fun getGiftGraph(n: Int, indexMap: HashMap<String, Int>, gifts: Array<String>): Array<IntArray> {
        val graph = Array(n) { IntArray(n) }
        gifts.forEach { s ->
            val (from, to) = s.split(" ").map { indexMap[it]!! }
            graph[from][to] += 1
        }
        return graph
    }

    private fun getGiftCount(n: Int, graph: Array<IntArray>): IntArray {
        val giftCount = IntArray(n)
        for (i in 0 until n) {
            val givenGiftCount = graph[i].sum()
            val receivedGiftCount = graph.sumOf { it[i] }
            giftCount[i] = givenGiftCount - receivedGiftCount
        }
        return giftCount
    }

    private fun getIndexMap(friends: Array<String>): HashMap<String, Int> {
        // 각 사람들을 friends의 index로 매핑하는 함수
        val indexMap = HashMap<String, Int>()
        for (i in friends.indices) {
            val friend = friends[i]
            indexMap[friend] = i
        }
        return indexMap
    }
}