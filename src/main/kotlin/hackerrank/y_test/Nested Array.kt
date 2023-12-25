package hackerrank.y_test

/**
 * 문제: [1, 2, 3, [4, 5], 6, 7, [8, [9, 10]], 11] 와 같은 Input을 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11] 와 같은 배열로 반환
 * 제약 사항: 재귀 깊이 5이상 금지
 */

fun main() {
    val list = listOf(1, 2, 3, listOf(4, 5), 6, 7, listOf(8, listOf(9, 10)), 11)
    val result = flattenList(list)
    println(result.toString())
}

private fun flattenList(list: List<Any>): List<Int> {
    val result = mutableListOf<Int>()
    val stack = ArrayDeque<Any>()
    list.reversed().forEach {
        stack.add(it)
    }

    while (stack.isNotEmpty()) {
        val obj = stack.removeLast()
        if (obj is List<*>) {
            obj.reversed().forEach {
                stack.add(it!!)
            }
        } else {
            result.add(obj as Int)
        }
    }

    return result
}