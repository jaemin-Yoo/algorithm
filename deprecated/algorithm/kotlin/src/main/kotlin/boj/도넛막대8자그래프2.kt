package boj.도넛막대8자그래프2

data class NodeCount(
    val inCount: Int,
    val outCount: Int
)

enum class GraphShape {
    DONUT, STICK, EIGHT
}

class Solution {
    fun solution(edges: Array<IntArray>): IntArray {
        val graph = getNodeGraph(edges)
        val nodeCountMap = getNodeCountMap(edges)
        val creationNode = getCreationNode(nodeCountMap)
        var donutCount = 0
        var stickCount = 0
        var eightCount = 0
        graph[creationNode]?.forEach { node ->
            when (getGraphShape(node, graph)) {
                GraphShape.DONUT -> donutCount += 1
                GraphShape.STICK -> stickCount += 1
                GraphShape.EIGHT -> eightCount += 1
            }
        }

        return intArrayOf(creationNode, donutCount, stickCount, eightCount)
    }

    private fun getGraphShape(node: Int, graph: HashMap<Int, MutableList<Int>>): GraphShape {
        var n = node
        while (graph.containsKey(n)) {
            if (graph[n]!!.size >= 2) { // 나가는 간선(다음 노드)의 개수가 2개 이상인 경우 8자 그래프
                return GraphShape.EIGHT
            }
            n = graph[n]!![0]

            if (n == node) { // 자기 자신의 노드로 다시 돌아온다면 도넛 그래프
                return GraphShape.DONUT
            }
        }

        return GraphShape.STICK
    }

    private fun getNodeGraph(edges: Array<IntArray>): HashMap<Int, MutableList<Int>> {
        val graph = HashMap<Int, MutableList<Int>>()
        edges.forEach { (a, b) ->
            if (!graph.containsKey(a)) {
                graph[a] = mutableListOf(b)
            } else {
                graph[a]!!.add(b)
            }
        }
        return graph
    }

    private fun getNodeCountMap(edges: Array<IntArray>): HashMap<Int, NodeCount> {
        // 각 노드별 들어오는 간선, 나가는 간선 개수를 포함한 해시 테이블 반환 함수
        val map = HashMap<Int, NodeCount>()
        edges.forEach { (a, b) ->
            if (!map.containsKey(a)) {
                map[a] = NodeCount(0, 1)
            } else {
                map[a] = NodeCount(map[a]!!.inCount, map[a]!!.outCount + 1)
            }

            if (!map.containsKey(b)) {
                map[b] = NodeCount(1, 0)
            } else {
                map[b] = NodeCount(map[b]!!.inCount + 1, map[b]!!.outCount)
            }
        }
        return map
    }

    private fun getCreationNode(map: HashMap<Int, NodeCount>): Int {
        // 생성 노드 조건: 자기 자신한테 들어오는 간선은 없고 나가는 간선이 2개 이상일 때
        for ((k, v) in map) {
            if (v.inCount == 0 && v.outCount >= 2) {
                return k
            }
        }

        return -1
    }
}