package boj

import java.awt.Desktop
import java.io.File
import java.net.URI

const val SOLVED_ALGORITHM_FILE_NAME = "SolvedAlgorithm.txt"
const val BOJ_PATH = "src/main/kotlin/boj"
const val DB_FILE_PATH = "src/main/resources/$SOLVED_ALGORITHM_FILE_NAME"

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
        addSolvedAlgorithm(selectedAlgorithm)
        addNoteFile()
    }
}

private fun getSolvedAlgorithms(): List<String> {
    val file = File(DB_FILE_PATH)
    if (!file.exists()) {
        return emptyList()
    }
    return file.readLines()
}

private fun addSolvedAlgorithm(algorithm: Algorithm) {
    File(DB_FILE_PATH).appendText("${algorithm.name}\n")
}

private fun openWebSite(algorithm: Algorithm) {
    Desktop.getDesktop().browse(URI(algorithm.url))
}

private fun reset() {
    File(DB_FILE_PATH).writeText("")
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

private fun getBOJUrl(number: Int, page: Int = 1) =
    "https://www.acmicpc.net/problemset?sort=ac_desc&algo=$number&algo_if=and&page=$page"

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