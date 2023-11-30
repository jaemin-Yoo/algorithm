package boj.String

fun main() = with(System.`in`.bufferedReader()) {
    val a = readLine()
    val b = readLine()

    val arr = mutableListOf<String>()
    for (i in a.indices) {
        if (a[i] == ' ') {
            arr.add(" ")
            continue
        }

        var code = a[i].code - (b[i % b.length].code - 96)
        while (code <= 96) {
            code += 26
        }
        val c = (code - 96) % 27 + 96
        arr.add(c.toChar().toString())
    }

    println(arr.joinToString(""))

    close()
}