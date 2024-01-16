package boj

import java.io.File

private const val NOTE_FILE_NAME = "Note.kt"
private const val TEST_FILE_NAME = "Test.kt"
private const val UNSOLVED_PROBLEM_FILE_NAME = "UnsolvedProblem.txt"
private const val TEST_FILE_PATH = "$BOJ_PATH/$TEST_FILE_NAME"
private const val UNSOLVED_PROBLEM_FILE_PATH = "$RESOURCES_PATH/$UNSOLVED_PROBLEM_FILE_NAME"

fun main() {
    complete()
}

private fun complete() {
    val algorithmName = File(SOLVING_ALGORITHM_FILE_PATH).readLines().lastOrNull()
    if (!Algorithm.values().any { it.name == algorithmName }) {
        throw Exception("존재하지 않는 알고리즘입니다.")
    }

    val notePath = "$BOJ_PATH/$NOTE_FILE_NAME"
    val noteContents = File(notePath).readText()
    val (number, title, time) = extractDetails(noteContents)
    println(time)

    addProblemFile(noteContents, algorithmName, number, title)
    if (time != "x") {
        addSolvedAlgorithm(algorithmName)
    } else {
        addUnsolvedProblem(number)
    }
    removeSolvingAlgorithm()
    resetTestFile()
    addNoteFile()
    println("[${algorithmName ?: "etc"}] ${number}_$title.kt")
}

private fun addProblemFile(contents: String, algorithmName: String?, number: String, title: String) {
    val lowerAlgorithmName = algorithmName?.lowercase() ?: "etc"
    val newContents = contents.replace("package boj", "package boj.$lowerAlgorithmName")
    val path = "$BOJ_PATH/$lowerAlgorithmName/${number}_$title.kt"
    val dirPath = "$BOJ_PATH/$lowerAlgorithmName"
    val directory = File(dirPath)
    if (!directory.exists()) {
        directory.mkdir()
    }

    File(path).appendText(newContents)
}

private fun extractDetails(text: String): Triple<String, String, String> {
    val regex = Regex("\\[(.*?)]")
    val details = regex.findAll(text).map { it.groupValues[1] }.toList()
    return Triple(details[0], details[1].replace("[^ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z,.?\\d\\s]".toRegex(), ""), details[2])
}

private fun addSolvedAlgorithm(algorithmName: String?) {
    algorithmName ?: return
    val solvedFile = File(SOLVED_ALGORITHM_FILE_PATH)
    if (!solvedFile.exists()) {
        solvedFile.createNewFile()
    }

    val solvedAlgorithms = solvedFile.readLines()
    if (algorithmName !in solvedAlgorithms) {
        File(SOLVED_ALGORITHM_FILE_PATH).appendText("${algorithmName}\n")
    }
}

private fun addUnsolvedProblem(number: String) {
    val unsolvedFile = File(UNSOLVED_PROBLEM_FILE_PATH)
    if (unsolvedFile.readText() == "") {
        unsolvedFile.appendText(number)
    } else {
        unsolvedFile.appendText(",$number")
    }
}

private fun removeSolvingAlgorithm() {
    File(SOLVING_ALGORITHM_FILE_PATH).writeText("")
}

private fun resetTestFile() {
    val contents = """package boj

fun main() = with(System.`in`.bufferedReader()) {
    
    close()
}"""
    File(TEST_FILE_PATH).writeText(contents)
}