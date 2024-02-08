package boj.string

/**
 * 문제 번호: (2870)
 * 문제 이름: (수학숙제)
 * 소요 시간(분): (x)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val result = mutableListOf<String>()
    repeat(n) {
        val s = readLine()
        val temp = mutableListOf<Int>()
        s.forEach {
            if (it.code !in 97 until 123) {
                temp.add(it.digitToInt())
            } else if (temp.isNotEmpty()) {
                result.add(temp.joinToString("").padStart(100, '0'))
                temp.clear()
            }
        }
        if (temp.isNotEmpty()) {
            result.add(temp.joinToString("").padStart(100, '0'))
            temp.clear()
        }
    }
    result.sort()
    result.forEach {
        val s = it.trimStart('0')
        if (s == "") {
            println(0)
        } else {
            println(s)
        }
    }
    close()
}