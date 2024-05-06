package boj.brute_forcing

/**
 * 문제 번호: (2961)
 * 문제 이름: (도영이가 만든 맛있는 음식)
 * 소요 시간(분): (16)
 */

import kotlin.math.abs
import kotlin.math.min

private var result = Int.MAX_VALUE

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val ingredients = mutableListOf<Pair<Int, Int>>()
    val visited = BooleanArray(n)
    repeat(n) {
        val (a, b) = br.readLine().split(' ').map { it.toInt() }
        ingredients.add(a to b)
    }

    for (i in 0 until n) {
        visited[i] = true
        dfs(ingredients, visited, n, ingredients[i].first, ingredients[i].second)
    }

    println(result)
}

private fun dfs(ingredients: MutableList<Pair<Int, Int>>, visited: BooleanArray, n: Int, sour: Int, bitter: Int) {
    result = min(result, abs(sour - bitter))

    for (i in 0 until n) {
        if (!visited[i]) {
            visited[i] = true
            dfs(ingredients, visited, n, sour * ingredients[i].first, bitter + ingredients[i].second)
            visited[i] = false
        }
    }
}