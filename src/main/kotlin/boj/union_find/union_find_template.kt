package boj.union_find

fun main() {
    val parent = IntArray(11)
    for (i in 1 until 11) {
        parent[i] = i
    }

    unionParent(1, 2, parent)
    unionParent(2, 3, parent)
    unionParent(3, 4, parent)
    unionParent(5, 6, parent)
    unionParent(6, 7, parent)
    unionParent(7, 8, parent)

    println("1과 5는 연결되어 있나요? ${isSameParent(1, 5, parent)}")
    unionParent(1, 5, parent)
    println("1과 5는 연결되어 있나요? ${isSameParent(1, 5, parent)}")
}

// 부모 노드를 찾는 함수
private fun getParent(x: Int, parent: IntArray): Int {
    if (parent[x] == x) return x

    parent[x] = getParent(parent[x], parent)
    return parent[x]
}

// 두 부모 노드를 합치는 함수
private fun unionParent(x: Int, y: Int, parent: IntArray) {
    val a = getParent(x, parent)
    val b = getParent(y, parent)
    if (a < b) {
        parent[b] = a
    } else {
        parent[a] = b
    }
}

// 같은 부모를 가지는지 확인
private fun isSameParent(x: Int, y: Int, parent: IntArray): Boolean {
    val a = getParent(x, parent)
    val b = getParent(y, parent)
    return a == b
}