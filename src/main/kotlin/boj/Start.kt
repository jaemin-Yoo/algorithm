package boj

import java.awt.Desktop
import java.io.File
import java.net.URI

const val SOLVED_ALGORITHM_FILE_NAME = "SolvedAlgorithm.txt"
const val SOLVING_ALGORITHM_FILE_NAME = "SolvingAlgorithm.txt"
const val BOJ_PATH = "src/main/kotlin/boj"
const val ALGORITHM_DIR_PATH = "src/main/resources"
const val SOLVED_ALGORITHM_FILE_PATH = "$ALGORITHM_DIR_PATH/$SOLVED_ALGORITHM_FILE_NAME"
const val SOLVING_ALGORITHM_FILE_PATH = "$ALGORITHM_DIR_PATH/$SOLVING_ALGORITHM_FILE_NAME"

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
    val directory = File(ALGORITHM_DIR_PATH)
    if (!directory.exists()) {
        directory.mkdir()
    }

    File(SOLVING_ALGORITHM_FILE_PATH).appendText("${algorithm.name}\n")
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

fun main() = with(System.`in`.bufferedReader()) {

    close()
}"""
    File(path).writeText(contents)
}

private const val GOLD_TIER = "11%2C12%2C13%2C14%2C15"

private fun getBOJUrl(number: Int, page: Int = 1) =
    "https://www.acmicpc.net/problemset?sort=ac_desc&submit=us&tier=$GOLD_TIER&algo=$number&algo_if=and&page=$page"

enum class Algorithm(val url: String) {
    BRUTE_FORCING(getBOJUrl(125, 2)),
    DEPTH_FIRST_SEARCH(getBOJUrl(127)),
    BREADTH_FIRST_SEARCH(getBOJUrl(126)),
    HASHING(getBOJUrl(136)),
    STRING(getBOJUrl(158)),
    DYNAMIC_PROGRAMMING(getBOJUrl(25)),
    DIJKSTRA(getBOJUrl(22)),
    IMPLEMENTATION(getBOJUrl(102, 2)),
    DATA_STRUCTURES(getBOJUrl(175)),
    TWO_POINTER(getBOJUrl(80)),
    GREEDY(getBOJUrl(33)),
    BINARY_SEARCH(getBOJUrl(12)),
    TOPOLOGICAL_SORTING(getBOJUrl(78)),
    UNION_FIND(getBOJUrl(81)),
    PRIORITY_QUEUE(getBOJUrl(59))
}