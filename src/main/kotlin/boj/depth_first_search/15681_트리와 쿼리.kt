package boj.depth_first_search

/**
 * 문제 번호: (15681)
 * 문제 이름: (트리와 쿼리)
 * 소요 시간(분): (27)
 */

import java.util.Queue
import java.util.LinkedList

fun main() = with(System.`in`.bufferedReader()) {
    val (n, r, q) = readLine().split(" ").map { it.toInt() }
    val tree = Array(n + 1) { mutableListOf<Int>() }
    repeat(n - 1) {
        val (u, v) = readLine().split(" ").map { it.toInt() }
        tree[u].add(v)
        tree[v].add(u)
    }
    val children = getChildren(tree, r, n)
    val countSubTree = IntArray(n + 1)
    getCountSubTree(children, countSubTree, r)
    repeat(q) {
        val u = readLine().toInt()
        val cnt = countSubTree[u]
        println(cnt)
    }
    close()
}

private fun getChildren(tree: Array<MutableList<Int>>, rootNode: Int, n: Int): Array<MutableList<Int>> {
    val q: Queue<Int> = LinkedList()
    val visited = BooleanArray(n + 1)
    q.add(rootNode)
    visited[rootNode] = true
    val children = Array(n + 1) { mutableListOf<Int>() }
    while (q.isNotEmpty()) {
        val x = q.poll()
        tree[x].forEach {
            if (!visited[it]) {
                visited[it] = true
                q.add(it)
                children[x].add(it)
            }
        }
    }
    return children
}

private fun getCountSubTree(children: Array<MutableList<Int>>, countSubTree: IntArray, node: Int): Int {
    var cnt = 1
    children[node].forEach {
        cnt += getCountSubTree(children, countSubTree, it)
    }
    countSubTree[node] = cnt
    return cnt
}