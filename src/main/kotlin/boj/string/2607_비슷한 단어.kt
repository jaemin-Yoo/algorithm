package boj.string

/**
 * 문제 번호: (2607)
 * 문제 이름: (비슷한 단어)
 * 소요 시간(분): (x)
 */

import kotlin.math.abs

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val word = br.readLine()
    var cnt = 0
    repeat(n - 1) {
        val s = br.readLine()
        val map = getCountMap(word)
        if (abs(word.length - s.length) <= 1 && areSimilar(map, s)) cnt++
    }
    println(cnt)
}

private fun getCountMap(word: String): HashMap<Char, Int> {
    val map = HashMap<Char, Int>()
    word.forEach { c ->
        if (map.containsKey(c)) {
            map[c] = map[c]!! + 1
        } else {
            map[c] = 1
        }
    }
    return map
}

private fun areSimilar(countMap: HashMap<Char, Int>, s: String): Boolean {
    var diffCount = 0
    s.forEach { c ->
        if (countMap.containsKey(c)) {
            countMap[c] = countMap[c]!! - 1
        } else {
            diffCount++
        }
    }

    if (diffCount > 1) return false

    var oneCnt = 0
    var minusOneCnt = 0
    countMap.forEach { (_, v) ->
        if (abs(v) > 1) {
            return false
        } else if (v == 1) {
            oneCnt++
        } else if (v == -1) {
            minusOneCnt++
        }
    }

    return (oneCnt <= 1 && minusOneCnt == 0) || (diffCount == 0 && oneCnt <= 1 && minusOneCnt <= 1)
}