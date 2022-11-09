package boj.String

fun main() {
    val s = readln()
    val arr = arrayOf(1, 0, 0)
    s.forEach {
        when (it) {
            'A' -> changeElement(arr, 0, 1)
            'B' -> changeElement(arr, 1, 2)
            'C' -> changeElement(arr, 0, 2)
        }
    }
    println(arr.indexOf(1) + 1)
}

fun changeElement(arr: Array<Int>, a: Int, b: Int) {
    val temp = arr[a]
    arr[a] = arr[b]
    arr[b] = temp
}