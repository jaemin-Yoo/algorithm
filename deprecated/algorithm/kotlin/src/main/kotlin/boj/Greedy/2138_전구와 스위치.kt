package boj.Greedy

import java.lang.Integer.min

fun main() {
    val n = readln().toInt()
    val prevSwitches = readln().map { it.toString().toInt() }.toMutableList()
    val newSwitches = readln().map { it.toString().toInt() }.toList()

    val cnt1 = findResult(n, prevSwitches.toMutableList(), newSwitches)
    clickSwitch(prevSwitches, 0)
    val cnt2 = findResult(n, prevSwitches.toMutableList(), newSwitches) + 1

    val result = min(cnt1, cnt2)
    if (result > n) {
        println(-1)
    } else {
        println(result)
    }
}

fun findResult(n: Int, prevSwitches: MutableList<Int>, newSwitches: List<Int>): Int {
    var cnt = 0
    for (i in 1 until n) {
        if (prevSwitches[i - 1] != newSwitches[i - 1]) {
            clickSwitch(prevSwitches, i)
            cnt += 1
        }
    }

    return if (prevSwitches == newSwitches) {
        cnt
    } else {
        n + 1
    }
}

fun clickSwitch(switches: MutableList<Int>, idx: Int) {
    if (idx - 1 >= 0) {
        switches[idx - 1] = switches[idx - 1] xor 1
    }

    switches[idx] = switches[idx] xor 1

    if (switches.size > idx + 1) {
        switches[idx + 1] = switches[idx + 1] xor 1
    }
}