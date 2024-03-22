package boj.implementation

/**
 * 문제 번호: (15787)
 * 문제 이름: (기차가 어둠을 헤치고 은하수를)
 * 소요 시간(분): (19)
 */

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val trains = Array(n) { ArrayDeque<Boolean>() }
    trains.map { train ->
        repeat(20) { train.add(false) }
    }
    repeat(m) {
        val cmd = readLine().split(" ").map { it.toInt() }
        when (cmd[0]) {
            1 -> {
                val (i, x) = cmd[1] to cmd[2]
                trains[i - 1][x - 1] = true
            }
            2 -> {
                val (i, x) = cmd[1] to cmd[2]
                trains[i - 1][x - 1] = false
            }
            3 -> {
                val i = cmd[1]
                trains[i - 1].addFirst(false)
                trains[i - 1].removeLast()
            }
            4 -> {
                val i = cmd[1]
                trains[i - 1].addLast(false)
                trains[i - 1].removeFirst()
            }
        }
    }
    val s = mutableSetOf<Int>()
    trains.forEach {
        val code = it.hashCode()
        s.add(code)
    }
    println(s.size)
    close()
}