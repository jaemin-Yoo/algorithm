package boj.Combinatorics

class 로또6603 {
    var n = 0
    lateinit var a: MutableList<Int>
    fun main() {
        while (true) {
            a = readln().split(' ').map { it.toInt() }.toMutableList()
            if (a[0] == 0) break
            n = a[0]
            a.removeFirst()
            combine(mutableListOf(), 0)
            println()
        }
    }

    fun combine(arr: MutableList<Int>, start: Int) {
        if (arr.size == 6) {
            val s = arr.joinToString(" ")
            println(s)
            return
        }

        for (i in start until a.size) {
            arr.add(a[i])
            combine(arr, i + 1)
            arr.removeLast()
        }
    }
}