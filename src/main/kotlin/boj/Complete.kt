package boj

import java.io.File

private const val NOTE_FILE_NAME = "Note.kt"

fun main() {
    complete()
}

private fun complete() {
    val algorithmName = File(SOLVING_ALGORITHM_FILE_PATH).readLines().lastOrNull()

    val notePath = "$BOJ_PATH/$NOTE_FILE_NAME"
    val noteContents = File(notePath).readText()
    val (number, title) = extractDetails(noteContents)

    addProblemFile(noteContents, algorithmName, number, title)
    addNoteFile()
    addSolvedAlgorithm(algorithmName)
    println("[${algorithmName ?: "etc"}] ${number}_$title.kt")
}

private fun addProblemFile(contents: String, algorithmName: String?, number: String, title: String) {
    val lowerAlgorithmName = algorithmName?.lowercase() ?: "etc"
    val path = "$BOJ_PATH/$lowerAlgorithmName/${number}_$title.kt"
    File(path).appendText(contents)
}

private fun extractDetails(text: String): Pair<String, String> {
    val regex = Regex("\\((.*?)\\)")
    val details = regex.findAll(text).map { it.groupValues[1] }.toList()
    return details[0] to details[1]
}

private fun addSolvedAlgorithm(algorithmName: String?) {
    algorithmName ?: return
    File(SOLVED_ALGORITHM_FILE_PATH).appendText("${algorithmName}\n")
    removeSolvingAlgorithm()
}

private fun removeSolvingAlgorithm() {
    File(SOLVING_ALGORITHM_FILE_PATH).writeText("")
}