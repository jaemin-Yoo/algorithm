package boj.implementation

/**
 * 문제 번호: (2304)
 * 문제 이름: (창고 다각형)
 * 소요 시간(분): (36)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val arr = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val (l, h) = br.readLine().split(' ').map { it.toInt() }
        arr.add(l to h)
    }
    arr.sortWith(compareBy { it.first })
    val maxHeight = arr.maxOf { it.second }
    val maxHeightFirst = arr.indexOfFirst { it.second == maxHeight }
    val maxHeightLast = arr.indexOfLast { it.second == maxHeight }
    var result = (arr[maxHeightLast].first - arr[maxHeightFirst].first + 1) * maxHeight
    var mx = arr.first().second
    for (i in 1 until maxHeightFirst + 1) {
        val (l, h) = arr[i]
        val (prevL, _) = arr[i - 1]
        result += (l - prevL) * mx

        if (h > mx) {
            mx = h
        }
    }

    mx = arr.last().second
    for (i in arr.lastIndex - 1 downTo maxHeightLast) {
        val (l, h) = arr[i]
        val (prevL, _) = arr[i + 1]
        result += (prevL - l) * mx

        if (h > mx) {
            mx = h
        }
    }
    println(result)
}