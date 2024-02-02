package boj.string

/**
 * 문제 번호: (9996)
 * 문제 이름: (한국이 그리울 땐 서버에 접속하지)
 * 소요 시간(분): (x)
 */

fun main(args: Array<String>) = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val pattern = readLine()
    val (front, back) = pattern.split("*")
    repeat(n) {
        val s = readLine()
        if (front.length + back.length > s.length) {
            println("NE")
            return@repeat
        }

        for (i in 0 until front.length) {
            if (front[i] != s[i]) {
                println("NE")
                return@repeat
            }
        }

        for (i in 0 until back.length) {
            if (back[back.lastIndex - i] != s[s.lastIndex - i]) {
                println("NE")
                return@repeat
            }
        }

        println("DA")
    }

    close()
}