package boj.String

fun main() {
    val n = readLine()!!.toInt()
    val arr = arrayListOf<Pair<String, Int>>()
    repeat(n) {
        val (name, day, month, year) = readLine()!!.split(' ')
        val age = year + String.format("%02d", month.toInt()) + String.format("%02d", day.toInt())
        arr.add(name to age.toInt())
    }
    arr.sortBy { it.second }
    println(arr[arr.lastIndex].first)
    println(arr[0].first)
}