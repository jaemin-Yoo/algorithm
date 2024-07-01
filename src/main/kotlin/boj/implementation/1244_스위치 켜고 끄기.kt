package boj.implementation

/**
 * 문제 번호: (1244)
 * 문제 이름: (스위치 켜고 끄기)
 * 소요 시간(분): (x)
 */

fun main() = System.`in`.bufferedReader().use { br ->
    val n = br.readLine().toInt()
    val switches = br.readLine().split(' ').map { it.toInt() }.toIntArray()
    val t = br.readLine().toInt()
    repeat(t) {
        val (sex, num) = br.readLine().split(' ').map { it.toInt() }
        if (sex == 1) {
            operateSwitchByMan(switches, num - 1)
        } else {
            operateSwitchByWoman(switches, num - 1)
        }
    }

    val sb = StringBuilder()
    for (i in 1 until n + 1) {
        sb.append(switches[i - 1])
        if (i == n) break

        if (i % 20 == 0) {
            sb.append("\n")
        } else {
            sb.append(" ")
        }
    }
    println(sb)
}

private fun operateSwitchByMan(switches: IntArray, num: Int) {
    for (i in num until switches.size step num + 1) {
        changeSwitchState(switches, i)
    }
}

private fun operateSwitchByWoman(switches: IntArray, num: Int) {
    changeSwitchState(switches, num)

    var i = 1
    while (num - i >= 0 && num + i < switches.size) {
        if (switches[num - i] == switches[num + i]) {
            changeSwitchState(switches, num - i)
            changeSwitchState(switches, num + i)
        } else {
            break
        }
        i++
    }
}

private fun changeSwitchState(switches: IntArray, index: Int) {
    switches[index] = 1 - switches[index]
}