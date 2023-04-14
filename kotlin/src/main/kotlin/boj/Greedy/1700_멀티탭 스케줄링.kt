package boj.Greedy.멀티탭스케줄링1700

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val list = readln().split(" ").map { it.toInt() }.toMutableList()
    val tap = MutableList(n) { 0 }
    var result = 0
    for (i in list.indices) {
        val v = list[i]
        if (!tap.contains(v)) {
            // 멀티탭에 안꼽혀있는경우
            val idx = tap.indexOf(0)
            if (idx != -1) {
                // 빈 자리가 있을 때
                tap[idx] = v
                continue
            }

            // 빈 자리가 없을 때
            val indexTap = tap.map { t ->
                val index = list.subList(i, k).indexOf(t)
                if (index == -1) {
                    k
                } else {
                    index + i
                }
            }
            val index = indexTap.indexOf(indexTap.maxOf { it })
            tap[index] = list[i]
            result += 1
        }
    }
    println(result)
}