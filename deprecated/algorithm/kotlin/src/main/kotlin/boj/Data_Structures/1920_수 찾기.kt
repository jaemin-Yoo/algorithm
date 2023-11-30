package boj.Data_Structures.수찾기1920

fun main() {
    val n = readln().toInt()
    val list1 = readln().split(" ").map { it.toInt() }.sorted().toIntArray()
    val m = readln().toInt()
    val list2 = readln().split(" ").map { it.toInt() }

    for (i in list2) {
        println(list1.binarySearch(i))
    }
}

fun IntArray.binarySearch(target: Int): Int {
    var low = 0
    var high = this.lastIndex
    var mid: Int

    while (low <= high) {
        mid = (low + high) / 2

        when {
            this[mid] < target -> low = mid + 1
            this[mid] > target -> high = mid - 1
            this[mid] == target -> return 1
        }
    }

    return 0
}