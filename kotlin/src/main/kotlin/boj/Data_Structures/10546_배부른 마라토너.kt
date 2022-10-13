package boj.Depth_first_Search

fun main() {
    val n = readln().toInt()
    val map = HashMap<String, Int>()
    repeat(n) {
        val key = readln()
        map[key] = if (map.containsKey(key)) {
            map[key]!! + 1
        } else {
            1
        }
    }
    repeat(n - 1) {
        val key = readln()
        map[key] = map[key]!! - 1
    }

    for ((k, v) in map) {
        if (v != 0) {
            println(k)
            break
        }
    }
}