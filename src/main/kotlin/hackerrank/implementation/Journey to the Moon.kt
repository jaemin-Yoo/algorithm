package hackerrank.implementation

import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

/*
 * Complete the 'journeyToMoon' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. 2D_INTEGER_ARRAY astronaut
 */

fun journeyToMoon(n: Int, astronaut: Array<Array<Int>>): Long {
    val graph = Array(n) { mutableListOf<Int>() }
    val visited = BooleanArray(n)
    for ((a, b) in astronaut) {
        graph[a].add(b)
        graph[b].add(a)
    }

    val comb = mutableListOf<Int>()
    for (i in 0 until n) {
        if (!visited[i]) {
            val cnt = getSetCount(i, visited, graph)
            comb.add(cnt)
        }
    }

    var sum = 0
    var result = 0L
    for (size in comb) {
        result += sum * size
        sum += size
    }

    return result
}

private fun getSetCount(n: Int, visited: BooleanArray, graph: Array<MutableList<Int>>): Int {
    val q: Queue<Int> = LinkedList()
    q.add(n)
    visited[n] = true

    var cnt = 1
    while (q.isNotEmpty()) {
        val x = q.poll()
        graph[x].forEach { a ->
            if (!visited[a]) {
                visited[a] = true
                q.add(a)
                cnt += 1
            }
        }
    }

    return cnt
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val p = first_multiple_input[1].toInt()

    val astronaut = Array<Array<Int>>(p, { Array<Int>(2, { 0 }) })

    for (i in 0 until p) {
        astronaut[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = journeyToMoon(n, astronaut)

    println(result)
}
