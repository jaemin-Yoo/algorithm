package boj

import java.io.File

private const val NOTE_FILE_NAME = "Note.kt"

fun main() {
    complete()
}

private fun complete() {
    val algorithmName = File(DB_FILE_PATH).readLines().lastOrNull() ?: throw Exception("해결한 문제가 존재하지 않습니다.")
    val solvedAlgorithm = Algorithm.valueOf(algorithmName)

    val notePath = "$BOJ_PATH/$NOTE_FILE_NAME"
    val noteContents = File(notePath).readText()
    val (number, title) = extractDetails(noteContents)

    addProblemFile(noteContents, solvedAlgorithm, number, title)
    addNoteFile()
    println("[$solvedAlgorithm] ${number}_$title.kt")
}

private fun addProblemFile(contents: String, algorithm: Algorithm, number: String, title: String) {
    val algorithmName = algorithm.name.lowercase()
    val path = "$BOJ_PATH/$algorithmName/${number}_$title.kt"
    File(path).appendText(contents)
}

private fun extractDetails(text: String): Pair<String, String> {
    val regex = Regex("\\((.*?)\\)")
    val details = regex.findAll(text).map { it.groupValues[1] }.toList()
    return details[0] to details[1]
}