package boj.Backtracking.부분수열의합1182

private var result = 0

fun main() {
    val (n, s) = readln().split(' ').map { it.toInt() }
    val seq = readln().split(" ").map { it.toInt() }

    for (i in 1..n) {
        isSequenceSumEqualToExpected(0, i, s, seq, mutableListOf())
    }

    print(result)
}

fun isSequenceSumEqualToExpected(start: Int, n: Int, s: Int, seq: List<Int>, list: MutableList<Int>) {
    if (list.size == n) {
        result += if (list.sum() == s) {
            1
        } else {
            0
        }
        return
    }

    for (i in start until seq.size) {
        list.add(seq[i])
        isSequenceSumEqualToExpected(i + 1, n, s, seq, list)
        list.removeLast()
    }
}