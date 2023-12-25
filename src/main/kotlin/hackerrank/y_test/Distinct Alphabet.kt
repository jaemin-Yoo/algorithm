package hackerrank.y_test

/**
 * 문제: 문자열이 들어왔을 때 중복되지 않는 알파벳 중 가장 작은 인덱스는? “aazz” → -1 “lowercase” → 0 “implementation” → 2
 * 제약 사항: 문자열의 길이는 0 < n <= 1,000,000
 */

fun main() {
    println(getMinIndex("aazz"))
    println(getMinIndex("lowercase"))
    println(getMinIndex("implementation"))
}

private fun getMinIndex(s: String): Int {
    val map = HashMap<Char, Int>()
    s.forEach { c ->
        if (map.containsKey(c)) {
            map[c] = map[c]!! + 1
        } else {
            map[c] = 1
        }
    }

    for (i in s.indices) {
        val c = s[i]
        if (map[c]!! == 1) {
            return i
        }
    }

    return -1
}