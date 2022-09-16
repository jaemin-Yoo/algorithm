package boj.Greedy

fun main() {
    val n = readln().toInt()
    val arr = mutableListOf<Int>()
    repeat(n) {
        arr.add(readln().toInt())
    }
    arr.sortDescending()
    val negativeCnt = arr.count { it < 0 }
    var negativeState = false
    var result = 0
    var i = 0
    while (i <= arr.lastIndex) {
        if (i == arr.lastIndex) {
            result += arr[i]
            break
        }

        if (arr[i] > 0) {
            if (arr[i+1] > 1) {
                result += arr[i] * arr[i+1]
                i += 2
                continue
            }
        } else if (arr[i] == 0) {
            if (arr[i+1] < 0 && negativeCnt % 2 == 1) {
                negativeState = true
                i += 2
                continue
            }
        } else if (arr[i] < 0) {
            if (!negativeState && negativeCnt % 2 == 1) {
                result += arr[i]
                negativeState = true
                i += 1
                continue
            }

            if (arr[i+1] < 0) {
                result += arr[i] * arr[i+1]
                i += 2
                continue
            }
        }

        result += arr[i]
        i += 1
    }
    println(result)
}