package programmers.KI2021.표편집

import java.util.Stack

class Solution {
    fun solution(n: Int, k: Int, cmd: Array<String>): String {
        val arr = Array<Node?>(n) { null }
        for (i in 0 until n) {
            val pre = if (i - 1 >= 0) i - 1 else null
            val next = if (i + 1 < n) i + 1 else null
            arr[i] = Node(pre, i, next)
        }
        val stack = Stack<Node>()
        var selectedIndex = k

        cmd.forEach {
            when (it) {
                "C" -> {
                    val pre = arr[selectedIndex]?.pre
                    val next = arr[selectedIndex]?.next
                    connectNode(pre, next, arr)

                    val curNode = arr[selectedIndex]!!
                    stack.add(curNode)
                    arr[selectedIndex] = null

                    if (next != null) {
                        selectedIndex = next
                    } else if (pre != null) {
                        selectedIndex = pre
                    }
                }
                "Z" -> {
                    if (stack.isNotEmpty()) {
                        val node = stack.pop()
                        val pre = node.pre
                        val cur = node.cur
                        val next = node.next

                        arr[cur] = node
                        connectNode(pre, cur, arr)
                        connectNode(cur, next, arr)
                    }
                }
                else -> {
                    val (c, cnt) = it.split(" ")
                    repeat(cnt.toInt()) {
                        when (c) {
                            "D" -> {
                                val next = arr[selectedIndex]?.next
                                if (next != null) {
                                    selectedIndex = next
                                }

                            }
                            "U" -> {
                                val pre = arr[selectedIndex]?.pre
                                if (pre != null) {
                                    selectedIndex = pre
                                }
                            }
                            else -> throw Exception("No cmd")
                        }
                    }
                }
            }
        }

        val answer = arr.joinToString("") {
            if (it != null) {
                "O"
            } else {
                "X"
            }
        }

        return answer
    }

    private fun connectNode(pre: Int?, next: Int?, arr: Array<Node?>) {
        if (pre != null) {
            val preNode = arr[pre]!!
            arr[pre] = preNode.copy(next = next)
        }

        if (next != null) {
            val nextNode = arr[next]!!
            arr[next] = nextNode.copy(pre = pre)
        }
    }

    data class Node(
        val pre: Int?,
        val cur: Int,
        val next: Int?
    )
}