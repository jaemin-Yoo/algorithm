package boj.Mathematics

fun main() {
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    val list = mutableListOf<Int>()
    list.add(a)
    list.add(b)
    list.add(c)
    list.add(a * b)
    list.add(b * c)
    list.add(a * c)
    list.add(a * b * c)
    val oddList = list.filter { it % 2 == 1 }
    if (oddList.isNotEmpty()) {
        println(oddList.maxOf { it })
    } else {
        println(list.maxOf { it })
    }
}