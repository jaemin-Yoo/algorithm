package boj.String.비밀번호발음하기4659

private val vowel = listOf('a', 'e', 'i', 'o', 'u')

fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        val input = readLine()
        if (input == "end") {
            break
        }

        if (hasVowel(input) && isSequenceChar(input) && isSameChar(input)) {
            println("<${input}> is acceptable.")
        } else {
            println("<${input}> is not acceptable.")
        }
    }

    close()
}

fun hasVowel(input: String): Boolean {
    input.forEach { c ->
        if (vowel.contains(c)) {
            return true
        }
    }

    return false
}

fun isSequenceChar(input: String): Boolean {
    var vowelCount = 0
    var consonantCount = 0
    input.forEach { c ->
        if (vowel.contains(c)) {
            vowelCount += 1
            consonantCount = 0
        } else {
            consonantCount += 1
            vowelCount = 0
        }

        if (vowelCount >= 3 || consonantCount >= 3) {
            return false
        }
    }

    return true
}

fun isSameChar(input: String): Boolean {
    var prev = input[0]
    for (i in 1 until input.length) {
        if (prev == input[i] && prev != 'e' && prev != 'o') {
            return false
        }

        prev = input[i]
    }

    return true
}