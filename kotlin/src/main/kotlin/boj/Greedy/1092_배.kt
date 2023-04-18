package boj.Greedy

fun main() {
    val n = readln().toInt()
    val cranes = readln().split(" ").map { it.toInt() }.sorted()
    val m = readln().toInt()
    val boxes = readln().split(" ").map { it.toInt() }.sorted()

    val result = if (cranes.maxOf { it } < boxes.maxOf { it }) {
        -1
    } else {
        var cnt = 0
        val craneIdxList = cranes.map { crane ->
            boxes.indexOfLast { box -> crane >= box }
        }.toMutableList()
        val visited = MutableList(m) { false }
        var boxCnt = 0
        while (boxCnt != m) {
            craneIdxList.forEachIndexed { i, v ->
                var idx = v
                if (idx == -1) {
                    return@forEachIndexed
                }

                while (visited[idx]) {
                    idx -= 1
                    if (idx == -1) {
                        craneIdxList[i] = idx
                        return@forEachIndexed
                    }
                }

                visited[idx] = true
                boxCnt += 1
                craneIdxList[i] = idx
            }

            cnt += 1
        }

        cnt
    }
    println(result)
}