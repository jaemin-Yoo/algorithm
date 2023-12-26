package boj.priority_queue

fun main() = with(System.`in`.bufferedReader()) {
    val q = CustomPriorityQueue()

    q.push(4)
    q.push(8)
    q.push(6)
    q.push(3)
    q.push(1)
    q.push(5)
    q.push(2)
    q.push(9)
    q.push(7)

    println(q.pop())
    println(q.pop())
    println(q.pop())
    println(q.pop())
    println(q.pop())
    println(q.pop())
    println(q.pop())
    println(q.pop())
    println(q.pop())

    close()
}

class CustomPriorityQueue {
    private val arr = mutableListOf(-1) // 인덱스 1부터 시작

    fun push(data: Int) {
        arr.add(data) // 맨 마지막 위치에 데이터 추가

        var n = arr.lastIndex
        var parentIdx = n / 2
        while (arr[parentIdx] > arr[n]) { // 부모 노드보다 작으면 계속 바꾸기
            swap(arr, parentIdx, n)
            n = parentIdx
            parentIdx = n / 2
        }
    }

    fun pop(): Int {
        swap(arr, 1, arr.lastIndex) // 첫번째 원소와 마지막 원소를 스왑한 뒤
        val result = arr.removeLast() // 마지막 원소 반환

        var n = 1
        while (true) { // 바꾼 원소의 자식 노드들을 비교해 자신보다 작으면 스왑
            val childIdx = getMinNodeIndex(arr, 2 * n, 2 * n + 1) ?: break
            if (arr[n] <= arr[childIdx]) break

            swap(arr, n, childIdx)
            n = childIdx
        }

        return result
    }

    private fun swap(arr: MutableList<Int>, a: Int, b: Int) {
        val temp = arr[a]
        arr[a] = arr[b]
        arr[b] = temp
    }

    private fun getMinNodeIndex(arr: MutableList<Int>, a: Int, b: Int): Int? {
        return if (a >= arr.size) {
            null
        } else if (b >= arr.size) {
            a
        } else {
            if (arr[a] > arr[b]) {
                b
            } else {
                a
            }
        }
    }
}