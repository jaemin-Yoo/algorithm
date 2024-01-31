package boj.string

/**
 * 문제 번호: (9935)
 * 문제 이름: (문자열 폭발)
 * 소요 시간(분): (23)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val s = readLine()
    val boom = readLine()
    val stack = ArrayDeque<Char>()
    for (c in s.reversed()) {
        stack.add(c)

        if (c == boom.first() && stack.size >= boom.length) {
            val tempStack = ArrayDeque<Char>()
            for (element in boom) {
                if (element == stack.last()) {
                    tempStack.add(stack.removeLast())
                } else {
                    while (tempStack.isNotEmpty()) {
                        stack.add(tempStack.removeLast())
                    }
                    break
                }
            }
        }
    }
    val result = StringBuilder()
    while (stack.isNotEmpty()) {
        result.append(stack.removeLast())
    }
    if (result.isEmpty()) {
        result.append("FRULA")
    }
    println(result.toString())
    close()
}