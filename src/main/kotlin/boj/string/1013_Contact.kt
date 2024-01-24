package boj.string

/**
 * 문제 번호: (1013)
 * 문제 이름: (Contact)
 * 소요 시간(분): (x)
 */

enum class State {
    START, ING
}

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    repeat(t) {
        val x = readLine()
        var idx = 0
        var state = State.START
        var result = "YES"
        while (idx <= x.lastIndex) {
            val c = x[idx]
            when (state) {
                State.START -> {
                    if (c == '1') {
                        if (idx + 2 > x.lastIndex || x[idx + 1] == '1' || x[idx + 2] == '1') {
                            result = "NO"
                            break
                        }
                        idx += 3
                        while (idx <= x.lastIndex && x[idx] == '0') {
                            idx++
                        }
                        state = State.ING
                        continue
                    } else {
                        if (idx + 1 > x.lastIndex || x[idx + 1] == '0') {
                            result = "NO"
                            break
                        }
                        idx += 2
                    }
                }
                State.ING -> {
                    if (idx + 1 > x.lastIndex || (idx + 1 <= x.lastIndex && x[idx + 1] == '0')) {
                        state = State.START
                        idx++
                        continue
                    }

                    idx += 1
                    while (idx <= x.lastIndex && x[idx] == '1') {
                        idx++
                    }
                    if (idx > x.lastIndex) {
                        state = State.START
                        break
                    }

                    if (idx + 1 <= x.lastIndex && x[idx + 1] == '0') {
                        state = State.START
                        idx -= 1
                        continue
                    } else if (idx + 1 <= x.lastIndex && x[idx + 1] == '1') {
                        state = State.START
                        continue
                    } else {
                        result = "NO"
                        break
                    }
                }
            }
        }

        if (state != State.START) {
            result = "NO"
        }
        println(result)
    }
    close()
}

/*

a: 100+1+
b: 01

10010111
011000100110001
0110001011001

4
10011001
100101011
1000000
10

7
10010111
011000100110001
0110001011001
10011001
1001111111
01100010110011001
10000110001

 */