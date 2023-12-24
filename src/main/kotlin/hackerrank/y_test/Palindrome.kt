package hackerrank.y_test

/**
 * 문제: 기존 문자열에서 단 하나의 문자열을 낮은 알파벳 중 하나로 변경하였을 때 팰린드롬이 아닌 가장 낮은 알파벳순 문자열 구하기
 */

private const val SMALL_A_CODE = 97

fun breakPalindrome(palindromeStr: String): String {
    for (i in palindromeStr.indices) {
        val s = StringBuilder(palindromeStr)
        val c = palindromeStr[i]
        if (c.code == SMALL_A_CODE) continue
        for (code in SMALL_A_CODE until c.code) {
            s[i] = code.toChar()
            val str = s.toString()
            if (!isPalindrome(str)) {
                return str
            }
        }
    }

    return "IMPOSSIBLE"
}

private fun isPalindrome(s: String): Boolean {
    val size = s.length
    for (i in 0 until size / 2) {
        if (s[i] != s[size - i - 1]) {
            return false
        }
    }

    return true
}