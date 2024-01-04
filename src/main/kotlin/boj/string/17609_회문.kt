package boj.string

/**
 * 문제 번호: (17609)
 * 문제 이름: (회문)
 * 소요 시간(분): (22)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    repeat(t) {
        val s = readLine()
        val result = when (getStringState(s)) {
            StringState.PALINDROME -> 0
            StringState.PSEUDO_PALINDROME -> 1
            StringState.NOTHING -> 2
        }
        println(result)
    }
    close()
}

private fun getStringState(s: String): StringState {
    val n = s.length
    for (i in 0 until n / 2) {
        if (s[i] != s[n - i - 1]) {
            val a = isPalindrome(s.substring(i + 1 until n - i))
            val b = isPalindrome(s.substring(i until n - i - 1))
            return if (a || b) {
                StringState.PSEUDO_PALINDROME
            } else {
                StringState.NOTHING
            }
        }
    }
    return StringState.PALINDROME
}

private fun isPalindrome(s: String): Boolean {
    val n = s.length
    for (i in 0 until n / 2) {
        if (s[i] != s[n - i - 1]) {
            return false
        }
    }
    return true
}

enum class StringState {
    PALINDROME, PSEUDO_PALINDROME, NOTHING
}