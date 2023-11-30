package boj.Data_Structures

fun main() {
    readln()
    val a = readln().split(" ").map { it.toInt() }
    val b = readln().split(" ").map { it.toInt() }
    val map = HashMap<Int, Int>()
    a.map {
        map[it] = 1
    }
    b.map {
        if (map.containsKey(it)) {
            map[it] = map[it]!!.plus(1)
        } else {
            map[it] = 1
        }
    }

    val result = map.count { it.value == 1 }
    println(result)
}