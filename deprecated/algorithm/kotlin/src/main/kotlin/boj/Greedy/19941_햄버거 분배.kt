package boj.Greedy

fun main() {
    val (n, k) = readln().split(" ").map{ it.toInt() }
    val table = readln()
    val visited = table.map { it == 'P' }.toMutableList()

    var result = 0
    for (i in table.indices) {
        if (table[i] == 'P') {
            if (findLeft(i, k, visited)) {
                result += 1
            } else {
                if (findRight(i, k, visited)) {
                    result += 1
                }
            }
        }
    }
    println(result)
}

fun findLeft(i: Int, k: Int, visited: MutableList<Boolean>): Boolean {
    var cnt = k
    while (cnt >= 1) {
        if (i - cnt >= 0 && !visited[i - cnt]) {
            visited[i - cnt] = true
            return true
        }
        cnt -= 1
    }
    return false
}

fun findRight(i: Int, k: Int, visited: MutableList<Boolean>): Boolean {
    var cnt = 1
    while (cnt <= k) {
        if (i + cnt < visited.size && !visited[i + cnt]) {
            visited[i + cnt] = true
            return true
        }
        cnt += 1
    }
    return false
}