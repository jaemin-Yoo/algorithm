package boj.data_structures

/**
 * 문제 번호: (1406)
 * 문제 이름: (에디터)
 * 소요 시간(분): (x)
 */

data class Node(
    val preIdx: Int?,
    val nextIdx: Int?,
    val data: Char?
)

fun main() = with(System.`in`.bufferedReader()) {
    val s = readLine()
    val m = readLine().toInt()
    val arr = mutableListOf<Node?>(Node(null, 1, null))
    for (i in s.indices) {
        val nextIdx = if (i == s.length - 1) {
            null
        } else {
            i + 2
        }
        arr.add(Node(i, nextIdx, s[i]))
    }
    var cursorIdx = s.length
    var startIdx = 1
    repeat(m) {
        val row = readLine().split(" ")
        when (row[0]) {
            "L" -> cursorIdx = arr[cursorIdx]!!.preIdx ?: return@repeat
            "D" -> cursorIdx = arr[cursorIdx]!!.nextIdx ?: return@repeat
            "B" -> {
                val curNode = arr[cursorIdx] ?: return@repeat
                if (curNode.preIdx == null) return@repeat

                if (curNode.preIdx == 0) {
                    startIdx = curNode.nextIdx ?: -1
                }

                val preNode = arr[curNode.preIdx]!!
                arr[curNode.preIdx] = Node(preNode.preIdx, curNode.nextIdx, preNode.data)

                if (curNode.nextIdx != null) {
                    val nextNode = arr[curNode.nextIdx]!!
                    arr[curNode.nextIdx] = Node(curNode.preIdx, nextNode.nextIdx, nextNode.data)
                }
                arr[cursorIdx] = null
                cursorIdx = curNode.preIdx
            }
            "P" -> {
                val c = row[1][0]
                val curNode = arr[cursorIdx] ?: return@repeat

                if (curNode.preIdx == null && curNode.nextIdx == null) {
                    arr.add(Node(0, null, c))
                    arr[cursorIdx] = Node(null, arr.lastIndex, null)
                    startIdx = arr.lastIndex
                } else if (curNode.nextIdx == null) {
                    arr.add(Node(cursorIdx, null, c))
                    arr[cursorIdx] = Node(curNode.preIdx, arr.lastIndex, curNode.data)
                } else if (curNode.preIdx == null) {
                    val nextNode = arr[curNode.nextIdx] ?: return@repeat
                    arr.add(Node(0, curNode.nextIdx, c))
                    arr[cursorIdx] = Node(null, arr.lastIndex, null)
                    arr[curNode.nextIdx] = Node(arr.lastIndex, nextNode.nextIdx, nextNode.data)
                    startIdx = arr.lastIndex
                } else {
                    val nextNode = arr[curNode.nextIdx]!!
                    arr.add(Node(cursorIdx, curNode.nextIdx, c))
                    arr[cursorIdx] = Node(curNode.preIdx, arr.lastIndex, curNode.data)
                    arr[curNode.nextIdx] = Node(arr.lastIndex, nextNode.nextIdx, nextNode.data)
                }
                cursorIdx = arr[cursorIdx]!!.nextIdx ?: -1
            }
        }
    }

    val result = StringBuilder()
    var node = arr[startIdx]
    while (node != null) {
        result.append(node.data)
        node = arr[node.nextIdx ?: break]!!
    }
    println(result)
    close()
}

/*

abc
8
B
B
B
B
P q
P w
P e
P r


 */