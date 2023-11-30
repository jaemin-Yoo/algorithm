package programmers.KI2022.성격유형검사하기

class Solution {

    private val types = listOf(
        'R' to 'T',
        'C' to 'F',
        'J' to 'M',
        'A' to 'N'
    )

    fun solution(survey: Array<String>, choices: IntArray): String {
        val scores = arrayOf(-1 to -1,
            0 to 3, 0 to 2, 0 to 1, 0 to 0,
            1 to 1, 1 to 2, 1 to 3
        )
        val map = HashMap<Char, Int>()
        types.forEach { (a, b) ->
            map[a] = 0
            map[b] = 0
        }

        for (i in survey.indices) {
            val str = survey[i]
            val num = choices[i]

            val (idx, score) = scores[num]
            val type = str[idx]

            map[type] = map[type]!! + score
        }

        val answer = types.map { (a, b) ->
            if (map[a]!! >= map[b]!!) {
                a
            } else {
                b
            }
        }.joinToString("")

        return answer
    }
}