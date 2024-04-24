package boj.implementation

/**
 * 문제 번호: (1244)
 * 문제 이름: (스위치 켜고 끄기)
 * 소요 시간(분): (27)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val switches = intArrayOf(0) + br.readLine().split(' ').map { it.toInt() }.toIntArray()
    val m = br.readLine().toInt()
    repeat(m) {
        val (sex, num) = br.readLine().split(' ').map { it.toInt() }
        if (sex == 1) {
            man(switches, num, n)
        } else {
            woman(switches, num, n)
        }
    }
    printSwitches(switches, n)
}

private fun man(switches: IntArray, num: Int, n: Int) {
    for (i in num until n + 1 step num) {
        clickSwitch(switches, i)
    }
}

private fun woman(switches: IntArray, num: Int, n: Int) {
    clickSwitch(switches, num)

    var cnt = 1
    while ((num - cnt) in 1 until n + 1 && (num + cnt) in 1 until n + 1 && switches[num - cnt] == switches[num + cnt]) {
        clickSwitch(switches, num - cnt)
        clickSwitch(switches, num + cnt)
        cnt++
    }
}

private fun printSwitches(switches: IntArray, n: Int) {
    val sb = StringBuilder()
    for (i in 1 until n + 1) {
        sb.append("${switches[i]}")
        if (i % 20 == 0) {
            sb.appendLine()
        } else {
            sb.append(" ")
        }
    }
    sb.deleteAt(sb.lastIndex)
    println(sb)
}

private fun clickSwitch(switches: IntArray, num: Int) {
    switches[num] = if (switches[num] == 1) {
        0
    } else {
        1
    }
}