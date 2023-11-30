package programmers.카카오채용연계형인턴십2021.숫자문자열과영단어

// 12분

private const val ZERO_CODE = 48
private const val NINE_CODE = 57

class Solution {

    private val number = listOf(
        "zero", "one", "two",
        "three", "four", "five",
        "six", "seven", "eight", "nine"
    )

    fun solution(s: String): Int {
        val map = HashMap<String, Int>()
        for (i in number.indices) {
            map[number[i]] = i
        }

        val answer = StringBuilder()
        val temp = StringBuilder()
        s.forEach { c ->
            if (c.code in ZERO_CODE..NINE_CODE) {
                answer.append(c)
            } else {
                temp.append(c)
            }

            val numStr = temp.toString()
            if (map.containsKey(numStr)) {
                answer.append(map[numStr]!!)
                temp.clear()
            }
        }

        return answer.toString().toInt()
    }
}

