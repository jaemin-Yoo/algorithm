package boj.String

fun main() {
    val n = readLine()!!.toInt()
    val arr = arrayListOf<Char>()
    repeat(n) {
        arr.add(readLine()!![0])
    }

    var state = false
    for (i in arr.distinct().sorted()) {
        val cnt = arr.count { it == i }
        if (cnt >= 5) {
            print(i)
            state = true
        }
    }

    if (!state) println("PREDAJA")
}