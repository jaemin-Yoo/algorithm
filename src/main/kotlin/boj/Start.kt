package boj

import java.awt.Desktop
import java.io.File
import java.net.URI

const val SOLVED_ALGORITHM_FILE_NAME = "SolvedAlgorithm.txt"
const val SOLVING_ALGORITHM_FILE_NAME = "SolvingAlgorithm.txt"
const val BOJ_PATH = "src/main/kotlin/boj"
const val RESOURCES_PATH = "src/main/resources"
const val SOLVED_ALGORITHM_FILE_PATH = "$RESOURCES_PATH/$SOLVED_ALGORITHM_FILE_NAME"
const val SOLVING_ALGORITHM_FILE_PATH = "$RESOURCES_PATH/$SOLVING_ALGORITHM_FILE_NAME"

fun main() {
    start()
}

private fun start() {
    val completedAlgorithms = getSolvedAlgorithms()
    val inCompletedAlgorithms = Algorithm.values().map { it }.filter { it.name !in completedAlgorithms }

    if (inCompletedAlgorithms.isEmpty()) {
        reset()
        start()
    } else {
        val selectedAlgorithm = inCompletedAlgorithms.random()
        openWebSite(selectedAlgorithm)
        addSolvingAlgorithm(selectedAlgorithm)
        addNoteFile()
    }
}

private fun getSolvedAlgorithms(): List<String> {
    val file = File(SOLVED_ALGORITHM_FILE_PATH)
    if (!file.exists()) {
        return emptyList()
    }
    return file.readLines()
}

private fun addSolvingAlgorithm(algorithm: Algorithm) {
    val directory = File(RESOURCES_PATH)
    if (!directory.exists()) {
        directory.mkdir()
    }

    File(SOLVING_ALGORITHM_FILE_PATH).writeText(algorithm.name)
}

private fun openWebSite(algorithm: Algorithm) {
    Desktop.getDesktop().browse(URI(algorithm.url))
}

private fun reset() {
    File(SOLVED_ALGORITHM_FILE_PATH).writeText("")
}

fun addNoteFile() {
    val path = "$BOJ_PATH/Note.kt"
    val contents = """package boj

/**
 * 문제 번호: ()
 * 문제 이름: ()
 * 소요 시간(분): ()
 */

fun main() = System.`in`.bufferedReader().use { br ->
    
}"""
    File(path).writeText(contents)
}

private const val GOLD_TIER = "11%2C12%2C13%2C14%2C15"
private const val SILVER_TIER = "6%2C7%2C8%2C9%2C10"
private const val SILVER_5 = "6"
private const val SILVER_4 = "7"
private const val SILVER_3 = "8"
private const val SILVER_2 = "9"
private const val SILVER_1 = "10"
private const val GOLD_5 = "11"
private const val GOLD_4 = "12"
private const val GOLD_3 = "13"
private const val GOLD_2 = "14"
private const val GOLD_1 = "15"

private fun getBOJUrl(number: Int, tier: String, page: Int = 1) =
    "https://www.acmicpc.net/problemset?sort=ac_desc&submit=us&tier=$tier&algo=$number&algo_if=and&page=$page"

enum class Algorithm(val url: String) {
    BRUTE_FORCING(getBOJUrl(125, SILVER_2)),
    DEPTH_FIRST_SEARCH(getBOJUrl(127, GOLD_5)),
    BREADTH_FIRST_SEARCH(getBOJUrl(126, SILVER_1)),
    HASHING(getBOJUrl(136, SILVER_2)),
    STRING(getBOJUrl(158, SILVER_2)),
    DYNAMIC_PROGRAMMING(getBOJUrl(25, SILVER_2)),
    DIJKSTRA(getBOJUrl(22, GOLD_3)),
    IMPLEMENTATION(getBOJUrl(102, SILVER_2)),
    DATA_STRUCTURES(getBOJUrl(175, SILVER_2)),
    TWO_POINTER(getBOJUrl(80, SILVER_2)),
    GREEDY(getBOJUrl(33, SILVER_1)),
    BINARY_SEARCH(getBOJUrl(12, SILVER_2)),
    TOPOLOGICAL_SORTING(getBOJUrl(78, GOLD_4)),
    UNION_FIND(getBOJUrl(81, GOLD_4)),
    PRIORITY_QUEUE(getBOJUrl(59, GOLD_4))
}

/**
 * 백준 티어 제도 도입 (맞추면 + 틀리면 -)
 *  틀린 문제 다시 풀기 기능 추가
 *  data class 중복 문제 해결 (패키지 정의)
 */