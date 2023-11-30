package boj.Breadth_first_Search

import java.util.LinkedList
import java.util.Queue

class 물통2251 {
    val visited = mutableListOf<MutableList<Int>>()
    lateinit var bucketList: MutableList<Int>
    val result = mutableListOf<Int>()
    fun main() {
        bucketList = readln().split(' ').map { it.toInt() }.toMutableList()
        BFS(mutableListOf(0, 0, bucketList[2]))
        result.add(bucketList[2])
        result.sort()
        println(result.joinToString(" "))
    }

    fun BFS(start: MutableList<Int>) {
        val q: Queue<MutableList<Int>> = LinkedList()
        q.add(start)
        visited.add(start)
        while (q.isNotEmpty()) {
            val list = q.poll()
            for (i in 0 until 3) {
                for (j in 0 until 3) {
                    if (i != j && list[i] != 0) {
                        val newBucket = moveWater(list, i, j)
                        if (newBucket !in visited) {
                            q.add(newBucket)
                            visited.add(newBucket)
                            if (newBucket[0] == 0) result.add(newBucket[2])
                        }
                    }
                }
            }
        }
    }

    fun moveWater(list: MutableList<Int>, give: Int, take: Int): MutableList<Int> {
        val newBucket = list.toMutableList()
        if (list[give] + list[take] > bucketList[take]) {
            newBucket[give] = list[give] + list[take] - bucketList[take]
            newBucket[take] = bucketList[take]
        } else {
            newBucket[give] = 0
            newBucket[take] = list[give] + list[take]
        }
        return newBucket
    }
}