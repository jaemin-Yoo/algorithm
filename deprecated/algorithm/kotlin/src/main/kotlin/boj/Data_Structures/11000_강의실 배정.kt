package boj.Data_Structures.강의실_배정11000

import kotlin.math.max

const val IN = 0
const val OUT = 1
fun main() {
    val n = readln().toInt()
    val list = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val (s, t) = readln().split(" ").map { it.toInt() }
        list.add(s to IN)
        list.add(t to OUT)
    }
    list.sortWith(compareBy<Pair<Int, Int>> { it.first }.thenByDescending { it.second })

    var seat = 0
    var result = 0
    list.forEach { (_, s) ->
        if (s == IN) {
            seat += 1
        } else {
            seat -= 1
        }

        result = max(result, seat)
    }

    println(result)
}