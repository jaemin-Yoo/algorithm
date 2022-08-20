package boj.Greedy

fun main() {
    val n = readln().toInt()
    val arr = mutableListOf<Int>()
    repeat(n) {
        arr.add(readln().toInt())
    }
    arr.sort()

    var result = 0
    var idx = arr.lastIndex
    if (idx == 0) {
        result += arr[0]
    }

    while (idx >= 1) {
        if (arr[idx] >= 0 && arr[idx-1] >= 0) {
            if (arr[idx-1] <= 1) {
                result += arr[idx] + arr[idx-1]
            } else {
                result += arr[idx] * arr[idx-1]
            }
            idx -= 2
        } else if (arr[idx] >= 0 && arr[idx-1] < 0) {
            if (arr[idx] == 0) {
                result += arr[idx] * arr[idx-1]
            } else {
                result += arr[idx] + arr[idx-1]
            }
            idx -= 2
        } else {
            result += arr[idx] * arr[idx-1]
            idx -= 2
        }



        result += if (arr[idx-1] <= 1) {
            arr[idx] + arr[idx-1]
        } else if (arr[idx] == 0) {
            0
        } else {
            arr[idx] * arr[idx-1]
        }
        idx -= 2
    }
    println(result)
}