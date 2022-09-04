package com.jaemin.practicekotlin

import java.util.*

class Test {
    data class Bucket(
        val a: Int,
        val b: Int,
        val c: Int
    )

    val visited = mutableListOf<Bucket>()
    var maxA = 0
    var maxB = 0
    var maxC = 0
    fun main() {
        val (_maxA, _maxB, _maxC) = readln().split(' ').map { it.toInt() }
        maxA = _maxA
        maxB = _maxB
        maxC = _maxC
        BFS(Bucket(0, 0, maxC))
    }

    fun BFS(start: Bucket) {
        val q: Queue<Bucket> = LinkedList()
        q.add(start)
        visited.add(start)
        while (q.isNotEmpty()) {
            val (x, y, z) = q.poll()
            var a = x
            var b = y
            var c = z
            if (x != 0) {
                if (x + y > maxB) {
                    a = x + y - maxB
                    b = maxB
                } else {
                    a = 0
                    b = x + y
                }
                q.add(Bucket(a, b, c))
            }
        }
    }

    fun moveWater(a: Int, b: Int, c: Int, q: Queue<Bucket>) {

    }
}