//package boj.hackerrank
//
//import java.util.*
//
//fun main() {
////    val centreNodes = 6
////    val centreFrom = listOf(1, 1, 1, 2, 3, 3, 5, 4)
////    val centreTo = listOf(2, 4, 3, 4, 4, 5, 6, 6)
////    val status = listOf(3, 2, 3, 1, 2, 1)
//    val centreNodes = 7
//    val centreFrom = listOf(1, 1, 2, 2, 3, 3)
//    val centreTo = listOf(2, 3, 4, 5, 6, 7)
//    val status = listOf(2, 2, 2, 3, 2, 2, 1)
//    val result = findMinimumTime(centreNodes, centreFrom, centreTo, status)
//    println(result)
//}
//
//fun findMinimumTime(centreNodes: Int, centreFrom: List<Int>, centreTo: List<Int>, status: List<Int>): Int {
//    val graph = List(centreNodes + 1) { mutableListOf<Int>() } // List<List<Integer>> graph = new ArrayList<>(centreNodes + 1);
//    val visited = MutableList(centreNodes + 1) { false } // List<Boolean> visited = new ArrayList<>(Collections.nCopies(centreNodes + 1, false));
//    for (i in centreFrom.indices) {
//        val from = centreFrom[i]
//        val to = centreTo[i]
//        graph[from].add(to)
//        graph[to].add(from)
//    }
//
//    val dest = mutableListOf<Int>()
//    for (i in 0 until centreNodes) {
//        if (status[i] == 1) {
//            dest.add(i + 1)
//        }
//    }
//
//    val start = mutableListOf<Int>()
//    for (i in 0 until centreNodes) {
//        if (status[i] == 3) {
//            start.add(i + 1)
//        }
//    }
//
//    return bfs(start, dest, graph, visited)
//}
//
//fun bfs(start: MutableList<Int>, dest: MutableList<Int>, graph: List<MutableList<Int>>, visited: MutableList<Boolean>): Int {
//    val q: Queue<Pair<Int, Int>> = LinkedList()
//    start.forEach {
//        q.add(it to 0)
//    }
//
//    var cnt = 0
//    while (q.isNotEmpty()) {
//        val (node, dist) = q.poll()
//        if (node in dest) {
//            cnt += 1
//            if (cnt == dest.size) {
//                return dist
//            }
//        }
//        for (next in graph[node]) {
//
//            if (!visited[next]) {
//                visited[next] = true
//                q.add(next to dist + 1)
//            }
//        }
//    }
//
//    return Int.MAX_VALUE
//}
//
///*
//
//bfs 로 풀기
//
// */