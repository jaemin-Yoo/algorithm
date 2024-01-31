package boj.implementation

/**
 * 문제 번호: (25206)
 * 문제 이름: (너의 평점은)
 * 소요 시간(분): (22)
 */

private val grades = listOf("A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0")

fun main() = with(System.`in`.bufferedReader()) {
    val gradeScores = HashMap<String, Double>()
    var s = 4.5
    for (g in grades) {
        gradeScores[g] = s
        s -= 0.5
    }
    gradeScores["F"] = 0.0

    var scoreSum = 0.0
    var result = 0.0
    repeat(20) {
        val (name, score, grade) = readLine().split(" ")
        if (grade == "P") return@repeat

        scoreSum += score.toDouble()
        result += score.toDouble() * gradeScores[grade]!!
    }
    println(String.format("%.6f", result / scoreSum))
    close()
}