package boj.Mathematics

fun main() {
    val s = readln()

    print(Integer.toBinaryString(s[0] - '0'))
    for (i in 1 until s.length) {
        print(Integer.toBinaryString(s[i] - '0').padStart(3, '0'))
    }
}