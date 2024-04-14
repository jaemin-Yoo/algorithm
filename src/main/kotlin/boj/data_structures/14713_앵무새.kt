package boj.data_structures

/**
 * 문제 번호: (14713)
 * 문제 이름: (앵무새)
 * 소요 시간(분): (x)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val nextMap = HashMap<String, String>()
    val wordMap = HashMap<String, Boolean>()
    repeat(n) {
        val s = br.readLine().split(' ')
        s.forEach { word ->
            wordMap[word] = false
        }
        wordMap[s[0]] = true

        for (i in 0 until s.lastIndex) {
            nextMap[s[i]] = s[i + 1]
        }
    }
    val l = br.readLine().split(' ')

    if (isPossible(l, nextMap, wordMap)) {
        println("Possible")
    } else {
        println("Impossible")
    }
}

private fun isPossible(l: List<String>, nextMap: HashMap<String, String>, wordMap: HashMap<String, Boolean>): Boolean {
    if (l.size != wordMap.size) return false

    l.forEach { word ->
        if (wordMap[word] ?: return false) {
            val nextWord = nextMap[word] ?: return@forEach
            wordMap[nextWord] = true
        } else {
            return false
        }
    }
    return true
}