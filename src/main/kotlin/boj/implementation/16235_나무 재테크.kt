package boj.implementation

/**
 * 문제 번호: (16235)
 * 문제 이름: (나무 재테크)
 * 소요 시간(분): (x)
 */

private data class Part(var nutrients: Int, val treeAges: ArrayDeque<Tree>)

private data class Tree(var age: Int, var isAlive: Boolean)

private val dx = listOf(1, 1, 1, 0, 0, -1, -1, -1)
private val dy = listOf(-1, 0, 1, -1, 1, -1, 0, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m, k) = readLine().split(" ").map { it.toInt() }
    val land = Array(n) { Array(n) { Part(5, ArrayDeque()) } }
    val arr = mutableListOf<List<Int>>()
    repeat(n) {
        val row = readLine().split(" ").map { it.toInt() }
        arr.add(row)
    }
    repeat(m) {
        val (x, y, age) = readLine().split(" ").map { it.toInt() }
        land[x - 1][y - 1].treeAges.add(Tree(age, true))
    }

    repeat(k) {

        // 봄
        for (i in 0 until n) {
            for (j in 0 until n) {
                val treeAges = land[i][j].treeAges
                for (idx in treeAges.indices) {
                    if (treeAges[idx].age <= land[i][j].nutrients) {
                        land[i][j].nutrients -= treeAges[idx].age
                        treeAges[idx].age++
                    } else {
                        treeAges[idx].isAlive = false
                    }
                }
            }
        }

        // 여름
        for (i in 0 until n) {
            for (j in 0 until n) {
                val treeAges = land[i][j].treeAges
                while (treeAges.isNotEmpty() && !treeAges.last().isAlive) {
                    val (age, _) = treeAges.removeLast()
                    land[i][j].nutrients += age / 2
                }
            }
        }

        // 가을
        for (i in 0 until n) {
            for (j in 0 until n) {
                val treeAges = land[i][j].treeAges
                treeAges.forEach { (age, _) ->
                    if (age % 5 == 0) {
                        for (l in 0 until 8) {
                            val a = i + dx[l]
                            val b = j + dy[l]
                            if (a in 0 until n && b in 0 until n) {
                                land[a][b].treeAges.addFirst(Tree(1, true))
                            }
                        }
                    }
                }
            }
        }

        // 겨울
        for (i in 0 until n) {
            for (j in 0 until n) {
                land[i][j].nutrients += arr[i][j]
            }
        }
    }

    var result = 0
    for (i in 0 until n) {
        for (j in 0 until n) {
            result += land[i][j].treeAges.size
        }
    }
    println(result)
    close()
}