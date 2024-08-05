package boj.data_structures

/**
 * 문제 번호: (1)
 * 문제 이름: (배열 안에 배열)
 * 소요 시간(분): (10)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val arr: Array<Any> = arrayOf(1, 2, 3, arrayOf(4, 5), 6, 7, arrayOf(8, arrayOf(9, 10)), 11)
    val result = extendArray(arr)
    println(result.contentToString())
}

private fun extendArray(arr: Array<Any>): IntArray {
    val stack = ArrayDeque<Any>()
    for (i in arr.size - 1 downTo 0) {
        stack.add(arr[i])
    }

    val result = mutableListOf<Int>()
    while (stack.isNotEmpty()) {
        val v = stack.removeLast()
        if (v is Array<*>) {
            for (i in v.size - 1 downTo 0) {
                stack.add(v[i]!!)
            }
        } else {
            result.add(v as Int)
        }
    }
    return result.toIntArray()
}