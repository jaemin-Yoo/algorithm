package boj.Combinatorics

var n = 0
val result = mutableListOf<String>()
lateinit var a: MutableList<Int>
fun main() {
    while (true) {
        a = readln().split(' ').map { it.toInt() }.toMutableList()
        n = a[0]
        a.removeFirst()
        combine(mutableListOf())

        result.forEach {
            println(it)
        }
    }
}

fun combine(arr: MutableList<Int>) {
    if (n == arr.size) {
        val s = arr.joinToString(" ")
        if (!result.contains(s)) {
            result.add(s)
        }

        return
    }

    for (i in a) {
        if (i !in arr) {
            arr.add(i)
            combine(arr)
            arr.removeLast()
        }
    }
}