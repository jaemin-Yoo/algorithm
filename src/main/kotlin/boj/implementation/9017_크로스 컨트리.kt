package boj.implementation

/**
 * 문제 번호: (9017)
 * 문제 이름: (크로스 컨트리)
 * 소요 시간(분): (x)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val t = br.readLine().toInt()
    repeat(t) {
        val n = br.readLine().toInt()
        val teams = br.readLine().split(' ').map { it.toInt() }.toIntArray()
        val countMap = getTeamsCountMap(teams)

        var score = 1
        val scoreMap = HashMap<Int, Int>()
        val countMap2 = HashMap<Int, Int>()
        val fiveScoreMap = HashMap<Int, Int>()
        for (team in teams) {
            if (countMap[team] == 6) {
                if (countMap2.containsKey(team)) {
                    countMap2[team] = countMap2[team]!! + 1
                    if (countMap2[team] == 5) {
                        fiveScoreMap[team] = score
                    }
                } else {
                    countMap2[team] = 1
                }

                if (scoreMap.containsKey(team)) {
                    if (countMap2[team]!! <= 4) {
                        scoreMap[team] = scoreMap[team]!! + score
                    }
                } else {
                    scoreMap[team] = score
                }
                score++
            }
        }

        var minScore = Int.MAX_VALUE
        var winTeam = -1
        for ((k, v) in scoreMap) {
            if (v < minScore || (v == minScore && fiveScoreMap[k]!! < fiveScoreMap[winTeam]!!)) {
                minScore = v
                winTeam = k
            }
        }
        println(winTeam)
    }
}

private fun getTeamsCountMap(teams: IntArray): HashMap<Int, Int> {
    val map = HashMap<Int, Int>()
    for (team in teams) {
        if (map.containsKey(team)) {
            map[team] = map[team]!! + 1
        } else {
            map[team] = 1
        }
    }
    return map
}