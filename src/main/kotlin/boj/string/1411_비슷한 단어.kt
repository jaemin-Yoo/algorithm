package boj.string

/**
 * 문제 번호: (1411)
 * 문제 이름: (비슷한 단어)
 * 소요 시간(분): (15)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val words = mutableListOf<String>()
    repeat(n) {
        val word = br.readLine()
        words.add(word)
    }

    var cnt = 0
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            if (areSimilarTwoWords(words[i], words[j])) {
                cnt++
            }
        }
    }
    println(cnt)
}

private fun areSimilarTwoWords(word1: String, word2: String): Boolean {
    val n = word1.length
    val map = HashMap<Char, Char>()
    val usedAlphabet = HashMap<Char, Boolean>()
    for (i in 0 until n) {
        val a = word1[i]
        val b = word2[i]
        if (map.containsKey(a)) {
            if (map[a]!! != b) { return false }
        } else {
            if (usedAlphabet.containsKey(b)) { return false }

            map[a] = b
            usedAlphabet[b] = true
        }
    }

    return true
}