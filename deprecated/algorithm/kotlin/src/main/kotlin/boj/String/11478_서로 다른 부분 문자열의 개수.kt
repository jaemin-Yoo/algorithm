package boj.String

fun main() {
    val s = readln()
    val arr = ArrayList<String>()

    for (i in s.indices) {
        for (j in 0..s.length - i) {
            val str = s.substring(j, i + j)
            arr.add(str)
        }
    }

    println(arr.toSet().count())
}