package boj

/**
 * 문제 번호: (1208)
 * 문제 이름: (부분수열의 합 2)
 * 소요 시간(분): (x)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val (n, s) = readLine().split(" ").map { it.toInt() }
    val list = readLine().split(" ").map { it.toInt() }
    val list1 = list.subList(0, list.size / 2)
    val list2 = list.subList(list.size / 2, list.size)
    val sumList1 = getCombinationSumList(n, list1).sorted()
    val sumList2 = getCombinationSumList(n, list2).sortedDescending()
    var answer = 0L

    var s1Pointer = 0
    var s2Pointer = 0
    while (s1Pointer < sumList1.size && s2Pointer < sumList2.size) {
        val sum = sumList1[s1Pointer] + sumList2[s2Pointer]
        if (sum < s) {
            s1Pointer += 1
        } else if (sum > s) {
            s2Pointer += 1
        } else {
            var s1Cnt = 1L
            var s2Cnt = 1L
            while (s1Pointer + 1 < sumList1.size && sumList1[s1Pointer] == sumList1[s1Pointer + 1]) {
                s1Pointer += 1
                s1Cnt += 1
            }
            while (s2Pointer + 1 < sumList2.size && sumList2[s2Pointer] == sumList2[s2Pointer + 1]) {
                s2Pointer += 1
                s2Cnt += 1
            }
            s1Pointer += 1
            s2Pointer += 1
            answer += s1Cnt * s2Cnt
        }
    }

    if (s == 0) {
        answer -= 1
    }
    println(answer)

    close()
}

private fun getCombinationSumList(n: Int, list: List<Int>): MutableList<Int> {
    val sumList = mutableListOf<Int>()
    for (i in 0 until n + 1) {
        makeCombination(0, i, sumList, mutableListOf(), list)
    }
    return sumList
}

private fun makeCombination(start: Int, cnt: Int, sumList: MutableList<Int>, temp: MutableList<Int>, list: List<Int>) {
    if (temp.size == cnt) {
        sumList.add(temp.sum())
        return
    }

    for (i in start until list.size) {
        temp.add(list[i])
        makeCombination(i + 1, cnt, sumList, temp, list)
        temp.removeLast()
    }
}