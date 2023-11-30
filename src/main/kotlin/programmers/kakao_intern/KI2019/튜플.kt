package programmers.KI2019.튜플

// 30분

class Solution {
    fun solution(s: String): IntArray {
        val list = convertToList(s)
        val result = mutableListOf<Int>()

        for (l in list) {
            for (n in l) {
                if (n !in result) {
                    result.add(n)
                }
            }
        }

        return result.toIntArray()
    }

    private fun convertToList(s: String): List<List<Int>> {
        val list = s.trim('{', '}').split("},{").map {
            it.trim('{', '}').split(",").map { c -> c.toInt() }
        }.toMutableList()
        list.sortBy { it.size }

        return list
    }
}