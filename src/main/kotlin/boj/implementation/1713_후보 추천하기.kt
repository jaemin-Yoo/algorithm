package boj.implementation

/**
 * 문제 번호: (1713)
 * 문제 이름: (후보 추천하기)
 * 소요 시간(분): (x)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val total = readLine().toInt()
    val arr = readLine().split(" ").map { it.toInt() }
    val numbers = HashMap<Int, Pair<Int, Int>>()
    val s = mutableSetOf<Int>()
    for (i in 0 until total) {
        val num = arr[i]
        if (numbers.containsKey(num)) {
            val (order, cnt) = numbers[num]!!
            numbers[num] = order to cnt + 1
        } else {
            if (numbers.size == n) {
                val minCnt = numbers.minOf { it.value.second }
                val minOrder = numbers.filter{ it.value.second == minCnt }.minOf { it.value.first }
                for ((k, v) in numbers) {
                    if (v.first == minOrder && v.second == minCnt) {
                        numbers.remove(k)
                        break
                    }
                }
            }
            numbers[num] = i to 1
        }
    }
    val result = mutableListOf<Int>()
    for ((k, _) in numbers) {
        result.add(k)
    }
    result.sort()
    println(result.joinToString(" "))
    close()
}