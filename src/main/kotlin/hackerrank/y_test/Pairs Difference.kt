package hackerrank.y_test

/**
 * 문제: 두 쌍의 차가 target value인 조합의 개수를 구해라
 */

import kotlin.math.abs

fun countPairs(projectCosts: Array<Int>, target: Int): Int {
    val comb = mutableListOf<List<Int>>()
    combination(0, target, mutableListOf(), comb, projectCosts)
    return comb.size
}

private fun combination(start: Int, target: Int, temp: MutableList<Int>, comb: MutableList<List<Int>>, arr: Array<Int>) {
    if (temp.size == 2) {
        if (abs(temp[0] - temp[1]) == target) {
            comb.add(temp.toList())
        }
        return
    }

    for (i in start until arr.size) {
        temp.add(arr[i])
        combination(i + 1, target, temp, comb, arr)
        temp.removeLast()
    }
}