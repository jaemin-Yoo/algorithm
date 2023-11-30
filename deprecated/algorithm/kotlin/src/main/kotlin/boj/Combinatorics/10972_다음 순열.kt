package boj.Combinatorics

class 다음순열10972 {
    var n = 0
    lateinit var arr: MutableList<Int>
    fun main() {
        n = readln().toInt()
        arr = readln().split(' ').map { it.toInt() }.toMutableList()
        val result = nextPermutation(arr)
        println(result)
    }

    fun nextPermutation(arr: MutableList<Int>): String {
        var idx = 0
        for (i in arr.lastIndex downTo 1) {
            if (arr[i] > arr[i - 1]) {
                idx = i
                break
            }
        }
        if (idx == 0) {
            return "-1"
        }

        var idx2 = 0
        for (j in arr.lastIndex downTo 1) {
            if (arr[j] > arr[idx - 1]) {
                idx2 = j
                break
            }
        }

        swap(idx - 1, idx2)
        idx2 = arr.lastIndex
        while (idx < idx2) {
            swap(idx, idx2)
            idx += 1
            idx2 -= 1
        }

        return arr.joinToString(" ")
    }

    fun swap(i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }
}