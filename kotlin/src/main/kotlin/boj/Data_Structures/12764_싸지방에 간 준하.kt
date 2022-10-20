package boj.Data_Structures

import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    val map = HashMap<Pair<Int, String>, Int>()
    val list = mutableListOf<Pair<Int, String>>()
    val enterList = mutableListOf<Int>()
    repeat(n) {
        val (enter, exit) = readln().split(" ").map { it.toInt() }
        map[enter to "in"] = -1
        map[exit to "out"] = enter
        list.add(enter to "in")
        list.add(exit to "out")
        enterList.add(enter)
    }
    list.sortBy { it.first }

    val seat = PriorityQueue<Int>()
    seat.addAll(1..list.size)
    list.forEach { e ->
        if (map[e] == -1) {
            val m = seat.poll()
            map[e] = m
        } else {
            val i = map[e]
            seat.add(map[i to "in"])
        }
    }
    enterList.sort()

    val size = map.filter { it.key.second == "in" }.maxOf { it.value }
    val arr = Array(size) { 0 }
    enterList.forEach {
        val i = map[it to "in"]!!
        arr[i - 1] += 1
    }

    println(size)
    println(arr.joinToString(" "))
}