package boj.union_find

/**
 * 문제 번호: (4195)
 * 문제 이름: (친구 네트워크)
 * 소요 시간(분): (x)
 */

private var idxCount = 1

fun main() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    repeat(t) {
        val n = readLine().toInt()
        val map = HashMap<String, Int>()
        val parent = IntArray(n * 2 + 1) { it }
        val sizeList = IntArray(n * 2 + 1) { 1 }
        repeat(n) {
            val (a, b) = readLine().split(" ")
            mappingNameToIndex(a, map)
            mappingNameToIndex(b, map)

            val (x, y) = map[a]!! to map[b]!!
            val result = unionParent(x, y, parent, sizeList)
            println(result)
        }
        idxCount = 1
    }
    close()
}

private fun mappingNameToIndex(name: String, map: HashMap<String, Int>) {
    if (!map.containsKey(name)) {
        map[name] = idxCount
        idxCount += 1
    }
}

private fun getParent(x: Int, parent: IntArray): Int {
    if (parent[x] == x) return x

    parent[x] = getParent(parent[x], parent)
    return parent[x]
}

private fun unionParent(x: Int, y: Int, parent: IntArray, sizeList: IntArray): Int {
    val a = getParent(x, parent)
    val b = getParent(y, parent)
    return if (a < b) {
        parent[b] = a
        sizeList[a] += sizeList[b]
        sizeList[a]
    } else if (a > b) {
        parent[a] = b
        sizeList[b] += sizeList[a]
        sizeList[b]
    } else {
        sizeList[a]
    }
}